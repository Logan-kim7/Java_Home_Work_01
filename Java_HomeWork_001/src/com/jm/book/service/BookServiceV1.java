package com.jm.book.service;

import java.util.Scanner;

import com.jm.book.conf.Lines;

public class BookServiceV1 {

	
	private Scanner scan;
	private String strBCode;
	private String strBName;
	
	public BookServiceV1() {
		scan = new Scanner(System.in);
		strBCode = "";
		strBName = "";	
	}
	
	public void inputMain() {
		while(true) {
			System.out.println(Lines.dLines());
			System.out.println("빛나리 도서관 도서정보 관리 V1");
			System.out.println(Lines.sLines(50));
			
			this.strBCode = this.inputBCode();
			if(strBCode.contentEquals("QUIT")) {
				break;
			}
			
			this.strBName = this.inputBName();
			if(strBName.equals("QUIT")) {
				break;
			}
			System.out.println(Lines.dLines());
			
			
			this.printBookInfo();
		}
		System.out.println("업무를 종료합니다.!!!");
		return;
	}
	
	private String inputBCode() {
		String strBCode= "";
		while(true) {
			System.out.println("도서코드(QUIT:종료) >>");
			strBCode = scan.nextLine();
			
			if(strBCode.equals("QUIT")) {
				return "QUIT";
			}
			
			int intBCodeLength = strBCode.length();
			if(intBCodeLength <0 || intBCodeLength > 5) {
				System.out.println("도서코드는 13자리 아내의 숫자로 입력하세요");
				continue;
			}
			
			int intBCode = 0 ;
			try {
				intBCode = Integer.valueOf(strBCode);
			} catch (Exception e) {
				System.out.println("도서코드에 문자열이 포함되어 있습니다.");
				System.out.println("도서 코드는 13자리 이내의 숫자로만 입력하세요");
				
			}
			strBCode = String.format("%013d", intBCode);
			break;
		}
		return strBCode;
	}
	
	private String inputBName() {
		
		
		String strBName = "";
		while(true) {
			System.out.println("도서명 (QUIT:종료) >>");
			strBName = scan.nextLine();
			
			if(strBName.equals("QUIT")) {
				return "QUIT";
			}
			
			if(strBName.isEmpty()) {
				System.out.println("도서명은 반드시 입력해야 합니다.");
				continue;
			}
			break;
		}
		return strBName;
	}
	
	private void printBookInfo() {
		System.out.println(Lines.dLines());
		System.out.println("입력한 도서 정보");
		System.out.println(Lines.sLines());
		System.out.printf("도서코드 : %s\n",this.strBCode);
		System.out.printf("도서명 : %s\n",this.strBName);
		System.out.println(Lines.dLines());
	}
}
