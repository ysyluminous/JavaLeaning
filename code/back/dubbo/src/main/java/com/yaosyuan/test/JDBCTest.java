/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author: 
 * @version: 2.0
 * @date: 2019 2019年5月15日 下午3:14:47
*/
package com.yaosyuan.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description: 功能描述 (jdbc保存对象到mysql数据库)
 * @copyright: Copyright (c) 2019
 * @company: yaosiyuan
 * @author:
 * @version: 2.0
 * @date: 2019 2019年5月15日 下午3:14:47
 */
public class JDBCTest {

	class Student {
		private String name;
		private Integer age;
		private String birthday;

		public Student(String name, Integer age, String birthday) {
			this.name = name;
			this.age = age;
			this.birthday = birthday;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getBirthday() {
			return birthday;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
	}

	public void t() throws ClassNotFoundException, SQLException {
		// 1 加载数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2 获取数据库连接
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String user = "root";
		String password = "000000";
		Connection conn = DriverManager.getConnection(url, user, password);
		Student student = new Student("张三", 20, "19860101");
		// 3 创建一个Statement
		String sql = "insert into students (name,age,birthday) values(?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setInt(2, student.getAge());
			pstmt.setString(3, student.getBirthday());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
}