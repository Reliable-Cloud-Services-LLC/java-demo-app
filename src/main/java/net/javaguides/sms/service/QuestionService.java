package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.dto.QuestionDto;
import net.javaguides.sms.entity.Question;

public interface QuestionService {
	List<Question> getAllQuestions();
	
	Question saveQuestion(Question question);
	
	Question getQuestionById(Long id);
	
	Question updateQuestion(Question question);
	
//	void deleteById(Long id);
	
	QuestionDto convertEntityToDto(Question question);
	List<QuestionDto> getAllQuestionsDto();
	// saveStudentDto(QuestionDto question);
//	StudentDto updateStudentDto(Student student);
//	StudentDto getStudentByIdDto(Long id);
	Question convertDtoToEntity(QuestionDto dto);
}
