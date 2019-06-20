package com.sgic.internal.defecttracker.defect.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.io.IOException;
import java.net.URI;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgic.internal.defecttracker.defect.CommentTest;
import com.sgic.internal.defecttracker.defect.controller.dto.CommentData;
import com.sgic.internal.defecttracker.defect.entities.Comments;
import com.sgic.internal.defecttracker.defect.entities.Defect;

public class GetCommentApiTest extends CommentTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Before
	public void setup() throws JSONException {

	}


	@Test
	public void getAllEmployeeSuccessfull() throws IOException, RestClientException {


		CommentData commentData = new CommentData();
		commentData.setComments("hello");
		commentData.setDefectId("1");
		commentData.setCommentId((long) 1);
		commentData.setCommentedDate("2019/06/18 15:25:59");

		Comments comments = new Comments();
		comments.setComments("utghtg");
		comments.setCommentId((long) 1);
		comments.setCommentedDate("2019/06/18 15:25:59");
		Defect defect = new Defect();
		defect.setDefectId(commentData.getDefectId());
		comments.setDefect(defect);
		System.out.println(comments);

		ObjectMapper mapper = new ObjectMapper();

		String jsonComment = mapper.writeValueAsString(comments);


		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<Comments> request = new HttpEntity<>(comments, headers);

		    
		 ResponseEntity<Comments> response  =     testRestTemplate.postForEntity("http://localhost:8080/defect" + "/comment", request, Comments.class);
		  assertEquals(true, response.getBody());
//		testRestTemplate.postForEntity("http://localhost:8080/defect" + "/comment",
//				comments, Comments.class);
//	    assertEquals(HttpStatus.OK, response.getStatusCodeValue());
//	    assertEquals(true, response.getBody().contains("Missing request header"));

	}

	@After
	public void tearDown() {

	}

}
