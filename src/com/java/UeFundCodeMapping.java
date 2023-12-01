package com.java;
import java.util.ArrayList;
import java.util.List;

public class UeFundCodeMapping {

	private Long id;
	private String fundCode;
	
    private static List<String> fundcodes = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	@Override
	public String toString() {
		return "UeFundCodeMapping [id=" + id + ", fundCode=" + fundCode + ", fundcodes = "+ fundcodes +"]";
	}
	public UeFundCodeMapping(Long id, String fundCode) {
		super();
		this.id = id;
		this.fundCode = fundCode;
		fundcodes.add(fundCode);
	}
	
	
}
