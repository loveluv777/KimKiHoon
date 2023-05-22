package com.team21.khkim;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.team21.hamoon.Card;
import com.team21.hamoon.Dealer;
import com.team21.hamoon.Player;
import com.team21.hamoon.Player_Split;
import com.team21.sy.Money;
import com.team21.util.Scanner_Util;
import com.team21.view.GameView;
import com.team21.yjkim.Result;


public class Controller {
	GameController gc = new GameController();
	Scanner_Util scan = new Scanner_Util();
	GameView screen = new GameView();
	Result result = new Result();
	Player player = new Player();    						
	Dealer dealer = new Dealer();	
	Player_Split split = new Player_Split();
	Money money = new Money();			
	
	private List<List<Card>> splitResults = new ArrayList<>();	//스플릿 된 카드들의 결과를 담는 2차원 List
	List<Card> splitList = split.getSplitCard();
	int input = 0;    						//게임 중 int 입력값을 저장하는 변수 
	int turn = 1;							//턴 수 저장(더블다운 판단을 위함)
	int saveFirstBet = 0;					//첫 배팅금액을 저장하는 변수(여러번 스플릿 할 경우 쓰임)
	int splitCnt = 0;						//스플릿 가능 횟수
	int stageChk = 0;						//게임 조기종료시 남은 과정을 건너뛰기 위한 변수
											//0 : 완전 처음, 1 : 1회차 이후, 2: Stand 선택, 3: 게임종료 선택
	
	public void startGame() {
		
		//게임 인트로
		if(stageChk == 0) {
		screen.firstScreen();									
		scan.scanAnything();
		stageChk++;							//두번째 실행부터는 이 단계 건너뜀
		}									
		
		//초기 배팅 초기 배팅 금액을 입력해주세요 화면
		screen.betScreen(money.getMoney());
		
		input = scan.input(1000, money.getMoney());
//		//배팅금액 예외처리
//		while (true) {
//			// 배팅값 입력,  시드머니 차감
//			try {
//				input = scan.scanInt();
//			} catch (InputMismatchException e) {
//				continue;
//			} 
//			if(input%1000 == 0 && input != 0) {
//				break;
//			}
//		}
		
		
		money.firstBet(input);
		saveFirstBet = money.getBetMoney();  //초기 배팅값 저장(여러번 스플릿 할 경우 초기 배팅값 필요)
		
			
		//'카드 뽑기 위해 엔터를 입력하세요' 화면
		screen.playScreen();		
		scan.scanAnything();	
		
		//딜러, 플레이어 한 장씩 드로우
		//스플릿 테스트를 위해 바꿔놓음
		if (money.getMoney()==9000) {
			player.drawCard();  
			dealer.drawCard();
//			player.drawCard();
			player.getPlayerCard().add(player.getPlayerCard().get(0));
			dealer.drawCard();
		}else {
		player.drawCard();   
		dealer.drawCard();
		player.drawCard();
		dealer.drawCard();
		}
		//카드 뽑기 결과를 반영한 카드창
		screen.cardScreen
		(player.getPlayerCard(), dealer.sortCard(), player.cardSum(player.getPlayerCard()), money.getMoney(), money.getBetMoney());
		
		//인슈어런스 여부를 판단하고 처리하는 프로세스    
		checkInsuranceProcess();
		
		//스플릿 여부를 판단하고 처리하는 프로세스		
		while(player.compareCard(player.getPlayerCard().get(0), player.getPlayerCard().get(1))) {
		    checkSplitProcess();
		
		}
		
		//블랙잭 여부를 판단하고 처리하는 프로새스
		if(stageChk<=1) {
		checkBlackJackProcess();
		}
		
		//기본 게임 진행 
		    gameLoop();
				
		//스플릿 게임 진행
		    if(splitCnt>0) {
			while (splitCnt>0){      //스플릿 가능 횟수가 남았을 때
				splitCnt--;										//스플릿가능횟수--;
				stageChk=1;										//다시 힛 할 수 있도록
				
				
				for (List<Card> split : splitResults) {
				    System.out.println(split);
				}
				
				player.setPlayerCard(splitList);  //스플릿카드를 플레이어카드로
				split.getSplitCard().clear(); //스플릿카드는 새 걸로
				player.drawCard();								//플레이어 카드 드로우
				gameLoop();										//게임 플레이
				
			}
			}
		
		//게임 재시작(변수 초기화 후 startGame 재귀호출) or 종료
		askRestart();
		
}//startGame의 끝
		
		


	public void gameLoop() {
			
//	        screen.cardScreen(player.getPlayerCard(), dealer.sortCard(), player.cardSum(player.getPlayerCard()), money.getMoney(), money.getBetMoney());
	        while(true) {
	        // 첫 턴이면 선택지 3개, n턴 이라면 선택지 2개인 화면 출력
	        if (turn == 1) {
	            screen.firstChoiceScreen(); // 선택지 3개
	            input = scan.input(1,3);
	        } else {
	            screen.basicChoiceScreen(); // 선택지 2개
	            input = scan.input(1,2);
	        }

	       
	        // 선택지에 따른 동작 처리
	        switch (input) {
	            case 1: // Hit
	                player.drawCard();
	                if(dealer.cardSum(dealer.getDealerCard())<17) {
	                dealer.drawCard();}
	                turn++;
	                screen.resultcardScreen(player.getPlayerCard(), dealer.getDealerCard(), player.cardSum(player.getPlayerCard()), dealer.cardSum(dealer.getDealerCard()), money.getMoney(), money.getBetMoney());
	                break;
	            case 2: // Stand
	            	stageChk = 2;
	                break;
	            case 3: // DoubleDown
	                player.drawCard();
	                dealer.drawCard();
	                money.doubleDown(); // money 관련 돈 처리
	                stageChk = 2;
	                break;
	            default:
	                break;
	       
	        }
	       
	        // 플레이어나 딜러가 버스트하면 힛 못하도록 함
	        if(player.cardSum(player.getPlayerCard())>21 || dealer.cardSum(dealer.getDealerCard())>21) {
	        	stageChk=2;
	        }
	        if (stageChk>=2) {
	        	break;
	        }
	        }    
		       
	       
	      //숫자 비교 
			// splitResults에 항목이 있는 경우 각각의 조합에 대해 scoreCompare 호출
			if (splitResults.size() > 0 &&  splitCnt < 1) {
			    for (int i = 0; i < splitResults.size(); i++) {
			        List<Card> cards = splitResults.get(i);
			        System.out.println(player.cardSum(cards));
			        scoreCompare(cards, dealer.getDealerCard(), player.cardSum(cards),
			                dealer.cardSum(dealer.getDealerCard()), money.getMoney(), money.getBetMoney());
			    }
			}
	        
	        
	        // 숫자 비교 -- split 된 상태라면 숫자비교 ㄴㄴ 아니라면 숫자비교 ㄱㄱ
			if(splitCnt>0) {
				splitResults.add(player.getPlayerCard());
				System.out.println("if실행중");
			}else {
				System.out.println("else실행중");
				
			scoreCompare(player.getPlayerCard(),dealer.getDealerCard(), 
						player.cardSum(player.getPlayerCard()), dealer.cardSum(dealer.getDealerCard()), 
						money.getMoney(), money.getBetMoney());
			}
			
			
			
			
	       
}
	/**
	 * @param obj 딜러의 카드 정보
	 * @return 인슈어런스 여부 정보 int
	 */
public void insuranceCheck(List<Card> dCard) {
	input = 0; 
	
		if(gc.hasAceCard(dCard) == true) {
			screen.insureanceCheckScreen();
			input = scan.scanInt();
		}
}

public void checkInsuranceProcess() {
	insuranceCheck(dealer.getDealerCard());
    if (input == 1 && dealer.cardSum(dealer.getDealerCard()) != 21) {
        money.Insurance();
        screen.insuranceFScreen();
    } else if (input == 1 && dealer.cardSum(dealer.getDealerCard()) == 21) {
        money.Insurance();
        money.winCase();
        screen.resultcardScreen(player.getPlayerCard(), dealer.getDealerCard(), player.cardSum(player.getPlayerCard()), dealer.cardSum(dealer.getDealerCard()),money.getMoney(), money.getBetMoney());
        screen.insuranceSScreen();  
        stageChk = 3;

    }
}

public int splitCheck() {
	int input = 0;
	screen.splitCheckScreen();
	input = scan.scanInt();
	return input;
}

public void checkSplitProcess() {
    
        if (splitCheck() == 1) {
            money.firstBet(saveFirstBet);
            splitCnt++;
            turn++;										//스플릿시 더블다운 적용X
            player.makeSplitCard();
            splitList = player.getSplitCardStart();
            player.drawCard();
            
        }
    
}



public void checkBlackJackProcess() {
    if (result.checkBlackJack(player.cardSum(player.getPlayerCard()))) {
    	if(splitCnt>0) {
    		
    	}
    	else if (result.checkBlackJack(dealer.cardSum(dealer.getDealerCard()))) {
            money.pushCase();
            screen.resultcardScreen(player.getPlayerCard(), dealer.getDealerCard(), player.cardSum(player.getPlayerCard()), dealer.cardSum(dealer.getDealerCard()),money.getMoney(), money.getBetMoney());
            screen.blackPush();
            stageChk=3;
        } else {         
            money.blackWinCase();
            screen.resultcardScreen(player.getPlayerCard(), dealer.getDealerCard(), player.cardSum(player.getPlayerCard()), dealer.cardSum(dealer.getDealerCard()),money.getMoney(), money.getBetMoney());
            screen.winBlackJackScreen();
            stageChk=3;
        }
        
   
    
    }
}



public void restartGame() {
	
	screen.restarConfirmtScreen();
	input = 0; 
	saveFirstBet = 0;
	player.getPlayerCard().clear(); 
	dealer.getDealerCard().clear();
	splitResults.clear();
	splitCnt = 0;
	turn = 1;
	stageChk=1;
    startGame(); // 게임을 다시 시작
}

public void askRestart() {
	//게임 종료 후 재시작 여부 확인
    screen.restartScreen(money.getMoney());
    input = scan.input(1,2);
    if (input == 1) { 
        restartGame();
    } else if (input == 2) { 		
    		screen.endScreen();									
    }
}




public void scoreCompare(List<Card> pCard,List<Card> dCard, int pSum, int dSum, int mmoney, int betMoney) {
	
	if (stageChk==2) {
        input = result.gameResult(pSum, dSum);
        switch (input) {
            case 0:
            	if(splitCnt>0) {
            		
	        		break;
	        	}else {
            	stageChk=3;
                money.pushCase();
	            screen.resultcardScreen(pCard, dCard, pSum, dSum, mmoney, betMoney);
	            screen.pushScreen();
                break;
	        	}
            case 1:
            	if(splitCnt>0) {
            		
	        		break;
	        	}else {
            	
            	
            	stageChk=3;
                money.winCase();
                screen.resultcardScreen(pCard, dCard, pSum, dSum, mmoney, betMoney);
	            screen.winScreen();
                break;
	        	}
            case 2:
            	if(splitCnt>0) {
            		
	        		break;
	        	}else {
            	stageChk=3;
                money.loseCase();
                screen.resultcardScreen(pCard, dCard, pSum, dSum, mmoney, betMoney);
	            screen.loseScreen();
                break;
	        	}
            	
            case 3:
            	if(splitCnt>0) {
            		
	        		break;
	        	}else {
	        		stageChk=3;
		        	money.loseCase();
		            screen.resultcardScreen(player.getPlayerCard(), dealer.getDealerCard(), player.cardSum(player.getPlayerCard()), dealer.cardSum(dealer.getDealerCard()),money.getMoney(), money.getBetMoney());
		            screen.bustLoseScreen();
		        	break;
	        	}
            case 4:
            	if(splitCnt>0) {
            		
	        		break;
	        	}else {
            	stageChk=3;
	        	money.winCase();
	            screen.resultcardScreen(player.getPlayerCard(), dealer.getDealerCard(), player.cardSum(player.getPlayerCard()), dealer.cardSum(dealer.getDealerCard()),money.getMoney(), money.getBetMoney());
	            screen.winDBustScreen();
	        	}
        }
        
        }
	
}


}

