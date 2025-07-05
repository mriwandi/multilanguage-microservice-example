package com.example.user.controller;

import com.example.user.dto.request.ListingCreateRequest;
import com.example.user.dto.response.ApiListingResponse;
import com.example.user.dto.response.ApiListingsResponse;
import com.example.user.service.ListingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public-api/listings")
@AllArgsConstructor
public class PublicListingController {

	private final ListingService listingService;

	@GetMapping
	public ResponseEntity<ApiListingsResponse> getListings(
		@RequestParam(defaultValue = "1") int page_num,
		@RequestParam(defaultValue = "10") int page_size,
		@RequestParam(required = false) Long user_id
	) {
		return ResponseEntity.ok(listingService.getListings(page_num, page_size, user_id));
	}

	@PostMapping
	public ResponseEntity<ApiListingResponse> createListing(@RequestBody @Valid ListingCreateRequest request) {
		return ResponseEntity.ok(listingService.createListing(request));
	}
}
