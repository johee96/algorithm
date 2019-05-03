package D2;

import java.util.Scanner;

public class SW_1204 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score[] = new int[101];
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			int test_num = sc.nextInt();

			for (int i = 0; i < 101; i++)
				score[i] = 0;

			for (int i = 0; i < 1000; i++) {
				int s = sc.nextInt();
				score[s]++;
			}

			int max = -1;
			int count = -1;
			for (int i = 0; i < 101; i++) {
				if (count <= score[i]) {
					count = score[i];
					max = i;
				}

			}

			System.out.println("#" + test_num + " " + max);

		}

	}

}
