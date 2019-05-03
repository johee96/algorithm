package D4;
//4613. ���þ� ���� ���� ���
import java.util.Scanner;

public class SW_4613 {
	static int MIN = Integer.MAX_VALUE;
	static char F[][];
	static int N;
	static int M;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			sc.nextLine(); // �̰�������� �����ȳ�..
			F = new char[N][M];

			for (int i = 0; i < N; i++) {
				String st = sc.nextLine();
				for (int j = 0; j < M; j++) {
					F[i][j] = st.charAt(j);
				}
			}

			// ��� ����� ���� ���ؼ� min���� ã��, w,b �� ��� 1�� �̻��̶� 1���� ����, r�� ���� �̻��̶� w+b���� �� N�̶� ���ų�
			// ũ�� �ȵ�(r�� ���ٴ� �� )
			for (int i = 1; i <= N - 2; i++) {
				for (int j = 1; j <= N - 2; j++) {

					if (i + j >= N) // ���� �� ���
						break;
					int c = N - i - j;
					findMin(i, j, c);
				}
			}

			System.out.println("#" + tc + " " + MIN);
			MIN = Integer.MAX_VALUE;

		}
	}

	static void findMin(int w, int b, int r) {
		int count = 0;

		for (int i = 0; i < w; i++)
			for (int j = 0; j < M; j++)
				if (F[i][j] != 'W')
					count++;

		for (int i = w; i < w + b; i++)
			for (int j = 0; j < M; j++)
				if (F[i][j] != 'B')
					count++;

		for (int i = w + b; i < N; i++)
			for (int j = 0; j < M; j++)
				if (F[i][j] != 'R')
					count++;

		if (MIN > count)
			MIN = count;

	}
}

/*
 * TEST_CASE 2 4 5 WRWRW BWRWB WRWRW RWBWR 6 14 WWWWWWWWWWWWWW WWRRWWBBBBBBWW
 * WRRRWWWBWWWWRB WWBWBWWWBWRRRR WBWBBWWWBBWRRW WWWWWWWWWWWWWW
 * 
 */