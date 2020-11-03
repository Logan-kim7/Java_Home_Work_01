package com.jm.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jm.book.domain.BookVO;

public class JueService {

	private List<BookVO> bookList;
	private Scanner scan = new Scanner(System.in);
	private BookVO bookvo = new BookVO();

	public JueService() {
		bookList = new ArrayList<>();
	}

	public boolean inputBook() {
		System.out.println("도서코드를 입력하세요!");
		String code = scan.nextLine();
		try {
			code = String.format("%05d", Integer.valueOf(code));

			if (code.length() > 5) {
				System.out.println("도서코드는 1~5자리만 유효합니다.");
				System.out.println("다시 입력하세요");
				return false;
			}
		} catch (Exception e) {

		}
		bookvo.setCode(code);
		
		while(true) {
			System.out.println("도서명을 입력하세요");
			String name= scan.nextLine();
			
			try {
				
				if(name.isEmpty()) {
					System.out.println("도서명은 반드시 입력해야 합니다.");
					System.out.println("도서명을 다시 입력하세요!");
					continue;
				}
				
			} catch (Exception e) {
				
			} 
			bookvo.setName(name);
			
			System.out.println("도서 가격을 입력하세요");
			String strPrice = scan.nextLine();
			
			int Price = 0;
			try {
				 Price = Integer.valueOf(strPrice);
			} catch (Exception e) {
				
				System.out.println("숫자로 입력하세요");
			}
			bookvo.setPrice(Price);
			bookList.add(bookvo);
			
			return true;
			
		}
	}

}
