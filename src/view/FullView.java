package view;

import java.util.Scanner;

public class FullView {
	public FullView() {
		System.out.println("���� ���� ������");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println
			("1. ���� ����\n2. ��ǰ ����\n3. �ѱ� ����\n4. ���� ����\n5. ���� �̵�\n6. �ڷΰ���");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				// ���� ����
			}else if(choice== 2) {
				// ��ǰ ����
			}else if(choice== 3) {
				// �ѱ� ����
				new GunView();
			}else if(choice== 4) {
				// ���� ����
			}else if(choice== 5) {
				// ���� �̵�
			}else if(choice== 6) {
				// �ڷΰ���
				System.out.println("���� �������� �̵��մϴ�.");
				break;
			}else {
				System.out.println("�߸� �����ϼ̽��ϴ�. �ٽ� �������ּ���");
			}
		}
	}
}
