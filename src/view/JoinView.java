package view;

import java.util.Scanner;

public class JoinView {
	public JoinView() {
		System.out.println("ȸ������ ������");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. �� ���� ����\n2. ��㰡 ����\n3. ������");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				// ����
				new SolJoinView();
			}else if(choice== 2) {
				// ��㰡
				new CouJoinView();
			}else if(choice== 3) {
				// ������
				System.out.println("���� �������� �̵��մϴ�.");
				break;
			}else {
				System.out.println("�߸� �����ϼ̽��ϴ�. �ٽ� �������ּ���");
			}
		}
	}
}
