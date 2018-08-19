package com.itao.portal.integration;

import com.itao.common.result.ActionResult;
import com.itao.common.utils.JsonUtils;
import com.itao.integration.shard.dto.QueryContentResDTO;
import com.itao.search.shard.SolrSearchAPI;
import com.itao.search.shard.dto.SolrSearchRequestDTO;
import com.itao.search.shard.dto.SolrSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class SearchIntegration {

    private static final Logger logger = LoggerFactory.getLogger(SearchIntegration.class);

    @Autowired
    SolrSearchAPI solrSearchAPI;

    public SolrSearchResult search(String queryString, int page) {
        logger.info("调用integration查询内容列表开始，参数：{}, {}", queryString, page);
        SolrSearchResult solrSearchResult = null;
        try {
            SolrSearchRequestDTO solrSearchRequestDTO = new SolrSearchRequestDTO();
            solrSearchRequestDTO.setQueryString(queryString);
            solrSearchRequestDTO.setPage(page);
            ActionResult<SolrSearchResult> actionResult = solrSearchAPI.search(solrSearchRequestDTO);
            if (!actionResult.isResult()) {
                logger.info("调用integration失败，错误消息：{}", actionResult.getErrorMsg());
            }

            solrSearchResult = actionResult.getData();
        } catch (Exception e) {
            logger.info("调用integration异常，错误消息：{}", e);
        }
        return solrSearchResult;
    }

}
