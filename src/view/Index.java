package view;

import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		System.out.println("���δ� ���� ���α׷�");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. ȸ������\n2. �α���\n3. ������ ����\n4. ������");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				// ȸ������
				new JoinView();
			}else if(choice == 2) {
				// �α���
				new LoginView();
			}else if(choice == 3) {
				// ������ ����
				
			}else if(choice == 4) {
				// ������
				System.out.println("�̿����ּż� �����մϴ�.");
				break;
			}else {
				System.out.println("�߸� �����ϼ̽��ϴ�. �ٽ� �������ּ���");
			}
		}
	}
}
