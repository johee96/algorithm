package D4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class SW_3459 {
//승리자예측하기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int input = Integer.parseInt(sc.nextLine());
		ArrayList<Long> value = new ArrayList<Long>();

		int count = 0; // 테스트 갯수

		// 입력받음
		for (int i = 0; i < input; i++) {
			value.add(sc.nextLong());
		}

		// 테스트케이스
		while (count < input) {
			boolean alice = false;
			long range = 1; // 범위
			long pattern = 1; // 곱하기 패턴
			long checkvalue = value.get(count); // 하나씩 뽑은 값

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
