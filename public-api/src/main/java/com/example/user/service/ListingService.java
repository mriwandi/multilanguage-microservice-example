package com.example.user.service;

import com.example.user.dto.request.ListingCreateRequest;
import com.example.user.dto.response.ApiListingResponse;
import com.example.user.dto.response.ApiListingsResponse;

public interface ListingService {
	ApiListingsResponse getListings(int pageNum, int pageSize, Long userId);
	ApiListingResponse createListing(ListingCreateRequest request);
}
