package com.team21.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Scanner_Util {

	public int scanInt() {
		int input = 0;
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				input = scan.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다");
			} 
			
		}
		return input;
	}
	
	public void scanAnything() {
	
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
	}
	//범위 안의 숫자만 입력받을 수 있는 메소드
		public int input (int min, int max) {
			int input;
			while(true) {
				input = scanInt();
				if(input >= min && input <= max) {
					break;
				} 
				System.out.println("범위 안의 숫자를 입력해주세요");
			}
			return input;
		}
		
//	public int scanInt2() {
//		int input = 0;
//		while (true) {
//			try {
//				Scanner scan = new Scanner(System.in);
//				input = scan.nextInt();
//				
//			} catch (InputMismatchException e) {
//				System.out.println("잘못된 입력입니다");
//			} 
//			if(input > 0 && input <3) {break;}
//		}
//		return input;
//	}
//	
//	public int scanInt3() {
//		int input = 0;
//		while (true) {
//			try {
//				Scanner scan = new Scanner(System.in);
//				input = scan.nextInt();
//				
//			} catch (InputMismatchException e) {
//				System.out.println("잘못된 입력입니다");
//			} 
//			if(input > 0 && input <4) {break;}
//		}
//		return input;
//	}
	
}
