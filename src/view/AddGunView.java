package view;

import java.util.Scanner;

import com.mysql.cj.Session;

import dao.GunDAO;
import dto.GunDTO;
import dto.SolDTO;

public class AddGunView {
	public AddGunView() {
	//�ѱ��ȣ, �ѱ��, �ѱ⼳��(���߿� �����ͺ��̽� �ѱ������� ���� �߰��Ѵ��� �ѱ��ڵ� ���� ���� ��� Ȯ���� �� �ְ��ϱ�)
		GunDAO gdao = new GunDAO();
		Scanner sc = new Scanner(System.in);
		System.out.print("�ѱ� ��ȣ : ");
		int gunnum = sc.nextInt();
		System.out.print("�ѱ�� : ");
		sc = new Scanner(System.in);
		String gunname = sc.nextLine();
		
		SolDTO loginSol = (SolDTO)dao.Session.getData("loginSol");
		
		GunDTO newGun = new GunDTO(gunnum, gunname, loginSol.solid);
		
		if(gdao.addGun(newGun)) {
			System.out.println(gunname+" ��� �Ϸ�!");
		}
		else {
			System.out.println("�ѱ� ��� ���� / ������ �ٽ� �õ��� �ּ���.");
		}
		
	}
}
