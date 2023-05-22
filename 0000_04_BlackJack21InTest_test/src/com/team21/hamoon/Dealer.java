package com.team21.hamoon;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends HandImpl{

	public List<Card> dealerCard = new ArrayList<Card>();
	
	@Override
	public void drawCard() {
		List<Card> dealerCard = this.dealerCard;
		dealerCard.add(allCard.get(0));
		allCard.remove(0);
	}

	public List<Card> getDealerCard() {
		return dealerCard;
	}
	
	public void setDealerCard(List<Card> dealerCard) {
		this.dealerCard = dealerCard;
	}

	public Card sortCard() {
		if(isAce()) {
			Card idx0 = dealerCard.get(0);
			dealerCard.set(0, dealerCard.get(1));
			dealerCard.set(1, idx0);
		}
		return dealerCard.get(0);
	}
	
	public boolean isAce() {
		Card idx1 = dealerCard.get(1);
		String cardNumber2 = idx1.getNumber().toString();
		return cardNumber2.equals("A");
	}
	
}
