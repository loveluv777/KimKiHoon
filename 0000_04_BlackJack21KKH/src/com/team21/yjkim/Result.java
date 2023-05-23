package com.team21.yjkim;

public class Result {

	//TODO 001 카드합 비교와 승무패 확인하는 메소드 만들기
	// 플레이어와 딜러의 카드의 합을 int 형태의 argument를 입력받아 판단
	// 카드 합을 받아와서 승무패 확인하는데 그전에 블랙잭 체크,버스트 체크
	// 이걸 하나의 메소드로 구현할지 나눠서 할지..?

	/*
	 * 플레이어와 딜러의 카드합을 입력받아 판단
	 */
	public int gameResult(int player, int dealer) {

		if(player>21) {
			return 3;
		}else if(dealer > 21) {
			return 4;
		}

		
		if(player == dealer) {
			return 0;
		}else if(player > dealer) {
			return 1;
		}
		else {
			return 2;
		}
	}

	public void resultGame(int gameResult) {
		
		switch (gameResult) {
		case 0:
			System.out.println("무승부 입니다.");
			break;
		case 1:
			System.out.println("플레이어 WIN");
			break;
		case 2:
			System.out.println("딜러 WIN");
			break;

		}
	}
	
	
	public boolean checkBlackJack(int number) {
		boolean isc = false;
		if (number == 21) {
			isc = true;
		}
		return isc;
	}

	public boolean checkBust(int numBust) {
		boolean isc = false;
		if(numBust>21) {
			isc = true;
		}
		return isc;
	}
}
