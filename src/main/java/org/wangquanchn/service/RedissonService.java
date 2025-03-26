package org.wangquanchn.service;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangquanchn.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedissonService {

    @Autowired
    private RedissonClient redissonClient;

    public String setBucket() {
        RBucket<List<User>> bucket = redissonClient.getBucket("GetBucketKey", JsonJacksonCodec.INSTANCE);

        List<User> value = new ArrayList<>();
        value.add(new User("zhangsan", 18));
        bucket.set(value);

        return String.format("set %s success", value);
    }

    public String getBucket() {
        RBucket<List<User>> bucket = redissonClient.getBucket("GetBucketKey", JsonJacksonCodec.INSTANCE);

        List<User> value = bucket.get();

        return String.format("get GetBucketKey: %s", value);
    }

}
