package com.ifuture.service.web.dto;

import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Value
public class AmountRequest {

	@NotNull @Min(value = 0) Integer id;
	@NotNull @Min(value = 0) Long value;

}
