package com.example.demo;

import com.example.demo.model.BankAccount;
import com.example.demo.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@Sql(scripts = {"/truncate.sql"}, executionPhase = BEFORE_TEST_METHOD)
public class FirstTest {

	@Autowired
	private SessionFactory sessionFactory;

	@Test
	@Sql("/basic_inserts.sql")
	void readTestWithoutTransaction() {
		try (Session session = sessionFactory.openSession()) {
			System.out.println("Before query");
			List from_client = session.createQuery("from Client").list();
			final Client client = session.find(Client.class, 1L);
			System.out.println(client);
			System.out.println("After query");
		}
	}

	@Test
	@Sql("/basic_inserts.sql")
	void readTestWithinTransaction() {
		try (Session session = sessionFactory.openSession()) {
			System.out.println("Before query");
			session.beginTransaction();
			final Client client = session.find(Client.class, 1L);
			session.getTransaction().commit();
			System.out.println("After query");
		}
	}

}
