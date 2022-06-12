package view;

import java.util.Scanner;

public class JoinView {
	public JoinView() {
		System.out.println("회원가입 페이지");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. 군 간부 전용\n2. 상담가 전용\n3. 나가기");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				// 간부
				new SolJoinView();
			}else if(choice== 2) {
				// 상담가
				new CouJoinView();
			}else if(choice== 3) {
				// 나가기
				System.out.println("이전 페이지로 이동합니다.");
				break;
			}else {
				System.out.println("잘못 선택하셨습니다. 다시 선택해주세요");
			}
		}
	}
}
