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
		System.out.println("======"+loginSol.solname+"("+loginSol.solclass+")���� ��������======");
		System.out.println("���� : "+loginSol.solid);
		System.out.println("��� : "+loginSol.solclass);
		System.out.println("�̸� : "+loginSol.solname);
		System.out.println("��å : "+loginSol.solposition);
		System.out.println("�Ҽ� : "+loginSol.basenum);
		System.out.println("==================================");
		System.out.println("1. ��ȣ ����\n2. ��� ����\n3. ��å ����\n4. �Ҽ�\n5. �������\n6. ����");
		int choice = sc.nextInt();
		
		if(choice == 5) {
			System.out.println("�������� ���ư��ϴ�.");
		}
		else if(choice == 6) {
			//����
			System.out.print("��ȣ ���Է� : ");
			String solpw = sc.next();
			
			if(loginSol.solpw.equals(solpw)) {
				if(gdao.removeAll(loginSol.solid)) {
					if(sdao.leaveId(loginSol.solid)) {
						System.out.println("�׵��� �̿��� �ּż� �����մϴ�...��");
					}
				}
			}
			else {
				System.out.println("��ȣ ���� / ��ȣ�� �ٽ� Ȯ���ϼ���.");
			}
		}
		else {
			//���� ����
			// 1. ���ο� ������ �Է¹ޱ�
			System.out.print("���ο� ���� : ");
			sc = new Scanner(System.in);
			String newData = sc.nextLine();
			// 2. ó�� �޼ҵ� ȣ��
			if(sdao.modifySol(loginSol.solid,choice,newData)) {
				System.out.println("���� ���� �Ϸ�");
			}
		}
	}
}
