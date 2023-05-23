package com.team21.hamoon;

import java.util.ArrayList;
import java.util.List;

public abstract class HandImpl implements IHand {

	Deck make = new Deck();
	protected List<Card> allCard = make.getCardcase();
	protected List<Card> splitCardStart = new ArrayList<Card>();
	
	
	@Override
	public abstract void drawCard();

	public List<Card> getSplitCardStart() {
		return splitCardStart;
	}

	public void setSplitCardStart(List<Card> splitCardStart) {
		this.splitCardStart = splitCardStart;
	}
	
	
	
	
	
	
}
