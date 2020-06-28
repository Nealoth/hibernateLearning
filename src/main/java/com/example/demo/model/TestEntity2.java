package com.example.demo.model;

import javax.persistence.*;

@Entity
public class TestEntity2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String stg;

	@OneToOne(fetch = FetchType.LAZY)
	private TestEntity testEntity;

	public TestEntity2() {
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

	public TestEntity getTestEntity() {
		return testEntity;
	}

	public void setTestEntity(TestEntity testEntity) {
		this.testEntity = testEntity;
	}

	@Override
	public String toString() {
		return "TestEntity2{" +
				"id=" + id +
				", stg='" + stg + '\'' +
				", testEntityId=" + testEntity.getId() +
				'}';
	}
}
