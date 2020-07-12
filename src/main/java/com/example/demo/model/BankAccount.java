package com.example.demo.model;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bank_accounts")
@FilterDef(
		name = "doubleFilter",
		parameters = @ParamDef(name = "doubleParam", type = "double"

		)
		,
		defaultCondition="balance > :doubleParam"
)
public class BankAccount {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Double balance;

	@ManyToOne
	private Client client;

}
