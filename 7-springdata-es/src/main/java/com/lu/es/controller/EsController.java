package com.lu.es.controller;

import com.lu.es.domain.City;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/10/17 19:28
 **/
@RestController
public class EsController {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @GetMapping("/add")
    public String add(){
        City city = new City(2L, "上海", "ok");
        ArrayList<City> list = new ArrayList<>();
        list.add(city);
        elasticsearchRestTemplate.save(list);
        return "success";
    }
    @GetMapping("/search")
    public List search(){
        Criteria criteria = new Criteria("cityName").is("北京");
        CriteriaQuery query = new CriteriaQuery(criteria);
        SearchHits<City> search = elasticsearchRestTemplate.search(query, City.class);
        List<City> collect = search.get().map(e -> e.getContent()).collect(Collectors.toList());
        return collect;
    }
    /**
     * @Description: 复杂的查询   NativeSearchQuery
     * @Author: 雨同我
     * @DateTime: 2022/10/18 15:34
    */

    @GetMapping("/complex-search")
    public List complexSearch(){
        String firstName="北";
        Query query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("cityName", firstName))
                .build();
        SearchHits<City> search = elasticsearchRestTemplate.search(query, City.class);
        return search.get().map(SearchHit::getContent).collect(Collectors.toList());
    }
}
