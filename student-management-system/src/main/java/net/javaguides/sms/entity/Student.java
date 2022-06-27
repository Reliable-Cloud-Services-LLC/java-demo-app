package net.javaguides.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "first")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "questions")
	private String firstName;
	
	@Column(name = "yes")
	private int yes;
	
	@Column(name ="no")
	private int no;
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Student() {
		
	}
	
	public Student(String firstName, int yes, int no) {
		super();
		this.firstName = firstName;
		this.yes = yes;
		this.no = no;
	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	

	public int getYes() {
		return yes;
	}

	public void setYes(int yes) {
		this.yes = yes;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", yes=" + yes + ", no=" + no + "]";
	}



}
