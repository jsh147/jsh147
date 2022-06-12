package view;

import java.util.Scanner;

import com.mysql.cj.Session;

import dao.SolDAO;
import dto.SolDTO;

public class LoginView {
	public LoginView() {
		Scanner sc = new Scanner(System.in);
		SolDAO sdao = new SolDAO();
		System.out.print("군번 : ");
		String solid = sc.next();
		System.out.print("암호 : ");
		String solpw = sc.next();
		
		if(sdao.login(solid, solpw)) {
			//메인뷰
			String solname = ((SolDTO)dao.Session.getData("loginSol")).solname;
			System.out.println(solname+"님 어서오세요");
			new MainView();
		}
		else {
			System.out.println("로그인 실패 / 아이디 혹은 비밀번호를 확인해주세요.");
		}
		
	}
}
