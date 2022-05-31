package com.example.javadesignpattern.adapterPattern.mq.adapter;

import com.example.javadesignpattern.adapterPattern.mq.RebateInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Author saino
 * LastModify 11:10
 */
public class MQAdapter {
    public static RebateInfo filter(String msg, Map<String, String> link) throws JsonProcessingException {
        var objectMapper = new ObjectMapper();
        var map = objectMapper.readValue(msg, Map.class);
        var replaceMap = new HashMap<>();
        // 将消息中的某些字段替换成链接中的字段
        for (var entry : link.entrySet()) {
            if (map.containsKey(entry.getValue())) {
                replaceMap.put(entry.getKey(), map.get(entry.getValue()));
            }
        }

        return objectMapper.readValue(new ObjectMapper().writeValueAsString(replaceMap), RebateInfo.class);
    }
}
