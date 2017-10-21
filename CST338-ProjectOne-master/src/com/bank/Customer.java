package com.bank;

public class Customer {
	private String name;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String toString(){
		String str = "Name : " + name + "\n";
		str += "Address: " + address + "\n";
		str += "Zipcode: " + zipCode + "\n";
		str += "SSN: " + SSN + "\n";
		return str;
	}
	private int zipCode;
	private String SSN;
	
}
