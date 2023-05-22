package com.team21.hamoon;

import java.util.Objects;

/**
 * 모양과 숫자를 랜덤으로 조합하여 카드 한 장을 만들어냄
 */
public class Card {

	 private String shape;
	 private String number;
	
	public static final String[] SHAPE = {"◆", "♥", "♣", "♠"};
	public static final String[] NUMBER = {"A","3","4","2","5","6","7","8","9","10","J","Q","K"};
	
	public Card() {
		int s = (int)(Math.random()*SHAPE.length);
		int n = (int)(Math.random()*NUMBER.length);
		this.shape = SHAPE[s];
        this.number = NUMBER[n];
	}

	 public String getShape() {
	        return shape;
	    }

	    public String getNumber() {
	        return number;
	    }
	
	@Override
	public String toString() {
		return String.format("%s%s", shape, number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, shape);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(number, other.number) && Objects.equals(shape, other.shape);
	}
	
	
	
	
}
