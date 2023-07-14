# MyApplication
## 后台运行
### 使用nohup命令让jar在后台运行  
```nohup java -jar /home/MyProjects/Java/jar/MyApplication-jdk8.jar > /home/logs/store.log 2>&1  &```
### 使用ps -ef命令检查正在运行的jar  
```ps -ef | grep store.jar```
### 使用kill命令停止运行  
```kill -9 xxxxx(第一个数字)```
