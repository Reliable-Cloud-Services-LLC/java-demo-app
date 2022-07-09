package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import net.javaguides.sms.entity.Question;


public interface QuestionRepository extends JpaRepository<Question, Long>{

	
//	public Student findById(int id);
//
//	public StudentDto save(StudentDto dto);
	
}
