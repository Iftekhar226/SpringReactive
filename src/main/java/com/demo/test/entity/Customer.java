package com.demo.test.entity;




public class Customer {

	private Integer customerID;
	private String customerName;
	private String contactName;
	private String country;
	private Integer locationCode ;
	private String state;
	private Integer ss;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer customerID, String customerName, String contactName, String country, Integer locationCode,
			String state, Integer ss) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.contactName = contactName;
		this.country = country;
		this.locationCode = locationCode;
		this.state = state;
		this.ss = ss;
	}
	public Customer(Integer customerID, String customerName, String contactName, String country, Integer locationCode,
			 Integer ss,String state) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.contactName = contactName;
		this.country = country;
		this.locationCode = locationCode;
		this.state = state;
		this.ss = ss;
	}
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(Integer locationCode) {
		this.locationCode = locationCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getSs() {
		return ss;
	}
	public void setSs(Integer ss) {
		this.ss = ss;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", contactName=" + contactName
				+ ", country=" + country + ", locationCode=" + locationCode + ", state=" + state + ", ss=" + ss + "]";
	}
}
