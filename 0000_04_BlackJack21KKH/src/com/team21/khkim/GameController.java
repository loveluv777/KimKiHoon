package com.team21.khkim;

public class GameController {

	/**
	 * 아규먼트의 String 반환 문자열에 'A'가 포함되어 있는지 판단하는 메소드
	 * 
	 * @param obj
	 * @return A포함 true, A미포함 false
	 * @author KH 
	 * 테스트 완료
	 */
	boolean hasAceCard(Object obj) {
		boolean isc = false;
		String str = obj.toString();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'A')
				isc = true;
		}

		return isc;
	}
	
	
		
		
	}
	
	


