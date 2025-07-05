package com.example.user.service.impl;

import com.example.user.client.ListingClient;
import com.example.user.client.UserClient;
import com.example.user.dto.request.ListingCreateRequest;
import com.example.user.dto.response.ApiListingResponse;
import com.example.user.dto.response.ApiListingsResponse;
import com.example.user.dto.response.ApiUserResponse;
import com.example.user.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListingServiceImpl implements ListingService {
	private final ListingClient listingClient;
	private final UserClient userClient;

	@Override
	public ApiListingsResponse getListings(int pageNum, int pageSize, Long userId) {
		ApiListingsResponse listings = listingClient.getListings(pageNum, pageSize, userId);

		listings.getListings().forEach(listing -> {
			ApiUserResponse userResponse = userClient.getUserById(listing.getUserId());
			listing.setUser(userResponse.getUser());
		});

		return listings;
	}

	@Override
	public ApiListingResponse createListing(ListingCreateRequest request) {
		userClient.getUserById(request.getUserId());

		return listingClient.createListing(request);
	}
}
