package com.furenqiang.gulimall.search;

import com.furenqiang.gulimall.search.config.GulimallElasticSearchConfig;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class GulimallSearchApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    @Test
    void testAdd() throws IOException {

        IndexRequest indexRequest=new IndexRequest("user");
        indexRequest.id("1");
        String jsonStr="{\"name\":\"Eric Fu\",\"age\":23}";
        indexRequest.source(jsonStr, XContentType.JSON);
        IndexResponse index = client.index(indexRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(index);
    }

    @Test
    void testBulkAdd() throws IOException {
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("user").id("2")
                .source("{\"name\":\"Stefan Zhou\",\"age\":53}",XContentType.JSON));
        request.add(new IndexRequest("user").id("3")
                .source("{\"name\":\"Bulus Li\",\"age\":63}",XContentType.JSON));
        request.add(new IndexRequest("user").id("4")
                .source("{\"name\":\"Jack Chen\",\"age\":55}",XContentType.JSON));
        client.bulk(request, GulimallElasticSearchConfig.COMMON_OPTIONS);
    }
    @Test
    void testSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //searchSourceBuilder.query(QueryBuilders.matchQuery("name","Eric"));
        //按照年龄聚合
        TermsAggregationBuilder size = AggregationBuilders.terms("aggAgg").field("age").size(3);
        searchSourceBuilder.aggregation(size);
        //按照年龄平均值聚合
        AvgAggregationBuilder field = AggregationBuilders.avg("balanceAvg").field("age");
        searchSourceBuilder.aggregation(field);
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = client.search(searchRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(search.toString());
        Aggregations aggregations = search.getAggregations();
        System.out.println(aggregations.toString());
        Aggregation hit = aggregations.get("hit");
        hit.getName();
    }

}
