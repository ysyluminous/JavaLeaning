/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author: 
 * @version: 2.0
 * @date: 2019 2019年5月2日 下午7:27:37
*/
package com.yaosiyuan.mapper;

import java.util.List;

import com.yaosiyuan.entity.Person;
import com.yaosiyuan.vo.PersonVo;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author:
 * @version: 2.0
 * @date: 2019 2019年5月2日 下午7:27:37
 */
public interface PersonMapper {

	public Person querypersonbyid(int id);

	public List<Person> querypersonbyName(String name);

	public void insertPerson(Person person);

	public void deletePersonById(int id);

	public void upadtePersonById(Person person);

	public List<Person> queryPersonByVo(PersonVo personVo);

}
