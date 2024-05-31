package com.anmol.springJdbc;

import com.anmol.springJdbc.model.Student;
import com.anmol.springJdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Student A = context.getBean(Student.class);
		StudentService service = context.getBean(StudentService.class);
		A.setRollNo(12); A.setName("Anmol"); A.setMarks(92);
		System.out.println(A.toString());
		service.addStudent(A);
		List<Student> allStudent = service.getStudents();
		System.out.println(allStudent);
	}

}
