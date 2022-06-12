package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.GunDAO;
import dto.GunDTO;

public class ModifyGunView {
	public ModifyGunView() {
		Scanner sc = new Scanner(System.in);
		GunDAO gdao = new GunDAO();
		ArrayList<GunDTO> result = gdao.getList();

		System.out.print("������ �ѱ� ��ȣ : ");
		int gunnum = sc.nextInt();
		System.out.println("1. �ѱ��ȣ\n2. �ѱ��");
		int choice = sc.nextInt();
		System.out.print("���ο� ���� : ");
		sc = new Scanner(System.in);
		String newData = sc.nextLine();
		
		if(gdao.modifyGun(gunnum,choice,newData)) {
			System.out.println("�ѱ� ���� ����");
		}
		else {
			System.out.println("�ѱ� ���� ���� / ������ �ٽ� �õ��� �ּ���.");
		}
	}
}
