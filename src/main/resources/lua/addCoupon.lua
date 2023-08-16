local couponKey = KEYS[1]
local couponJson = ARGV[1]
redis.call('set', couponKey, couponJson)
return 1
