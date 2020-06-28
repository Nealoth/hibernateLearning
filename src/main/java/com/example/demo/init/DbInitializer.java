package com.example.demo.init;

import com.example.demo.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.model.SkinColor.*;

@Component
public class DbInitializer implements CommandLineRunner {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void run(String... args) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		TestEntity testEntity = new TestEntity();
		testEntity.setStg("123");
		session.save(testEntity);

		TestEntity2 testEntity2 = new TestEntity2();
		testEntity2.setStg("1233");
		testEntity2.setTestEntity(testEntity);
		session.save(testEntity2);


		Cat cat = new Cat();
		cat.setName("Маркиз");
		cat.setAge(10);
		cat.setSkinColor(WHITE);
		session.save(cat);

		Cat catTestAvg = new Cat();
		catTestAvg.setName("Старейшина");
		catTestAvg.setAge(22);
		catTestAvg.setSkinColor(WHITE);
		session.save(catTestAvg);


		Cat catTestAvg2 = new Cat();
		catTestAvg2.setName("Консильери старейшины");
		catTestAvg2.setAge(20);
		catTestAvg2.setSkinColor(BLACK);
		session.save(catTestAvg2);

		Kitten kitten = new Kitten();
		kitten.setName("Тимоша");
		kitten.setAge(1);
		kitten.setParent(cat);
		kitten.setSkinColor(WHITE);
		session.save(kitten);

		Kitten kitten2 = new Kitten();
		kitten2.setName("Мурка");
		kitten2.setParent(cat);
		kitten2.setAge(2);
		kitten2.setSkinColor(BLACK);
		session.save(kitten2);


		Tiger tiger = new Tiger();
		tiger.setName("Убийца");
		tiger.setAge(8);
		tiger.setSkinColor(STRIPED);
		session.save(tiger);





		transaction.commit();
		session.close();
	}
}
