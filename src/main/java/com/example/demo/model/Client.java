package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@FilterDef(
		name = "doubleFilter",
		parameters = @ParamDef(name = "doubleParam", type = "double"

		)
)
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column
	private Integer age;

	@Column
	private Double height;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "deleted")
	private Boolean deleted;

	@Filter(
			name = "doubleFilter",
			condition = "balance = 0"
	)
	@OneToMany(mappedBy = "client")
	private List<BankAccount> nullBankAccounts;

	@OneToMany(mappedBy = "client")
	@Filter(
			name = "doubleFilter",
			condition = "balance > :doubleParam"
	)
	private List<BankAccount> majorBankAccounts;

	@Filter(
			name = "doubleFilter",
			condition = "balance < :doubleParam"
	)
	@OneToMany(mappedBy = "client")
	private List<BankAccount> minorBankAccounts;

}
