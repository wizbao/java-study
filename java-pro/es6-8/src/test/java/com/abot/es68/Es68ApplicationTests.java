package com.abot.es68;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
class Es68ApplicationTests {

	@Resource
	private RestHighLevelClient client;

	@Test
	void contextLoads() {
	}

	@Test
	void indexTest() throws IOException {
		IndexRequest request = new IndexRequest("posts");
		request.id("1");
		String jsonString = "{" +
				"\"user\":\"kimchy22\"," +
				"\"postDate\":\"2013-01-30\"," +
				"\"message\":\"trying out Elasticsearch\"" +
				"}";
		request.source(jsonString, XContentType.JSON).type("_doc");
		IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
	}

}
