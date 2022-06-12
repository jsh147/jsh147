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
		System.out.println("�� ���� ���� ȸ������ ������");
		System.out.println("���� : ");
		String solid = sc.next();
		if(sdao.checkid(solid)) {
			System.out.println("��й�ȣ : ");
			String solpw = sc.next();
			if(solpw.length() >= 8) {
				System.out.print("��� : ");
				String solclass = sc.next();
				System.out.print("��å : ");
				String solposition = sc.next();
				System.out.print("�̸� : ");
				String solname = sc.next();
				System.out.print("������� : ");
				String solbirth = sc.next();
				System.out.print("�ѱ�� : ");
				String gunname = sc.next();
				System.out.print("�ѱ��ȣ : ");
				int gunnum = sc.nextInt();
				if(gdao.checkgnum(gunnum)) {
					System.out.print("�Ҽ� : ");
					sc = new Scanner(System.in);
					int basenum = sc.nextInt();
					if(bdao.checkbnum(basenum)) {
						SolDTO newSol = new SolDTO(solid,solpw,solclass,solposition,solname,solbirth,gunnum,basenum);
						GunDTO newGun = new GunDTO(gunnum, gunname);
						
						if(gdao.gjoin(newGun)) {
							if(sdao.join(newSol)) {
								System.out.println("ȸ������ ����");
							}else {
								System.out.println("ȸ������ ���� / ������ �ٽ� �õ����ּ���.");
							}	
						}else {
							System.out.println("�ѱ��� ���� / ������ �ٽ� �õ����ּ���.");
						}
					}else {
						System.out.println("�߸��� �δ��ȣ �Դϴ�.");	
					}
				}else {
					System.out.println("�ߺ��� �ѱⰡ �ֽ��ϴ�.");
				}	
			}else {
				System.out.println("��й�ȣ�� 8�� �̻��̾�� �մϴ�.");
			}
		}else {
			System.out.println("�ߺ��� ���̵� �ֽ��ϴ�.");
		}
	}
}
