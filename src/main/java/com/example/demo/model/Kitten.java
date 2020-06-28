package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Kitten extends Cat {

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Cat parent;

	public Cat getParent() {
		return parent;
	}

	public void setParent(Cat parent) {
		this.parent = parent;
	}
}
