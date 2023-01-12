package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="USER-SERVICE")
interface UserService{
	@GetMapping("/users/find-user/{id}")
	public User findUserById(@PathVariable(name="id") Long id);
}
