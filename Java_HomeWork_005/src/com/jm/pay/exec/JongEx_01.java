package com.jm.pay.exec;

import com.jm.pay.service.JongService;

public class JongEx_01 {
	
	public static void main(String[] args) {
		JongService jong = new JongService();
		int pay =  3_785_760;
		jong.solution(pay);
		
	}

}
