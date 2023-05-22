package com.team21.view;

import java.util.List;

import com.team21.hamoon.Card;

public class GameView {

	public void firstScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t Black Jack 21\n");
		System.out.println("\t         게임 시작[Enter]\n");
		System.out.println("==================================================\n");
	}

	public void betScreen(int money) {
		System.out.println("==================================================\n");
		System.out.println("\t\t 배팅할 금액을 입력해주세요\n");
		System.out.println("\t\t 현재 "+money+"원 보유 중입니다\n");
		System.out.println("\t\t 1000원 단위로 배팅 가능합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void playScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t카드를 뽑아주세요\n");
		System.out.println("\t\t   [Enter]\n");
		System.out.println("==================================================\n");
	}
	
	public void cardScreen
	(Object pCard, Object dCard, int cardSum, int money, int betMoney) {
		System.out.println("==================================================\n");
		System.out.println("\t    딜러 카드 : " + "["+dCard+"] + ??"+"\n\n");
		System.out.printf("\t\t 배팅액 %d\n\n",betMoney);
		System.out.printf("\t %s 카드합: %d\t 보유액 : %d\n\n",pCard,cardSum,money);
		System.out.println("==================================================\n");
		
	}
	
	
	public void resultcardScreen
	(Object pCard, Object dCard, int pcardSum, int dcardSum, int money, int betMoney) {
		System.out.println("==================================================\n");
		System.out.printf("\t    딜러 카드 : %s  카드합: %d\n\n", dCard, dcardSum);
		System.out.printf("\t\t 배팅액 %d\n\n",betMoney);
		System.out.printf("\t %s 카드합: %d\t 보유액 : %d\n\n",pCard,pcardSum,money);
		System.out.println("==================================================\n");
		
	}
	
	public void firstChoiceScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t[1] Hit [2] Stand [3] DoubleDown \n");
		System.out.println("==================================================\n");
	}
	
	public void basicChoiceScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t     [1] Hit [2] Stand \n");
		System.out.println("==================================================\n");
	}
	
	
	public void insureanceCheckScreen() {
		System.out.println("==================================================\n");
		System.out.println("        딜러가 Ace 카드를 가지고 있습니다! \n");
		System.out.println("            인슈어런스 하시겠습니까?  ");
		System.out.println("            [1] 예 [2] 아니오 \n");
		System.out.println("==================================================\n");
	}
	
	public void insuranceSScreen() {
		System.out.println("==================================================\n");
		System.out.println("                딜러 블랙잭 !\n");
		System.out.println("         인슈어런스로 플레이어 승리\n");
		System.out.println("==================================================\n");
	}
	
	public void insuranceFScreen() {
		System.out.println("==================================================\n");
		System.out.println("          딜러의 패는 블랙잭이 아닙니다\n");
		System.out.println("              게임이 재개됩니다\n");
		System.out.println("==================================================\n");
	}
	
	public void splitCheckScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t 뽑은 카드의 숫자가 같습니다 ! \n");
		System.out.println("\t\t   스플릿 하시겠습니까?  ");
		System.out.println("\t\t   [1] 예 [2] 아니오 \n");
		System.out.println("==================================================\n");
	}
	
	public void winScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t게임에서 승리하셨습니다\n");
		System.out.println("\t\t받은 배팅액의 2배를 지급합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void winInsuranceScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t딜러 블랙잭!");
		System.out.println("\t플레이어 인슈어런스로, 모든 배팅액을 반환합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void winBlackJackScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t  플레이어 블랙잭!\n");
		System.out.println("\t받은 배팅액의 1.5배를 지급합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void winDBustScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t딜러 버스트! 플레이어가 승리했습니다");
		System.out.println("\t\t받은 배팅액의 2배를 지급합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void pushScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t푸쉬!");
		System.out.println("\t\t배팅액을 반환합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void loseScreen() {
		System.out.println("==================================================\n");
		System.out.println("                  플레이어 패배 \n");
		System.out.println("                배팅액을 잃었습니다\n");
		System.out.println("==================================================\n");
	}
	
	public void bustLoseScreen() {
		System.out.println("==================================================\n");
		System.out.println("        카드의 합이 21을 넘었습니다. 버스트! \n");
		System.out.println("             배팅액을 잃었습니다 \n");
		System.out.println("==================================================\n");
	}
	
	public void blackPush() {
		System.out.println("==================================================\n");
		System.out.println("\t\t 딜러도 블랙잭입니다. 푸쉬!\n");
		System.out.println("\t      배팅액을 반환합니다\n");
		System.out.println("==================================================\n");
	}
	
	public void blackLose() {
		System.out.println("==================================================\n");
		System.out.println("\t\t 딜러가 블랙잭입니다. 플레이어 패배입니다\n");
		System.out.println("\t        배팅액을 잃었습니다\n");
		System.out.println("==================================================\n");
	}
	
	public void restartScreen(int money) {
		System.out.println("==================================================\n");
		System.out.printf("\t\t  현재 시드머니:%d\n\n",money);
		System.out.println("\t\t 게임을 재시작하겠습니까? \n");
		
		System.out.println("\t\t   [1] 예 [2] 아니오 \n");
		System.out.println("==================================================\n");
	}
	
	public void restarConfirmtScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t\t 게임을 다시 시작합니다 \n");
		System.out.println("==================================================\n");
		
	}

	public void endScreen() {
		System.out.println("==================================================\n");
		System.out.println("\t 게임을 종료합니다. 이용해주셔서 감사합니다\n");
		System.out.println("==================================================\n");
		
	}
	
	public void splitPBust() {
		System.out.println("==================================================\n");
		System.out.println("\t 플레이어가 버스트했습니다. 다음 스플릿게임으로 넘어갑니다\n");
		System.out.println("==================================================\n");
	}
	
	public void splitDBust() {
		System.out.println("==================================================\n");
		System.out.println("\t 딜러가 버스트했습니다. 각 스플릿 게임이 전부 승처리 됩니다\n");
		System.out.println("==================================================\n");
		
	}
}
