package com.team21.hamoon;

import java.util.Iterator;
import java.util.List;

public interface IHand {
	
	
	void drawCard();
	
	default int cardSum(List<Card> eachList) {
	    int sum = 0;
	    int numOfAce = 0; // 에이스 카드의 개수를 저장하는 변수 추가
	    Iterator<Card> currentCard = eachList.iterator();
	    while (currentCard.hasNext()) {	        
	    	String cardNumber = currentCard.next().getNumber();
	    	
	        switch (cardNumber) {
	            case "A":
	                numOfAce++; // 카드의 값은 나중에 계산하기 위해 일단 개수만 증가시킴
	                break;
	            case "J":
	            case "Q":
	            case "K":
	                sum += 10;
	                break;
	            default:
	                sum += Integer.parseInt(cardNumber);
	                break;
	        }
	    }
	    // 에이스 카드의 값을 결정하고 총 합을 계산함
	    while (numOfAce > 0) {
	        if (sum + 11 <= 21) { // 총 합에 11을 더해도 21 이하인 경우
	            sum += 11;
	        } else {
	            sum += 1;
	        }
	        numOfAce--;
	    }
	    return sum;
	}
	
	default void resetCard(List<Card> eachList) {
		eachList.removeAll(eachList);
	}
	
}
