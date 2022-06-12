package view;

import java.util.Scanner;

import com.mysql.cj.Session;

import dao.GunDAO;
import dao.SolDAO;
import dto.SolDTO;

public class MyInfoView {
	public MyInfoView() {
		SolDAO sdao = new SolDAO();
		GunDAO gdao = new GunDAO();
		Scanner sc = new Scanner(System.in);
		SolDTO loginSol = (SolDTO)dao.Session.getData("loginSol");
		System.out.println("======"+loginSol.solname+"("+loginSol.solclass+")님의 개인정보======");
		System.out.println("군번 : "+loginSol.solid);
		System.out.println("계급 : "+loginSol.solclass);
		System.out.println("이름 : "+loginSol.solname);
		System.out.println("직책 : "+loginSol.solposition);
		System.out.println("소속 : "+loginSol.basenum);
		System.out.println("==================================");
		System.out.println("1. 암호 수정\n2. 계급 수정\n3. 직책 수정\n4. 소속\n5. 수정취소\n6. 전역");
		int choice = sc.nextInt();
		
		if(choice == 5) {
			System.out.println("메인으로 돌아갑니다.");
		}
		else if(choice == 6) {
			//전역
			System.out.print("암호 재입력 : ");
			String solpw = sc.next();
			
			if(loginSol.solpw.equals(solpw)) {
				if(gdao.removeAll(loginSol.solid)) {
					if(sdao.leaveId(loginSol.solid)) {
						System.out.println("그동안 이용해 주셔서 감사합니다...☆");
					}
				}
			}
			else {
				System.out.println("암호 오류 / 암호를 다시 확인하세요.");
			}
		}
		else {
			//정보 수정
			// 1. 새로운 데이터 입력받기
			System.out.print("새로운 정보 : ");
			sc = new Scanner(System.in);
			String newData = sc.nextLine();
			// 2. 처리 메소드 호출
			if(sdao.modifySol(loginSol.solid,choice,newData)) {
				System.out.println("정보 수정 완료");
			}
		}
	}
}
