package com.example.user.dto.response;

import com.example.user.dto.ListingWithUserDTO;
import lombok.Data;

import java.util.List;

@Data
public class ApiListingsResponse {
	private boolean result;
	private List<ListingWithUserDTO> listings;
}
