package view;

import java.util.Scanner;

import com.mysql.cj.Session;

import dao.SolDAO;
import dto.SolDTO;

public class LoginView {
	public LoginView() {
		Scanner sc = new Scanner(System.in);
		SolDAO sdao = new SolDAO();
		System.out.print("���� : ");
		String solid = sc.next();
		System.out.print("��ȣ : ");
		String solpw = sc.next();
		
		if(sdao.login(solid, solpw)) {
			//���κ�
			String solname = ((SolDTO)dao.Session.getData("loginSol")).solname;
			System.out.println(solname+"�� �������");
			new MainView();
		}
		else {
			System.out.println("�α��� ���� / ���̵� Ȥ�� ��й�ȣ�� Ȯ�����ּ���.");
		}
		
	}
}
