package com.demo.test.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.test.entity.Customer;

import reactor.core.publisher.Mono;

@Repository
public class CustomerRepoDto {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final static String get_by_id="Select * from Customer where customerid = ?";
	private final static String getAll="Select * from Customer";
	private final static String delete="delete from Customer where customerid=?";
	private final static String insert="INSERT INTO customer (customerid, contact_name, country, customer_name, location_code, ss, state) VALUES (?,?,?,?,?,?,?);";
    private final static String update_statement="UPDATE customer SET contact_name = ?, country = ?, customer_name = ?, location_code = ?, ss = ?, state =?  WHERE customerid = ?;"
    		+ "";
	public Mono<Customer> getCustomer(int id)
	{
		Customer r = jdbcTemplate.queryForObject(get_by_id , (rs,rowMap)->{
			return new Customer(rs.getInt("customerid"),rs.getString("customer_name"),rs.getString("contact_name"),rs.getString("country"),rs.getInt("location_code"),rs.getString("state"),rs.getInt("ss"));
		} ,id);
		Mono<Customer> just = Mono.just(r);
		return just;
	}
	public Mono<List<Customer>> getCustomerAll()
	{
		 List<Customer> r = jdbcTemplate.query(getAll, (rs,rowMap)->{
			return new Customer(rs.getInt("customerid"),rs.getString("customer_name"),rs.getString("contact_name"),rs.getString("country"),rs.getInt("location_code"),rs.getString("state"),rs.getInt("ss"));
		} );
		Mono<List<Customer>> just = Mono.just(r);
		return just;
	}
	public Mono<String> deleteCustomerById(int id)
	{
		int st=0;
		 st = jdbcTemplate.update(delete,id);
		 if(st>0)
		return Mono.just("delete only "+st+" row");
		 else
			 return Mono.just("something went wrong  ");
	}
	public Mono<String> save(Customer cus)
	{
		int st=0;
		 st = jdbcTemplate.update(insert,new Object[]{cus.getCustomerID(),cus.getCustomerName(),cus.getCountry(),cus.getContactName(),cus.getLocationCode(),cus.getSs(),cus.getState()});
		 if(st>0)
		return Mono.just(" Only "+st+" row effected ");
		 else
			 return Mono.just("something went wrong  ");
	}
	public Mono<String> update(Customer cus)
	{
		int st=0;
		 st = jdbcTemplate.update(update_statement,new Object[]{cus.getCustomerName(),cus.getCountry(),cus.getContactName(),cus.getLocationCode(),cus.getSs(),cus.getState(),cus.getCustomerID()});
		 if(st>0)
		return Mono.just(" Only "+st+" row effected ");
		 else
			 return Mono.just("something went wrong  ");
	}
}
