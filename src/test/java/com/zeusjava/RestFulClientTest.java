package com.zeusjava;

import com.zeusjava.kernel.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by zhaohongxuan
 */
public class RestFulClientTest {
	public static final String REST_SERVICE_URI = "http://localhost:8081/HelloSSM/rest";

	private static final int USER_ID_INSERT = 110; //插入的UserId
	private static final int USER_ID_QUERY = 111; //查询的UserId
	private static final int USER_ID_UPDATE = 112;//更新的UserId

	private RestTemplate restTemplate;
	@Before
	public void setup() throws Exception {
		this.restTemplate = new RestTemplate();
	}

	@Test
	public void createUser() {
		User user = new User(USER_ID_INSERT,"Wanghai","123456");
		ResponseEntity<User> entity= restTemplate.postForEntity(REST_SERVICE_URI+"/user/", user, User.class);
		assertEquals(user.getUserName(),entity.getBody().getUserName());
	}

	@Test
	public  void listAllUsers(){
		List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/user/", List.class);
		assertNotNull(usersMap);
	}

	@Test
	public void getUser(){
		User user = new User(USER_ID_QUERY,"TestGet","123456");
		ResponseEntity<User> entity= restTemplate.postForEntity(REST_SERVICE_URI+"/user/", user, User.class);
		assertEquals(user.getUserName(),entity.getBody().getUserName());
		ResponseEntity<User> entityGet = restTemplate.getForEntity(REST_SERVICE_URI+"/user/"+USER_ID_QUERY, User.class);
		assertEquals("TestGet", entityGet.getBody().getUserName());
		assertEquals(HttpStatus.OK,entityGet.getStatusCode());

	}

	@Test
	public  void updateUser() {
		User user = new User(USER_ID_UPDATE,"TestUpdate","123456");
		ResponseEntity<User> entity= restTemplate.postForEntity(REST_SERVICE_URI+"/user/", user, User.class);
		assertEquals(user.getUserName(),entity.getBody().getUserName());

		User userUpdate  = new User(USER_ID_UPDATE,"UpdateUser","123456");
		restTemplate.put(REST_SERVICE_URI+"/user/"+USER_ID_UPDATE, userUpdate);
		ResponseEntity<User> entityUpdate = restTemplate.getForEntity(REST_SERVICE_URI + "/user/"+USER_ID_UPDATE, User.class);
		assertEquals(userUpdate.getUserName(),entityUpdate.getBody().getUserName());
	}

}
