package com.example.demo;

import com.example.demo.model.TestEntity;
import com.example.demo.model.TestEntity2;
import com.example.demo.model.TestEntityDto;
import org.aspectj.weaver.ast.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Component
public class SessionFactoryTestService {

	@Autowired
	private SessionFactory sessionFactory;


	public void test() {

		//подробнее про native query

		Session currentSession = sessionFactory.openSession();
		Transaction transaction = currentSession.beginTransaction();

//		addEntity and addJoin
//		NativeQuery query = currentSession.createSQLQuery("select * from TestEntity t1 join TestEntity2 t2 ON t1.id=t2.testentity_id")
//				.addEntity("t1",TestEntity.class);
////
//		List<TestEntity> list = query.list();
//		list.forEach(System.out::println);
//
//		NativeQuery query = currentSession.createSQLQuery("select {t1.*}, {t2.*} from TestEntity t1 join TestEntity2 t2 ON t1.id=t2.testentity_id")
//				.addEntity("t1",TestEntity.class)
//				.addJoin("t2", "t1.testEntity2");
//////
//		List<Object[]> list = query.list();
//		list.forEach(entity -> Arrays.stream(entity).forEach(System.out::println));





		//named query

//		List fromTestEntity = currentSession.getNamedNativeQuery("fromTestEntity").list();
//		fromTestEntity.forEach(System.out::println);
//
//		NativeQuery namedNativeQuery = currentSession.getNamedNativeQuery("TestEntity.findAll");
//		TestEntity testEntity = (TestEntity) namedNativeQuery.getSingleResult();
//		System.out.println(testEntity);
//
//		NativeQuery query2 = currentSession.getNamedNativeQuery("TestEntity2.findByStg");
//		query2.setParameter("stg", "1233");
//		TestEntity2 testEntity2 = (TestEntity2) query2.getSingleResult();
//		System.out.println(testEntity2);
//
//		Query<TestEntityDto> testEntityToDtoQuery = currentSession.createNamedQuery("testEntityToDto", TestEntityDto.class);
//		TestEntityDto testEntityDto = testEntityToDtoQuery.getSingleResult();
//		System.out.println(testEntityDto);




//		HQL
//		List list = currentSession.createQuery("select te from TestEntity as te").list();
		List<TestEntity> list = currentSession.createQuery("select te from TestEntity te", TestEntity.class).list();

//		List list = currentSession.createQuery("from TestEntity as te, TestEntity2 as te2").list();
//		Object[] next = (Object[]) list.iterator().next();
//		Arrays.stream(next).forEach(System.out::println);

//		List list = currentSession.createQuery("select testEntity.id, testEntity.stg from TestEntity as testEntity").list();
//		Query query = currentSession.createQuery("select id, stg from TestEntity where id = :id");
//		query.setParameter("id", 1L);
//		List list = query.list();
//		List list = currentSession.createQuery("select testEntity2 from TestEntity").list();
//		List list = currentSession.createQuery("select new list(id, stg) from TestEntity").list();
//		List list = currentSession.createQuery("select new map(id, stg, te.testEntity2.stg) from TestEntity as te").list();
//		List list = currentSession.createQuery("select new com.example.demo.model.TestEntityDto (stg) from TestEntity").list();
// 		List list = currentSession.createQuery("select id||' '||stg from TestEntity as te").list();
//		List list = currentSession.createQuery("select concat(year(current_date), te.stg) from TestEntity te").list();
// 		List list = currentSession.createQuery("select id + cast(stg as integer) from TestEntity as te").list();
// 		List list = currentSession.createQuery("select max(id), count(*) from TestEntity").list();
//		List list = currentSession.createQuery("select sin(id) from TestEntity").list();
//		List list = currentSession.createQuery("select case te.stg when '123' then 'ну опять' else te.stg end from TestEntity te").list();
//		List list = currentSession.createQuery("select day(current_date), te.stg from TestEntity te").list();

//		Явный Join


//		List list = currentSession.createQuery("from TestEntity as testEntity join testEntity.testEntity2 as testEntity2").list();
//
//		List list = currentSession.createQuery("from TestEntity as testEntity join fetch testEntity.testEntity2 as testEntity2").list();

//		List list = currentSession.createQuery("from TestEntity as testEntity join testEntity.testEntity2 as testEntity2 with testEntity2.id > 1").list();
//		List list = currentSession.createQuery("from TestEntity as testEntity join testEntity.testEntity2 as testEntity2 where testEntity2.id > 1").list();



// 		Неявный Join
//		Query query = currentSession.createQuery("from TestEntity te where te.testEntity2.stg = :stg");
//		query.setParameter("stg", "1233");
//		List list = query.list();





//		Полиморфизм
//		List list = currentSession.createQuery("from Cat").list();
//		List list = currentSession.createQuery("from Tiger").list();
//		List list = currentSession.createQuery("from Cat as cat where cat.kittens.size > 2").list();
//		List list = currentSession.createQuery("from Cat as cat where size(cat.kittens) > 1").list();
//		List list = currentSession.createQuery("from Cat as cat where exists elements(cat.kittens)").list();


		//Агрегатная функция + субселект
//		Double averageAge = (Double) currentSession.createQuery("select avg(age) from Cat").getSingleResult();
		//set tiger age 18
//		List list = currentSession.createQuery("from Tiger as tiger where tiger.age > (select avg(age) from Cat)").list();


		//order by
//		List list = currentSession.createQuery("from Cat order by age").list();
//		group by
//		List list = currentSession.createQuery("select count(*), skinColor from Cat as cat group by cat.skinColor").list();
		//having
//		List list = currentSession.createQuery(
//				"select count(*), skinColor " +
//						"from Cat as cat group by cat.skinColor " +
//						"having cat.skinColor in (com.example.demo.model.SkinColor.WHITE, com.example.demo.model.SkinColor.BLACK)").list();




		//update
//		Query query = currentSession.createQuery("update Cat c set c.name = :newName");
//		query.setParameter("newName", null);
//		int i = query.executeUpdate();


		//delete
//		Query query = currentSession.createQuery("delete Cat c where c.name = :name");
//		query.setParameter("name", "Мурка");
//		int i = query.executeUpdate();


		//insert
		// ? not supported
//		Query query = currentSession.createQuery("insert into TestEntity (id, stg) select c.id, c.name from Cat c where c.id = ?");
//		query.setParameter(1, 3L);
//		int i = query.executeUpdate();

		// insert
//		Query query = currentSession.createQuery("insert into TestEntity (stg) select c.name from Cat c where c.id =:id");
//		query.setParameter("id", 3L);
//		int i = query.executeUpdate();

		//HQL does not support insert like this, only from another table
//		Query query = currentSession.createQuery("insert into TestEntity (stg) values :name");
//		query.setParameter("id", 3L);
//		int i = query.executeUpdate();



		transaction.commit();
		currentSession.close();

	}
}
