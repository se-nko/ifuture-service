package com.ifuture.service.web.controller;

import com.ifuture.service.web.dto.AmountRequest;
import com.ifuture.service.web.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {

	private final AccountService service;

	@PostMapping("/amount/add")
	@ResponseBody
	public void addAmount(@Valid @RequestBody AmountRequest account) {
		service.addAmount(account.getId(), account.getValue());
	}

	@GetMapping("/amount/{id}")
	@ResponseBody
	public Long getAmount(@PathVariable Integer id) {
		return service.getAmount(id);
	}

}
