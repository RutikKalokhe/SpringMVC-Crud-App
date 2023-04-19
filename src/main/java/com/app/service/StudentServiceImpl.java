package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStudentDao;
import com.app.pojos.Student;

@Service // mandatory : to tell SC , following is spring bean : containing B.L
@Transactional // mandatory to tell SC : to manage txs , auto . using spring supplied tx
				// manager bean , configured in hib persistence xml file
public class StudentServiceImpl implements IStudentService {
	//dependency : dao i/f
	@Autowired
	private IStudentDao StudentDao;

	@Override
	public Student authenticateUser(String em, String pass) {
		// simply call dao's method for db based authentication
		return StudentDao.validateUser(em, pass);
	}

	@Override
	public List<Student> getAllStudents() {
		
		return StudentDao.getAllStudents();
	}

	@Override
	public int saveStudent(String name) {
		
		return StudentDao.saveStudent(name);
	}

	@Override
	public int deleteStudent(int id) {
		
		return StudentDao.deleteStudent(id);
	}

	@Override
	public int updateStudent(int id, String name) {
		
		return StudentDao.updateStudent(id, name);
	}

}
