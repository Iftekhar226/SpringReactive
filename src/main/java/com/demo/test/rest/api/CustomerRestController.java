package com.demo.test.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.test.entity.Customer;
import com.demo.test.service.CustomerServiceImp;

import reactor.core.publisher.Mono;

@RestController
public class CustomerRestController {
	@Autowired
	private CustomerServiceImp ser;
	@GetMapping(value="/get/{id}",produces= {"application/json"})
	public Mono<Customer> get(@PathVariable("id") int id)
	{
		Mono<Customer> a = ser.getCustomerById(id);
		return a;
	}
	@GetMapping(value="/get",produces= {"application/json"})
	public Mono<List<Customer>> get()
	{
		Mono<List<Customer>> a = ser.getCustomerAll();
		return a;
	}
	@DeleteMapping(value="/delete/{id}",produces= {"application/json"})
	public Mono<String> delete(@PathVariable("id") int id)
	{
		Mono<String> a = ser.deleteCustomerid(id);
		return a;
	}
	@PostMapping(value="/save",produces= {"application/json"})
	public Mono<String> save(@RequestBody Customer cus)
	{
		System.out.println("\n\n\n"+cus+"\n\n\n");
		Mono<String> a = ser.save(cus);
		return a;
	}
	@PutMapping(value="/update",produces= {"application/json"})
	public Mono<String> update(@RequestBody Customer cus)
	{
		System.out.println("\n\n\n"+cus+"\n\n\n");
		Mono<String> a = ser.update(cus);
		return a;
	}
}
