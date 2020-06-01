package com.supplyworld.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.supplyworld.services.OrderService;

@RestController
public class OrderController {
	
	@GetMapping("order/{id}/{quantity}")
	@ResponseBody
	public int receiveOrder(@PathVariable int id, @PathVariable int quantity) {
		return OrderService.createOrder(id, quantity);
	}
}
