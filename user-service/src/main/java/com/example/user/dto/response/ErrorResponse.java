package com.example.user.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
	private boolean result;
	private Object errors;
}
