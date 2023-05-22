package com.team21.hamoon;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	
	private List<Card> cardcase;
	
	public Deck() {
		cardcase = new ArrayList<Card>();
		make();
	}

	private void make() {
		int cnt = 0;
		while (true) {
			Card card = new Card();
			if(!cardcase.contains(card)) {
				cardcase.add(card);
				cnt++;
			}
			if(cnt == Card.SHAPE.length * Card.NUMBER.length) {
				break;
			}
		}//while
	}//make

	public List<Card> getCardcase() {
		return cardcase;
	}
	
	
}
