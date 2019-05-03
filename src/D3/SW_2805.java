import java.util.Scanner;

public class SW_2805 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int testCase = Integer.parseInt(sc.nextLine());

		for (int test_case = 0; test_case < testCase; test_case++) {
			int N = sc.nextInt();

			int farm[][] = new int[N][N];
			int sum = 0;
			String nString = "";
			for (int i = 0; i < N; i++) {
				nString = sc.next();
				for (int k = 0; k < N; k++)
					farm[i][k] = Integer.parseInt(nString.charAt(k) + "");

			}
			int j = 1;

			for (int i = 0; i < N; i++) {
				if (i < (int) N / 2) {
					for (int k = 0; k < i * 2 + 1; k++)
						sum += farm[i][(int) N / 2 - i + k];
				} else if (i == (int) N / 2) {
					for (int k = 0; k < N; k++)
						sum += farm[i][k];

				} else {
					for (int k = 0; k < N - 2 * j; k++)
						sum += farm[i][k + j];
					j++;
				}

			}

			System.out.println("#" + (test_case + 1) + " " + sum);
		}
	}

}
