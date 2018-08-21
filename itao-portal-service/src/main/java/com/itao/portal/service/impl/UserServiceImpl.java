package com.itao.portal.service.impl;

import com.itao.common.result.ITaoResult;
import com.itao.common.utils.HttpClientUtil;
import com.itao.portal.pojo.ITaoUserDO;
import com.itao.portal.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Value("${SSO_BASE_URL}")
    public String SSO_BASE_URL;

    @Value("${SSO_USER_TOKEN}")
    private String SSO_USER_TOKEN;

    @Value("${SSO_PAGE_LOGIN}")
    public String SSO_PAGE_LOGIN;


    @Override
    public ITaoUserDO getUserByToken(String token) {
        try {
            //调用sso系统的服务，根据token取用户信息
            String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN + token);
            //把json转换成TaotaoREsult
            ITaoResult result = ITaoResult.formatToPojo(json, ITaoUserDO.class);
            if (result.getStatus() == 200) {
                ITaoUserDO user = (ITaoUserDO) result.getData();
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
