package com.itao.portal.service;

import com.itao.common.result.ITaoResult;
import com.itao.portal.pojo.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CartService {

    ITaoResult addCartItem(long itemId, int num,
                           HttpServletRequest request, HttpServletResponse response);

    List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);

    void deleteCartItem(Long itemId, HttpServletRequest request, HttpServletResponse response);
}
