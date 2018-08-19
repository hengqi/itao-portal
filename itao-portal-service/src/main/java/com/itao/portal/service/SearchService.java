package com.itao.portal.service;

import com.itao.search.shard.dto.SolrSearchResult;

public interface SearchService {

    SolrSearchResult search(String queryString, int page);
}
