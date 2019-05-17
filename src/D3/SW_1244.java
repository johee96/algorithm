//1244.최대 상금
package D3;

import java.util.Scanner;

public class SW_1244 {
	static int C;
	static int num[];
	static int max;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			String N = sc.next();
			C = sc.nextInt();
			num = new int[N.length()];
			for (int i = 0; i < N.length(); i++)
				num[i] = N.charAt(i) - '0';
			max = -1;
			find(0, 0);
			System.out.print("#" + TC + " " + max);
			// for (int i = 0; i < N.length(); i++)
			// System.out.print(num[i] + "");
			System.out.println("");
		}

	}

	static void swap(int i1, int i2) {
		int temp = num[i1];
		num[i1] = num[i2];
		num[i2] = temp;
	}

	static void find(int idx, int count) {

		if (count == C) {
			int sum = 0;
			for (int i = 0; i < num.length; i++)
				sum += num[i] * Math.pow(10, num.length - i - 1);

			if (max <= sum)
				max = sum;

			// System.out.println("count: " + count + " sum:" + sum);
			return;
		} else {

			for (int i = idx; i < num.length - 1; i++) {
				for (int j = i + 1; j < num.length; j++) {
					if (i == j)
						continue;
					if (num[i] <= num[j]) {
						swap(i, j);
						find(i, count + 1);
						swap(i, j);

					}
				}
			}
		}

	}

}