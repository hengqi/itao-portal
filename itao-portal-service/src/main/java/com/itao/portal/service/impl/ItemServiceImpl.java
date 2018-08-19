package com.itao.portal.service.impl;

import com.itao.portal.integration.ItemIntegration;
import com.itao.portal.pojo.ItemBaseInfo;
import com.itao.portal.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    ItemIntegration itemIntegration;


    @Override
    public ItemBaseInfo getItemById(Long itemId) {
        return itemIntegration.getItemInfo(itemId);
    }

    @Override
    public String getItemDescById(Long itemId) {
        return itemIntegration.getItemDesc(itemId);
    }

    @Override
    public String getItemParam(Long itemId) {
        return itemIntegration.getItemParamItem(itemId);
    }
}
