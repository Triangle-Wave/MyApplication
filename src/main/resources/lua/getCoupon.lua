--local shopId = KEYS[1]
--local pattern = 'COUPON:' .. shopId .. ':*'
--local keys = redis.call('KEYS', pattern)
--local values = {}
--for _, key in pairs(keys) do
--    local value = redis.call('GET', key)
--    table.insert(values, value)
--end
--return values
local shopId = KEYS[1]
local pattern = 'COUPON:' .. shopId .. ':*'
local values = {}
local cursor = "0"
repeat
    local result = redis.call('SCAN', cursor, 'MATCH', pattern)
    cursor = result[1]
    local keys = result[2]
    for _, key in pairs(keys) do
        local value = redis.call('GET', key)
        table.insert(values, value)
    end
until cursor == "0"
return values
