package D4;
import java.util.Scanner;
import java.io.FileInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_6959 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			String num = sc.next();
			int len = num.length();
			int sum = 0;
			int count = 0;
			if (len == 1)
				System.out.println("#" + test_case + " " + 'B');
			else {
				for (int i = 0; i < len; i++) {
					sum += num.charAt(i) - '0';
					count++;
					if (sum >= 10) {
						sum = sum / 10 + sum % 10;
						count++;
					}
				}

				if (count % 2 == 0)
					System.out.println("#" + test_case + " " + 'A');
				else
					System.out.println("#" + test_case + " " + 'B');
			}

		}

	}
}
