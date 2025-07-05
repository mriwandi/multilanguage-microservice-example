package com.example.user.dto;

import lombok.Data;

@Data
public class ListingWithUserDTO extends ListingDTO {
	private UserDTO user;
}
