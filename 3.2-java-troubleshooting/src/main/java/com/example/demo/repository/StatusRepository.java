package com.example.demo.repository;



import java.util.Map;

import javax.annotation.PostConstruct;

import com.example.demo.dto.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class StatusRepository {

    private static final String KEY = "Status";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, Status> hashOperations;

    @Autowired
    public StatusRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    public void save(Status status) {
        hashOperations.put(KEY, status.getId(), status);
    }

    public Status find(Long id) {
        return hashOperations.get(KEY, id);
    }

    public Map<Long, Status> findAll() {
        return hashOperations.entries(KEY);
    }

    public void update(Status status) {
        hashOperations.put(KEY, status.getId(), status);
    }

    public void delete(Long id) {
        hashOperations.delete(KEY, id);
    }

}

