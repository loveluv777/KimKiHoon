package com.team21.sy;

import java.util.Scanner;
// 판단여부까지 내가 진행해서 switch case문을 이용한다면??
public class Money {
		
	private int money = 10000;
	private int betMoney;
	
	// 게임 시작 시 초기 배팅값을 받는 메소드
	public void firstBet(int n) {	
//		System.out.println("배팅 금액을 입력하세요.");
		this.betMoney = n;
		this.money = money - n;
//		System.out.println("배팅 하신 금액:" + money + "원 입니다.\n게임을 시작합니다."  );
		}
	
	
	// 입력받은 초기 배팅 금액에 *2 로직 구현해야함
	public void doubleDown() {
		this.money = money - betMoney;
		this.betMoney = betMoney*2;
//		System.out.println("더블다운! 한 장의 카드만을 받습니다. ");
//		System.out.println("더블다운으로 인한 배팅금액:" + doubleMoney +"원 입니다.");
	}
	
	// 게임동작 클래스에서 딜러의 첫 오픈카드가 A가 나왔을 경우
	// 인슈어런스를 판단 후 진행, 초기 배팅금액의 50%를 보험금으로 지불하는 로직 구현
	// 딜러의 두번째 카드 오픈 후 블랙잭일 경우 차감없이 본전
	public void Insurance() {
//		System.out.println("딜러의 오픈카드 'A'가 나왔습니다.\n 인슈어런스란? 초기 배팅금액의 50%를 보험금으로 지불합니다.");
//		System.out.println("인슈어런스를 진행하시겠습니까?\n1.yes\t2.no");
//		Scanner scan = new Scanner(System.in);
//		int x = scan.nextInt();
		this.betMoney = (int)(betMoney*0.5);
		}
	public void winCase() {
		this.money += this.betMoney*2;
		
	}
	
	public void pushCase() {
		this.money += this.betMoney;
		
	}
	
	public void blackWinCase() {
		this.money += (int)(betMoney*2.5);
		
	}
	
	public void loseCase() {
		
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public int getBetMoney() {
		return betMoney;
	}


	public void setBetMoney(int betMoney) {
		this.betMoney = betMoney;
	}


	
		
		
	
	
//	// 플레이어가 처음 받은 카드 두장이 같은 숫자일경우 split을 진행
//	// 플레이어1에 초기 배팅금액을 담아두고 플레이어2에 같은 금액 추가하는 로직 구현?
//	public void cardSplit() {
//		int play1 = firstBet(); 
//		int play2 = firstBet();
//		System.out.println("split 진행카드 1 :" + play1);
//		System.out.println("split 진행카드 2 :" + play2);
//		
//	}
	
	
}
