package com.example.user.dto.response;

import com.example.user.dto.ListingDTO;
import lombok.Data;

@Data
public class ApiListingResponse {
	private boolean result;
	private ListingDTO listing;
}
