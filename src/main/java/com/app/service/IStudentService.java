package com.app.service;

import java.util.List;

import com.app.pojos.Student;

public interface IStudentService {
	Student authenticateUser(String em, String pass);

	public List<Student> getAllStudents();

	public int saveStudent(String name);
	
	public int deleteStudent(int id);
	
	public int updateStudent(int id,String name);
}
