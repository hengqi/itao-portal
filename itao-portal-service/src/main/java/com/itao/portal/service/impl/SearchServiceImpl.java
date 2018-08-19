package com.itao.portal.service.impl;

import com.itao.portal.integration.SearchIntegration;
import com.itao.portal.service.SearchService;
import com.itao.search.shard.dto.SolrSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

    private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

    @Autowired
    SearchIntegration searchIntegration;


    @Override
    public SolrSearchResult search(String queryString, int page) {
        // 调用taotao-search的服务
        // 查询参数
//        Map<String, String> param = new HashMap<>();
//        param.put("q", queryString);
//        param.put("page", page + "");
        try {
            // 调用服务
//            String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
//            // 把字符串转换成java对象
//            TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, SolrSearchResult.class);
//            if (taotaoResult.getStatus() == 200) {
//                SolrSearchResult result = (SolrSearchResult) taotaoResult.getData();
//                return result;
//            }
            SolrSearchResult searchResult = searchIntegration.search(queryString, page);
            return searchResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
