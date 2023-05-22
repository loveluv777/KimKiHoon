package com.team21.hamoon;

import java.util.ArrayList;
import java.util.List;

public class Player_Split extends HandImpl{
	public List<Card> splitCard = new ArrayList<Card>();
		
	@Override
	public void drawCard() {
		List<Card> playerCard = this.splitCard;
		playerCard.add(allCard.get(0));
		allCard.remove(0);
	}
	
	public List<Card> getSplitCard() {
		return splitCard;
	}
}
