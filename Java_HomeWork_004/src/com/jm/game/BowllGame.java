package com.jm.game;

import com.jm.game.service.BowllGameService;

public class BowllGame {
	public static void main(String[] args) {
		
		
		String[] games = {
				"X X X X X X X X X xxx", //300
				"3- 3/ X X X X X -- -- ---", // 143
				"X 5/ 3/ 5/ 52 5- 3- 3- 2- X--",// 116, 101
				"X5/3/ 5/ 52 5- -- -- -- ---", //75
				"X X X 5/ 52 5- 6/ 3- 4/ X--", //148
				"9/ 9/ 9/ 5/ 52 5- 6/ 3- 4/ X--", //126
				"9/ 9/ 9/ 5/ 52 5- 6/ 3- 4/ ---", //106
				"9/ 9/ 9/ 5/ 52 5- 6/ 3- 4 2--" //102
				
		};
		
		int gameCount = 0;
		for(String game : games) {
			System.out.printf("%d 번쨰 게임 :", ++gameCount);
			BowllGameService bg = new BowllGameService();
			String[] rolls = game.replace(" ", "").split("");
			int preGame = 10;
			for(String roll : rolls) {
				int thisGame = 0;
				if(roll.equalsIgnoreCase("X")) {
					thisGame = 10;
				}else if(roll.equals("/")){
					thisGame = 10 -preGame;
				}else if(roll.equals("-")) {
					thisGame = 0;
					
				}else {
					thisGame = Integer.valueOf(roll);
				}
				bg.rolling(thisGame);
				preGame = thisGame;
			}
			System.out.printf("====> 게임 점수 : %d \n", bg.getScore());
		}
	}

}
