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
		System.out.println("------�ѱ����ȭ��------");
		while(true) {
			SolDTO loginSol = (SolDTO)dao.Session.getData("loginSol");
			if(loginSol == null) {
				System.out.println("�α��� �� �̿��ϼ���");
				break;
			}
 			System.out.println("1. �ѱ� ���");
			System.out.println("2. �ѱ� ��ȸ");
			System.out.println("3. �ѱ� ���� ����");
			System.out.println("4. �ѱ� �ݳ�");
			System.out.println("5. �ڷΰ���");	
			int choice = sc.nextInt();
			
			if(choice == 5) {
				//�ڷΰ���
				System.out.println(loginSol.solname+loginSol.solclass+"�� ������ �� ������");
				dao.Session.setData("loginUser", null);
				break;
			}
			ArrayList<GunDTO> result = null;
			int gunnum = 0;
			switch(choice) {
			case 1:
				//�ѱ� ���
				new AddGunView();
				break;
			case 2:
				//�ѱ� ��ȸ
				
				break;
			case 3:
				//�ѱ� ���� ����
				new ModifyGunView();
				break;
			case 4:
				//�ѱ� �ݳ�
				
				System.out.print("�ݳ��� �ѱ��� �ѱ��ȣ : ");
				gunnum = sc.nextInt();
				if(gdao.removeGun(gunnum)) {
					System.out.println(gunnum+" ���ڷ� �ݳ� �Ϸ�");
				}
				else {
					System.out.println("�ѱ� �ݳ� ���� / ������ �ٽ� �ݳ��� �ּ���.");
				}
				break;
			}
		}
	}
}
