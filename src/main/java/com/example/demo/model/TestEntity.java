package com.example.demo.model;

import javax.persistence.*;

@Entity
public class TestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String stg;

	@OneToOne(mappedBy = "testEntity", fetch = FetchType.LAZY)
	private TestEntity2 testEntity2;

	public TestEntity() {
	}

	public TestEntity(String stg) {
		this.stg = stg;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setStg(String stg) {
		this.stg = stg;
	}

	public String getStg() {
		return stg;
	}

//	@Override
//	public String toString() {
//		return "TestEntity{" +
//				"id=" + id +
//				", stg='" + stg + '\'' +
//				", testEntity2=" + testEntity2.getId() +
//				'}';
//	}
}
