package view;

import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.Session;

import dao.GunDAO;
import dto.GunDTO;
import dto.SolDTO;

public class GunView {
	public GunView() {
		GunDAO gdao = new GunDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("------총기관리화면------");
		while(true) {
			SolDTO loginSol = (SolDTO)dao.Session.getData("loginSol");
			if(loginSol == null) {
				System.out.println("로그인 후 이용하세요");
				break;
			}
 			System.out.println("1. 총기 등록");
			System.out.println("2. 총기 조회");
			System.out.println("3. 총기 정보 수정");
			System.out.println("4. 총기 반납");
			System.out.println("5. 뒤로가기");	
			int choice = sc.nextInt();
			
			if(choice == 5) {
				//뒤로가기
				System.out.println(loginSol.solname+loginSol.solclass+"님 다음에 또 오세요");
				dao.Session.setData("loginUser", null);
				break;
			}
			ArrayList<GunDTO> result = null;
			int gunnum = 0;
			switch(choice) {
			case 1:
				//총기 등록
				new AddGunView();
				break;
			case 2:
				//총기 조회
				
				break;
			case 3:
				//총기 정보 수정
				new ModifyGunView();
				break;
			case 4:
				//총기 반납
				
				System.out.print("반납할 총기의 총기번호 : ");
				gunnum = sc.nextInt();
				if(gdao.removeGun(gunnum)) {
					System.out.println(gunnum+" 한자루 반납 완료");
				}
				else {
					System.out.println("총기 반납 실패 / 다음에 다시 반납해 주세요.");
				}
				break;
			}
		}
	}
}
