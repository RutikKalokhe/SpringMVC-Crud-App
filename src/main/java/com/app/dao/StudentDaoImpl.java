package com.app.dao;

import com.app.pojos.Student;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // Mandatory anno to tell SC , following is DAO layer n enables exc translation
			// mechanism
//chked sql exc ---> un chked hib exc ---> un chked spring platform based exc
public class StudentDaoImpl implements IStudentDao {
	// dependency : SF
	 // autowire=byType (field level D.I)
	@Autowired
	private SessionFactory sf;

	@Override
	public Student validateUser(String email, String password) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		// no boilerplate code : since tx management is delegated to spring supplied :
		// TxMgr bean(configured in hib persistence xml)
		return sf.getCurrentSession().createQuery(jpql, Student.class).setParameter("em", email)
				.setParameter("pass", password).getSingleResult();
	}

	@Override
	public List<Student> getAllStudents() {
		String jpql = "select s from Student s";
		return sf.getCurrentSession().createQuery(jpql, Student.class).getResultList();
	}

	@Override
	public int saveStudent(String name) {
	    String jpql = "INSERT INTO Students(name) VALUES(?)";
	    return sf.getCurrentSession().createNativeQuery(jpql).setParameter(1, name).executeUpdate();
	}

	@Override
	public int deleteStudent(int id) {
		
		String jpql = "delete from Student s where s.id=:id";
		
		return sf.getCurrentSession().createQuery(jpql).setParameter("id", id).executeUpdate();
	}

	@Override
	public int updateStudent(int id,String name) {
		String jpql = "Update Students set name=:name where id=:id";
		System.out.println("updating ");
		 return sf.getCurrentSession().createNativeQuery(jpql).setParameter("name", name).setParameter("id", id).executeUpdate();
		 
		
		
	}



}
