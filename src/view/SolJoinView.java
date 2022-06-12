package view;

import java.util.Scanner;

import dao.BaseDAO;
import dao.GunDAO;
import dao.SolDAO;
import dto.GunDTO;
import dto.SolDTO;

public class SolJoinView {
	
	public SolJoinView() {
		
		Scanner sc = new Scanner(System.in);
		SolDAO sdao = new SolDAO();
		GunDAO gdao = new GunDAO();
		BaseDAO bdao = new BaseDAO();
		System.out.println("군 간부 전용 회원가입 페이지");
		System.out.println("군번 : ");
		String solid = sc.next();
		if(sdao.checkid(solid)) {
			System.out.println("비밀번호 : ");
			String solpw = sc.next();
			if(solpw.length() >= 8) {
				System.out.print("계급 : ");
				String solclass = sc.next();
				System.out.print("직책 : ");
				String solposition = sc.next();
				System.out.print("이름 : ");
				String solname = sc.next();
				System.out.print("생년월일 : ");
				String solbirth = sc.next();
				System.out.print("총기명 : ");
				String gunname = sc.next();
				System.out.print("총기번호 : ");
				int gunnum = sc.nextInt();
				if(gdao.checkgnum(gunnum)) {
					System.out.print("소속 : ");
					sc = new Scanner(System.in);
					int basenum = sc.nextInt();
					if(bdao.checkbnum(basenum)) {
						SolDTO newSol = new SolDTO(solid,solpw,solclass,solposition,solname,solbirth,gunnum,basenum);
						GunDTO newGun = new GunDTO(gunnum, gunname);
						
						if(gdao.gjoin(newGun)) {
							if(sdao.join(newSol)) {
								System.out.println("회원가입 성공");
							}else {
								System.out.println("회원가입 실패 / 다음에 다시 시도해주세요.");
							}	
						}else {
							System.out.println("총기등록 실패 / 다음에 다시 시도해주세요.");
						}
					}else {
						System.out.println("잘못된 부대번호 입니다.");	
					}
				}else {
					System.out.println("중복된 총기가 있습니다.");
				}	
			}else {
				System.out.println("비밀번호는 8자 이상이어야 합니다.");
			}
		}else {
			System.out.println("중복된 아이디가 있습니다.");
		}
	}
}
