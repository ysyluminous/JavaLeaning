/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author: 
 * @version: 2.0
 * @date: 2019 2019年5月2日 下午6:07:47
*/
package com.yaosiyuan.entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yaosiyuan.mapper.PersonMapper;
import com.yaosiyuan.paran.CustomPerson;
import com.yaosiyuan.vo.PersonVo;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author:
 * @version: 2.0
 * @date: 2019 2019年5月2日 下午6:07:47
 */
public class TestMybatis {

	public SqlSessionFactory getFactory() throws IOException {
		String filePath = "SqlMappingConfig.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(filePath);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		return sqlSessionFactory;
	}

	@Test
	public void testInsert() throws IOException {
		SqlSessionFactory factory = this.getFactory();
		SqlSession openSession = factory.openSession();
		PersonMapper personMapper = openSession.getMapper(PersonMapper.class);

		Person person = new Person();
		person.setName("张三");
		person.setBirthday("11-11");
		person.setAge(12);
		person.setAddress("河南郑州");
		personMapper.insertPerson(person);
		// openSession.insert("test1.insertPerson", person);
		System.out.println("id:" + person.getId());
		openSession.commit();
		openSession.close();
	}

	@Test
	public void testQueryUserById() throws IOException {
		SqlSessionFactory factory = this.getFactory();
		SqlSession openSession = factory.openSession();
		PersonMapper personMapper = openSession.getMapper(PersonMapper.class);
		Person person = personMapper.querypersonbyid(1);
		// Person person = openSession.selectOne("querypersonbyid", 1);
		System.out.println(person);
	}

	@Test
	public void testQueryUserByName() throws IOException {
		SqlSessionFactory factory = this.getFactory();
		SqlSession openSession = factory.openSession();
		PersonMapper personMapper = openSession.getMapper(PersonMapper.class);

		List<Person> personList = personMapper.querypersonbyName("张");
		// List<Person> personList = openSession.selectList("querypersonbyName",
		// "姚");
		for (int i = 0; i < personList.size(); i++) {
			System.out.println(personList.get(i));
		}
		openSession.commit();
		openSession.close();
	}

	@Test
	public void testdeletePersonById() throws IOException {
		SqlSessionFactory factory = this.getFactory();
		SqlSession openSession = factory.openSession();
		PersonMapper personMapper = openSession.getMapper(PersonMapper.class);
		personMapper.deletePersonById(3);
		// openSession.delete("deletePersonById", 2);
		openSession.commit();
		openSession.close();

	}

	@Test
	public void testupadtePersonById() throws IOException {
		SqlSessionFactory factory = this.getFactory();
		SqlSession openSession = factory.openSession();
		PersonMapper personMapper = openSession.getMapper(PersonMapper.class);
		Person person = new Person();
		person.setId(1);
		person.setName("1111张三111");
		person.setBirthday("1112-12");
		person.setAge(12);
		person.setAddress("1111");
		personMapper.upadtePersonById(person);
		// openSession.update("upadtePersonById", person);
		openSession.commit();
		openSession.close();

	}

	@Test
	public void queryPersonByVo() throws IOException {
		SqlSessionFactory factory = this.getFactory();
		SqlSession openSession = factory.openSession();
		PersonMapper personMapper = openSession.getMapper(PersonMapper.class);
		PersonVo personVo = new PersonVo();
		CustomPerson customPerson = new CustomPerson();
		customPerson.setName("张三");
		customPerson.setBirthday("11-11");
		personVo.setCustomPerson(customPerson);
		List<Person> personList = personMapper.queryPersonByVo(personVo);
		for (int i = 0; i < personList.size(); i++) {
			System.out.println(personList.get(i));
		}
		openSession.commit();
		openSession.close();
	}
}
