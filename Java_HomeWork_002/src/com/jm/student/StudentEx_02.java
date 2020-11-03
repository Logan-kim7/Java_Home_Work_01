package com.jm.student;

import java.util.Scanner;

import com.jm.student.service.StudentService;
import com.jm.student.service.StudentServiceImplV1;

public class StudentEx_02 {
	
	public static void main(String[] args) {
		String stdFile = "src/com/jm/student/student.txt";
		Scanner scan = new Scanner(System.in);
		StudentService sService = new StudentServiceImplV1(scan, stdFile);
		
		boolean ret = true;
		while(ret) {
			sService.loadStudent();
			ret = sService.inputNum()
			&& sService.inputName()
			&& sService.inputDept()
			&& sService.inputGrade()
			&& sService.inputTel()
			&& sService.saveStudent();	
		}
		System.out.println("업무종료");
	}

}
