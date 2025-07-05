package com.example.user.client;

import com.example.user.dto.request.UserCreateRequest;
import com.example.user.dto.response.ApiUserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {
	private final RestTemplate restTemplate = new RestTemplate();

	@Value("${user.service.base-url}")
	private String baseUrl;

	public ApiUserResponse getUserById(Long id) {
		return restTemplate.getForObject(baseUrl + "/" + id, ApiUserResponse.class);
	}

	public ApiUserResponse createUser(UserCreateRequest request) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<UserCreateRequest> req = new HttpEntity<>(request, headers);

		return restTemplate.postForObject(baseUrl, req, ApiUserResponse.class);
	}
}
