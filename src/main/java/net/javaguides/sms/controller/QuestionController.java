package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.sms.dto.QuestionDto;

import net.javaguides.sms.entity.Question;

import net.javaguides.sms.service.QuestionService;


@Controller
public class QuestionController {

	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/questions")
	public String listStudents(Model model) {
		model.addAttribute("questions", questionService.getAllQuestionsDto());
		return "students";
	}
	
	@GetMapping("/questions/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		 	Question question = new Question();
		model.addAttribute("question", question);
		return "create_student";
		
	}
	
	@PostMapping("/questions")
	public String saveStudent(@ModelAttribute("question") QuestionDto dto) {
		
		Question question = questionService.convertDtoToEntity(dto);
		questionService.saveQuestion(question);
		System.out.println(question.toString());
		return "redirect:/questions";
	}
	
//	@GetMapping("/students/edit/{id}")
//	public String editStudentForm(@PathVariable Long id, Model model) {
//		model.addAttribute("student", studentService.getStudentById(id));
//		return "edit_student";
//	}

	
		
  @GetMapping("questions/bigger/{id}/{yes}")
  public String voteYes(@PathVariable(value = "id") Long id) {
	  System.out.println("reach1");
	  
	  Question existingQuestion = questionService.getQuestionById(id);
	  System.out.println("reach2");
	  System.out.println(existingQuestion.toString());
	  System.out.println("reach3");
		//existingStudent.setId(id);
		
		//existingStudent.setFirstName(student.getFirstName());
	
		existingQuestion.setYes(existingQuestion.getYes()+1);
		System.out.println("reach4");
		questionService.updateQuestion(existingQuestion);
         return "redirect:/questions";



  }
  @GetMapping("questions/some/{id}/{no}")
  public String voteNo(@PathVariable(value = "id") Long id) {
	  
	  Question existingQuestion = questionService.getQuestionById(id);
	  System.out.println("reach2");
	  System.out.println(existingQuestion.toString());
	  System.out.println("reach3");
		//existingStudent.setId(id);
		
		//existingStudent.setFirstName(student.getFirstName());
	
		existingQuestion.setNo(existingQuestion.getNo()+1);
		System.out.println("reach4");
		questionService.updateQuestion(existingQuestion);
         return "redirect:/questions";



  }
	// handler method to handle delete student request
	
//	@GetMapping("/students/{id}")
//	public String deleteStudent(@PathVariable Long id) {
//		studentService.deleteStudentById(id);
//		return "redirect:/students";
//	}
	
}