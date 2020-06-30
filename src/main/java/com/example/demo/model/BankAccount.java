package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private BigDecimal balance;

	@ManyToOne
	private Client client;

}
