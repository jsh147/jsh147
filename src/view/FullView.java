package view;

import java.util.Scanner;

public class FullView {
	public FullView() {
		System.out.println("종합 관리 페이지");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println
			("1. 물자 관리\n2. 식품 관리\n3. 총기 관리\n4. 차량 관리\n5. 물자 이동\n6. 뒤로가기");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				// 물자 관리
			}else if(choice== 2) {
				// 식품 관리
			}else if(choice== 3) {
				// 총기 관리
				new GunView();
			}else if(choice== 4) {
				// 차량 관리
			}else if(choice== 5) {
				// 물자 이동
			}else if(choice== 6) {
				// 뒤로가기
				System.out.println("이전 페이지로 이동합니다.");
				break;
			}else {
				System.out.println("잘못 선택하셨습니다. 다시 선택해주세요");
			}
		}
	}
}
