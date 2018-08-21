package com.itao.portal.service.impl;

import com.itao.common.result.ITaoResult;
import com.itao.common.utils.CookieUtils;
import com.itao.common.utils.JsonUtils;
import com.itao.portal.integration.ItemIntegration;
import com.itao.portal.pojo.CartItem;
import com.itao.portal.pojo.ItemBaseInfo;
import com.itao.portal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ItemIntegration itemIntegration;


    @Override
    public ITaoResult addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response) {
        // 取商品信息
        CartItem cartItem = null;
        // 取购物车商品列表
        List<CartItem> itemList = getCartItemList(request);
        // 判断购物车商品列表中是否存在此商品
        for (CartItem cItem : itemList) {
            // 如果存在此商品
            if (cItem.getId() == itemId) {
                // 增加商品数量
                cItem.setNum(cItem.getNum() + num);
                cartItem = cItem;
                break;
            }
        }

        if (cartItem == null) {
            cartItem = new CartItem();
            ItemBaseInfo itemInfo = itemIntegration.getItemInfo(itemId);
            cartItem.setId(itemInfo.getId());
            cartItem.setTitle(itemInfo.getTitle());
            cartItem.setImage(itemInfo.getImage() == null ? "" : itemInfo.getImage().split(",")[0]);
            cartItem.setNum(num);
            cartItem.setPrice(itemInfo.getPrice());
            // 添加到购物车列表
            itemList.add(cartItem);
        }
        // 把购物车列表写入cookie
        CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(itemList), true);

        return ITaoResult.ok();
    }

    @Override
    public List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public void deleteCartItem(Long itemId, HttpServletRequest request, HttpServletResponse response) {

    }

    private List<CartItem> getCartItemList(HttpServletRequest request) {
        // 从cookie中取商品列表
        String cartJson = CookieUtils.getCookieValue(request, "TT_CART", true);
        if (cartJson == null) {
            return new ArrayList<>();
        }
        // 把json转换成商品列表
        try {
            List<CartItem> list = JsonUtils.jsonToList(cartJson, CartItem.class);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
