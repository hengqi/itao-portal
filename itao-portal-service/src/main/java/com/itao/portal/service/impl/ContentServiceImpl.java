package com.itao.portal.service.impl;

import com.itao.common.utils.JsonUtils;
import com.itao.integration.shard.dto.QueryContentResDTO;
import com.itao.portal.integration.ContentIntegration;
import com.itao.portal.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService {

    private static final Logger logger = LoggerFactory.getLogger(ContentServiceImpl.class);

    @Autowired
    ContentIntegration contentIntegration;

    @Override
    public String getContentList() {

        List<QueryContentResDTO> contentList = contentIntegration.getContentList();
        try {
            //取内容列表
            List<Map> resultList = new ArrayList<>();
            //创建一个jsp页码要求的pojo列表
            contentList.forEach(item -> {
                Map map = new HashMap<>();
                map.put("src", item.getPic());
                map.put("height", 240);
                map.put("width", 670);
                map.put("srcB", item.getPic2());
                map.put("widthB", 550);
                map.put("heightB", 240);
                map.put("href", item.getUrl());
                map.put("alt", item.getSubTitle());
                resultList.add(map);
            });

            return JsonUtils.objectToJson(resultList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
