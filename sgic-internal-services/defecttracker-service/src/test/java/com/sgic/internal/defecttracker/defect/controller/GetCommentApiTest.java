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

//	@Before
//	public void setup() throws JSONException {
//		
//	}

	@Test
	public void getCareerDevelopmentPlanCompanySuccessfull() throws IOException, RestClientException {

		//String newUser = "INSERT INTO defecttracker.files (id,data,defect_id,file_name,file_type) VALUES (2,'131000',20,'aerial_view_of.jpg', 'image/jpeg')";
		//jdbcTemplate.execute(newUser);
		ResponseEntity<String> response = 
				testRestTemplate.exchange("http://localhost:8081/defect" + "/downloadFile/1",
				HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class);
		Object body = "[{131526}]";
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}


	@After                   
	public void tearDown() {
	}
	
	 public final class GetCommentApiTestConstant{
		    
		    public GetCommentApiTestConstant() {
		    }
		    
		    private static final String GET_COMMENT_API_TEST_RESPONSE =
		        "[{131526}]";
		  }
		}