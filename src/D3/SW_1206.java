package D3;

import java.util.Scanner;

public class SW_1206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int TC = 1; TC <= 10; TC++) {
			int count = 0;
			int num = sc.nextInt();
			int b[] = new int[num];
			for (int i = 0; i < num; i++)
				b[i] = sc.nextInt();

			for (int i = 2; i < num - 2; i++) {
				int left_max = -1;
				int right_max = -1;
				int max = -1;
				if (b[i] > b[i - 1] && b[i] > b[i - 2] && b[i] > b[i + 1] && b[i] > b[i + 2]) {
					left_max = Math.max(b[i - 1], b[i - 2]);
					right_max = Math.max(b[i + 1], b[i + 2]);
					max = Math.max(left_max, right_max);

					count += b[i] - max;

				}

			}

			System.out.println("#" + TC + " " + count);

		}
	}

}
