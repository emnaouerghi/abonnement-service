package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ACTIVITY-SERVICE")
interface ActivityService{
	@GetMapping("/find-activity/{id}")
	public Activity findActivityById(@PathVariable(name="id") Long id);
}
