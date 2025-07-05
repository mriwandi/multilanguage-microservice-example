package com.example.user.client;

import com.example.user.dto.request.ListingCreateRequest;
import com.example.user.dto.response.ApiListingResponse;
import com.example.user.dto.response.ApiListingsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class ListingClient {
	private final RestTemplate restTemplate = new RestTemplate();

	@Value("${listing.service.base-url}")
	private String baseUrl;

	public ApiListingsResponse getListings(int page, int size, Long userId) {
		String url = baseUrl + "?page_num=" + page + "&page_size=" + size;
		if (userId != null) url += "&user_id=" + userId;
		return restTemplate.getForObject(url, ApiListingsResponse.class);
	}

	public ApiListingResponse createListing(ListingCreateRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		// Convert to form-encoded body
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("user_id", String.valueOf(request.getUserId()));
		body.add("listing_type", request.getListingType());
		body.add("price", String.valueOf(request.getPrice()));

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

		return restTemplate.postForObject(baseUrl, entity, ApiListingResponse.class);
	}
}
