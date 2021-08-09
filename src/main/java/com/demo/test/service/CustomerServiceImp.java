package com.demo.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.test.entity.Customer;
import com.demo.test.repo.CustomerRepoDto;

import reactor.core.publisher.Mono;
@Service
public class CustomerServiceImp {
	@Autowired
	private CustomerRepoDto customerRepo;
	
	public Mono<Customer> getCustomerById(int id)
	{
		return Mono.just("").flatMap(d->{
		return customerRepo.getCustomer(id);
		});
				
				
	}
	public Mono<List<Customer>> getCustomerAll()
	{
		Mono<List<Customer>> m = Mono.just("").flatMap(d->{
			return this.customerRepo.getCustomerAll();
		});
		return m;
	}
	public Mono<String> deleteCustomerid(int id)
	{
		Mono<String> m = Mono.just("").flatMap(d->{
			return this.customerRepo.deleteCustomerById(id);
		});
		return m;
	}
	public Mono<String> save(Customer cus)
	{
		Mono<String> m = Mono.just("").flatMap(d->{
			return this.customerRepo.save(cus);
		});
		return m;
	}
	public Mono<String> update(Customer cus)
	{
		Mono<String> m = Mono.just("").flatMap(d->{
			return this.customerRepo.update(cus);
		});
		return m;
	}
}
