package com.team21.hamoon;

import java.util.ArrayList;
import java.util.List;

public class Player extends HandImpl{

	private List<Card> playerCard = new ArrayList<Card>();
	
	@Override
	public void drawCard() {
		List<Card> playerCard = this.playerCard;
		playerCard.add(allCard.get(0));
		allCard.remove(0);
	}

	public List<Card> getPlayerCard() {
		return playerCard;
	}
	
	public void setPlayerCard(List<Card> playerCard) {
		this.playerCard = playerCard;
	}

	public void makeSplitCard(){
		List<Card> splitCard = this.playerCard;
		splitCard.get(1);
		splitCardStart.add(splitCard.get(1));
		splitCard.remove(1);
	}
	
	public boolean compareCard(Card idx1, Card idx2) {
		boolean isc = false;
		String cardNumber1 = idx1.getNumber().toString();
		String cardNumber2 = idx2.getNumber().toString();
		
		if (cardNumber1.equals(cardNumber2)) {
			isc = true;
		}
		return isc;
	}

}
