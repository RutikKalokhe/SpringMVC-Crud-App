package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Student;
import com.app.service.IStudentService;

@Controller
@RequestMapping
public class StudentController {

	@Autowired
	private IStudentService studentService;

	public StudentController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method to show home page(login.jsp)
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("in show home page");
		return "/index";// AVN : /WEB-INF/views/index.jsp
	}

	@GetMapping("/student/list")
	public String showStudentList(Model map) {
		System.out.println("showing student data in tabular format");
		List<Student> students = studentService.getAllStudents();
		map.addAttribute("students", students);
		return "/student/list";
	}

	@GetMapping("student/insert")
	public String insertStudent() {
		System.out.println("showing form for inserting data");

		return "/student/insertform";
	}

	@PostMapping("student/insert")
	public String insertStudent(@RequestParam("name") String name) {
		System.out.println("Student Name: " + name);

		studentService.saveStudent(name);

		return "redirect:/";
	}

	@PostMapping("/student/deleteStudent")
	public String deleteStudent(@RequestParam("id") int id) {
		studentService.deleteStudent(id);

		return "redirect:/";
	}

	@GetMapping("/student/updateStudent")
	public String updateStudent(@RequestParam("id") int id, Model map) {
		System.out.println("in updating student get");
		map.addAttribute("id", id);
		return "/student/updateForm";
	}

	@PostMapping("/student/updateStudent/{id}")
	public String updateStudent(@RequestParam("name") String name,@PathVariable("id") String id) {
		System.out.println("in updating student post");
		int idd = Integer.parseInt(id);
		System.out.println(idd);
		studentService.updateStudent(idd, name);
		return "redirect:/";
	}
}
