package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		 	Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		System.out.println(student.toString());
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	
		
  @RequestMapping("students/bigger/{id}/{yes}")
  public String voteYes(@PathVariable(value = "id") Long id,@ModelAttribute("student") Student student) {
	  System.out.println("reach1");
	  
	  Student existingStudent = studentService.getStudentById(id);
	  System.out.println("reach2");
	  System.out.println(existingStudent.toString());
	  System.out.println("reach3");
		//existingStudent.setId(id);
		
		//existingStudent.setFirstName(student.getFirstName());
	
		existingStudent.setYes(existingStudent.getYes()+1);
		System.out.println("reach4");
          studentService.updateStudent(existingStudent);
         return "redirect:/students";



  }
  @RequestMapping("students/some/{id}/{no}")
  public String voteNo(@PathVariable(value = "id") Long id,@ModelAttribute("student") Student student) {
	  System.out.println("reach1");
	  
	  Student existingStudent = studentService.getStudentById(id);
	  System.out.println("reach2");
	  System.out.println(existingStudent.toString());
	  System.out.println("reach3");
		//existingStudent.setId(id);
		
		//existingStudent.setFirstName(student.getFirstName());
	
		existingStudent.setNo(existingStudent.getNo()+1);
		System.out.println("reach4");
          studentService.updateStudent(existingStudent);
         return "redirect:/students";



  }
	// handler method to handle delete student request
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
}
