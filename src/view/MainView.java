package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.BaseDAO;
import dao.FoodDAO;
import dao.GunDAO;
import dao.Session;
import dao.SolDAO;
import dao.ToolDAO;
import dto.SolDTO;

public class MainView {
	public MainView() {
		SolDAO sdao = new SolDAO();
		ToolDAO tdao = new ToolDAO();
		BaseDAO bdao = new BaseDAO();
		GunDAO gdao = new GunDAO();
		FoodDAO fdao = new FoodDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("메인화면");
		while(true) {
			SolDTO loginSol = (SolDTO)Session.getData("loginSol");
			if(loginSol == null) {
				System.out.println("로그인 후 이용하세요");
				break;
			}
 			System.out.println("1. 개인정보보기");
			System.out.println("2. 개인정보수정");
			System.out.println("3. 병사관리");
			System.out.println("4. 종합관리");
			System.out.println("5. 나가기");	
			int choice = sc.nextInt();
			
			if(choice == 5) {
				System.out.println(loginSol.solname+"님 다음에 또 오세요");
				Session.setData("loginUser", null);
				break;
			}
			ArrayList<SolDTO> result = null;
			switch(choice) {
			case 1:
				//개인정보보기
				result = sdao.getList();
				System.out.println("개인정보");
				for (SolDTO s : result) {
					System.out.printf("군번  : %s \n암호 : %s \n계급  : %s \n직책 : %s \n이름  : %s \n생년월일 : %s\n상태 : %s \n총기번호 : %d \n부대번호 : %d \n:",s.solid,s.solpw,s.solclass,s.solposition,s.solname,s.solbirth,s.state, s.gunnum,s.basenum);
				}
				System.out.println("==================================");
				break;
			case 2:
				//개인정보수정
				new MyInfoView();
				break;
			case 3:
				//병사관리
				
			case 4:
				//종합관리
				new FullView();
			}
		}
	}
}





