package com.twave.myapplication.service.impl;

import com.twave.myapplication.controller.exception.fileException.*;
import com.twave.myapplication.entity.ExcelEntity;
import com.twave.myapplication.service.IFileService;
import com.twave.myapplication.util.JSONResult;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.twave.myapplication.constants.StatusCode.*;

/**
 * @author : twave
 * @date : 2023/7/14 17:03
 */
@Service
public class FileServiceImpl implements IFileService {
    @Value("${file.uploadPath}")
    String savePath;

    /**
     * 上传文件的Service层代码<p>
     * Controller调用该方法实现将前端上传的文件存放到文件夹的指定位置<p>
     * FileStateException是自定义的异常类
     *
     * @param file 上传的文件
     * @return 状态值
     */
    @Override
    public JSONResult<String> uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new FileEmptyException("文件为空");
        } else if (file.getSize() > FILE_MAXSIZE) {
            throw new FileSizeException("文件大小超出限制");
        }
        // file对象指向这个路径，判断路径是否存在
        File dir = new File(savePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 获取文件名，保存文件
        File dest = new File(dir, Objects.requireNonNull(file.getOriginalFilename()));
        // 将参数file中的数据写入到空文件中
        System.out.println(dest);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new FileNotExistException("文件读写异常");
        } catch (FileStateException e) {
            throw new FileStateException("文件状态异常");
        }
        return new JSONResult<>(200, "文件上传成功");
    }

    /**
     * 下载文件的Service层代码<p>
     * Controller调用该方法实现文件下载
     *
     * @param fileName 文件名
     * @return
     */
    @Override
    public void downloadFile(HttpServletResponse response, String fileName) {
        File file = new File(savePath + "\\" + fileName);
        // 从文件中获取输入流
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new FileNotExistException("文件不存在");
        }
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
        // 将文件的输入流复制到http响应的输入流中
        try {
            IOUtils.copy(fis, response.getOutputStream());
        } catch (IOException e) {
            throw new FileIoException("文件读写异常");
        }
    }

    /**
     * 解析Excel文件
     *
     * @param file 有效的Excel文件
     */
    public void uploadExcel(MultipartFile file) {
        // 获取文件后缀
        String substring = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
        if (!".xls".equals(substring) && !".xlsx".equals(substring)) {
            throw new FileSuffixException("文件后缀名不正确");
        }
        // 定义工作簿
        XSSFWorkbook workbook;

        try {
            workbook = new XSSFWorkbook(file.getInputStream());
        } catch (IOException e) {
            throw new FileIoException(e);
        }
        // 定义工作表
        XSSFSheet sheets = workbook.getSheetAt(0);
        // 获取第一行的所有字段，创建一个Map来做映射
        Map<Integer, String> indexMap = new HashMap<>();
        for (Cell cell : sheets.getRow(0)) {
            indexMap.put(cell.getColumnIndex(), cell.getStringCellValue());
        }
        System.out.println(indexMap);
        for (Row row : sheets) {
            // 跳过第一行
            if (row.getRowNum() == 0) {
                continue;
            }
            // 创建一个实例对象
            ExcelEntity excelEntity = new ExcelEntity();
            Map<String, String> others = new HashMap<>();
            for (Cell cell : row) {
                // 强制转换为字符串
                // 通过行号获取对应的字段名，用反射来设置值
                String fieldName = indexMap.get(cell.getColumnIndex());
                // 通过反射来设置值
                try {
                    // 获取字段
                    Field field = ExcelEntity.class.getDeclaredField(fieldName);
                    // 设置字段为可以访问
                    field.setAccessible(true);
                    // 获取实体类中的字段类型
                    Class<?> type = field.getType();
                    // 先将所有值设置为字符串，再通过类型转换来设置值
                    if (type == Integer.class) {
                        field.set(excelEntity, Integer.parseInt(translateToString(cell)));
                    } else if (type == String.class) {
                        field.set(excelEntity, translateToString(cell));
                    } else if (type == Float.class) {
                        field.set(excelEntity, Float.parseFloat(translateToString(cell)));
                    }
                } catch (NoSuchFieldException e) {
                    others.put(fieldName, translateToString(cell));
                } catch (IllegalAccessException e) {
                    throw new FileException("文件解析异常");
                }
            }
            excelEntity.setOthers(others.toString());
            System.out.println(excelEntity);
        }
        try {
            workbook.close();
        } catch (IOException e) {
            throw new FileException(e);
        }
    }

    /**
     * 将单元格的值转换为字符串
     *
     * @param cell 单元格
     * @return 单元格的值
     */
    public String translateToString(Cell cell) {
        String cellValue = "";
        switch (cell.getCellType()) {
            case NUMERIC:
                double numericCellValue = cell.getNumericCellValue();
                DecimalFormat df = new DecimalFormat("#");
                cellValue = df.format(numericCellValue);
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case BLANK:
                break;
            case FORMULA:
                cellValue = cell.getCellFormula() + " ";
                break;
        }
        return cellValue;
    }
}
