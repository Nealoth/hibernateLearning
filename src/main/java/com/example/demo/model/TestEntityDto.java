package com.example.demo.model;

public class TestEntityDto {

	private String stg;

	public String getStg() {
		return stg;
	}

	public void setStg(String stg) {
		this.stg = stg;
	}

	public TestEntityDto(String stg) {
		this.stg = stg;
	}

	@Override
	public String toString() {
		return "TestEntityDto{" +
				"stg='" + stg + '\'' +
				'}';
	}
}
