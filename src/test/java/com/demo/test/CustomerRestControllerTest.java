package com.demo.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.RequestBodySpec;

import com.demo.test.entity.Customer;
import com.demo.test.service.CustomerServiceImp;

import reactor.core.publisher.Mono;

@WebFluxTest
public class CustomerRestControllerTest {
	@Autowired
	private WebTestClient client;

	
	@MockBean
	private CustomerServiceImp ser;
	@Test
	public void get()
	{
		Customer cus=new Customer(1,"ab","ab","ab",1,1 ,"ab");
		Mono<Customer> mc=  Mono.just(cus);
		Mockito.when(ser.getCustomerById(1)).thenReturn(mc);
		client.get().uri("/get/1")
		.accept(MediaType.APPLICATION_JSON)
		.exchange().expectStatus().
		isOk().expectBody()
		.jsonPath("$.customerID").isEqualTo(1)
		.jsonPath("$.country").isEqualTo("ab")
		.jsonPath("$.ss").isEqualTo(1)
		.jsonPath("$.locationCode").isEqualTo(1)
		.jsonPath("$.state").isEqualTo("ab")
		.jsonPath("$.contactName").isEqualTo("ab")
		.jsonPath("$.customerName").isEqualTo("ab");
	}
	@Test
	public void insert()
	{
		Customer cus=new Customer(1,"ab","ab","ab",1,1 ,"ab");
		Mono<Customer> mc=  Mono.just(cus);
		Mono<String> re= Mono.just("success");
		Mockito.when(ser.save(cus)).thenReturn(re);
		client.post().uri("/save")
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.body(mc,Customer.class)
		.exchange()
		.expectStatus().
		isOk();
			}
	@Test
	public void update()
	{
		Customer cus=new Customer(2,"abc","abc","abc",2,2 ,"abc");
		Mono<Customer> mc=  Mono.just(cus);
		Mono<String> re= Mono.just("success");
		Mockito.when(ser.update(cus)).thenReturn(re);
		client.put().uri("/update")
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.body(mc,Customer.class)
		.exchange()
		.expectStatus().
		isOk();
			}
	@Test
	public void delete()
	{
		Mono<String> re= Mono.just("success");
		int id=1;
		Mockito.when(ser.deleteCustomerid(id)).thenReturn(re);
		 client.delete().uri("/delete/"+id)
		 .accept(MediaType.APPLICATION_JSON_UTF8)
		 .exchange()
		.expectStatus()
		.isOk();
			}

}
