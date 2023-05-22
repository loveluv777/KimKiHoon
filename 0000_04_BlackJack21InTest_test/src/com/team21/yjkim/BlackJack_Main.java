package com.team21.yjkim;

public class BlackJack_Main {

	public static void main(String[] args) {
		Result re = new Result();
		int x = re.gameResult(15, 20);
		re.resultGame(x);
	} 
}
