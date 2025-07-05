package com.example.user.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ListingCreateRequest {
	@NotNull(message = "user_id is required")
	private Long userId;

	@NotBlank(message = "listing_type is required")
	private String listingType;

	@NotNull(message = "price is required")
	@Min(value = 1, message = "price must be greater than zero")
	private Integer price;
}
