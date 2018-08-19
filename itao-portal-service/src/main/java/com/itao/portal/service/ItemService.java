package com.itao.portal.service;


import com.itao.portal.pojo.ItemBaseInfo;

public interface ItemService {

    ItemBaseInfo getItemById(Long itemId);

    String getItemDescById(Long itemId);

    String getItemParam(Long itemId);
}
