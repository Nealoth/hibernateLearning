package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedNativeQueries(value = {
		@NamedNativeQuery(
				name = "TestEntity.findAll",
				query = "SELECT * FROM TestEntity",
				resultClass = TestEntity.class),
		@NamedNativeQuery(
				name = "TestEntity2.findByStg",
				query = "SELECT * from TestEntity2 where stg = :stg",
				resultClass = TestEntity2.class),
		@NamedNativeQuery(name = "testEntityToDto",
				query = "SELECT * FROM TestEntity",
				resultSetMapping = "dtoResult")
})
@SqlResultSetMapping(
		name="dtoResult",
		classes={
				@ConstructorResult(
						targetClass=com.example.demo.model.TestEntityDto.class,
						columns={
								@ColumnResult(name="stg", type=String.class)})})
public class NamedQueryHolder implements Serializable {
	@Id
	private Integer id;
}
