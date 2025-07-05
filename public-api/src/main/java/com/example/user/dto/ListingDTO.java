package com.example.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ListingDTO {
	private Long id;

	@JsonProperty("user_id")
	private Long userId;

	@JsonProperty("listing_type")
	private String listingType;

	private Integer price;

	@JsonProperty("created_at")
	private Long createdAt;

	@JsonProperty("updated_at")
	private Long updatedAt;
}
