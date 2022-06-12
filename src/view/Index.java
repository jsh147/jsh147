package view;

import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		System.out.println("군부대 관리 프로그램");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. 회원가입\n2. 로그인\n3. 마음의 편지\n4. 나가기");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				// 회원가입
				new JoinView();
			}else if(choice == 2) {
				// 로그인
				new LoginView();
			}else if(choice == 3) {
				// 마음의 편지
				
			}else if(choice == 4) {
				// 나가기
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}else {
				System.out.println("잘못 선택하셨습니다. 다시 선택해주세요");
			}
		}
	}
}
