package com.app.dao;

import java.util.List;

import com.app.pojos.Student;

public interface IStudentDao {
	Student validateUser(String email, String password);
	
	List<Student> getAllStudents();
	
	public int saveStudent(String name);
	
	public int deleteStudent(int id);
	
	public int updateStudent(int id,String name);
}
