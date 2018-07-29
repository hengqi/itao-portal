package com.itao.portal.integration;

import com.itao.common.result.ActionResult;
import com.itao.common.utils.JsonUtils;
import com.itao.integration.shard.content.ContentAPI;
import com.itao.integration.shard.dto.QueryContentReqDTO;
import com.itao.integration.shard.dto.QueryContentResDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ContentIntegration {

    private static final Logger logger = LoggerFactory.getLogger(ContentIntegration.class);

    @Value("${CONTENT_CID}")
    private String contentCId;

    @Autowired
    ContentAPI contentAPI;

    public List<QueryContentResDTO> getContentList() {
        logger.info("调用integration查询内容列表开始，参数：{}", JsonUtils.objectToJson(contentCId));
        List<QueryContentResDTO> resDTOList = null;
        try {
            QueryContentReqDTO queryContentReqDTO = new QueryContentReqDTO();
            queryContentReqDTO.setContentCid(Long.valueOf(contentCId));
            ActionResult<List<QueryContentResDTO>> actionResult = contentAPI.getContentList(queryContentReqDTO);
            if (!actionResult.isResult()) {
                logger.info("调用integration失败，错误消息：{}", actionResult.getErrorMsg());
            }

            resDTOList = actionResult.getData();
        } catch (Exception e) {
            logger.info("调用integration异常，错误消息：{}", e);
            resDTOList = Collections.emptyList();
        }
        return resDTOList;
    }

}
