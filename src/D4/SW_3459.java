package D4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class SW_3459 {
//�¸��ڿ����ϱ�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int input = Integer.parseInt(sc.nextLine());
		ArrayList<Long> value = new ArrayList<Long>();

		int count = 0; // �׽�Ʈ ����

		// �Է¹���
		for (int i = 0; i < input; i++) {
			value.add(sc.nextLong());
		}

		// �׽�Ʈ���̽�
		while (count < input) {
			boolean alice = false;
			long range = 1; // ����
			long pattern = 1; // ���ϱ� ����
			long checkvalue = value.get(count); // �ϳ��� ���� ��

			while (range < checkvalue) {

				if (!alice)
					pattern= pattern * 4;

				range += pattern;
				alice = !alice;
			}

			if (alice)
				System.out.println("#" + (count + 1) + " Alice");

			else
				System.out.println("#" + (count + 1) + " Bob");

			count++;
		}
	}

}
