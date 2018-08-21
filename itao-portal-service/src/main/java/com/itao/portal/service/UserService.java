package com.itao.portal.service;

import com.itao.portal.pojo.ITaoUserDO;

public interface UserService {

    ITaoUserDO getUserByToken(String token);
}
