//4615. 재미있는 오셀로 게임
//주의 : 사이에 0인 것 도 생각해 줘야함
import java.util.*;

public class SW_4615 {
	static int board[][];
	static int[][] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 한 번의 길이
			int M = sc.nextInt();
			board = new int[N + 1][N + 1];

			// 초기화
			board[N / 2][N / 2] = 2;
			board[N / 2 + 1][N / 2 + 1] = 2;
			board[N / 2 + 1][N / 2] = 1;
			board[N / 2][N / 2 + 1] = 1;
			
			pr();
			System.out.println("");
			
			if (N == 4 || N == 8 || N == 6) {
				for (int i = 0; i < M; i++) {
					int A = sc.nextInt();
					int B = sc.nextInt();
					int C = sc.nextInt(); // 1:흑, 2:백

					board[B][A] = C;
					change(B, A, C);
					pr();
					System.out.println("");

				}
			}
			int bc = 0;
			int wc = 0;
			for (int i = 1; i < N + 1; i++)
				for (int j = 1; j < N + 1; j++) {
					if (board[i][j] == 1)
						bc++;
					else if (board[i][j] == 2)
						wc++;
				}

			System.out.println("#" + tc + " " + bc + " " + wc);

		}

	}

	static void change(int x, int y, int c) {
		for (int d = 0; d < dir.length; d++) {
			int x2 = x + dir[d][0];
			int y2 = y + dir[d][1];

			if (x2 > 0 && y2 > 0 && x2 < N + 1 && y2 < N + 1) {
				if (board[x2][y2] == 0 || board[x2][y2] == c)
					continue;
				int count = 0;
				while (x2 > 0 && y2 > 0 && x2 < N + 1 && y2 < N + 1) {
					count++;
					x2 += dir[d][0];
					y2 += dir[d][1];
					
					if (x2 <= 0 || y2 <= 0 || x2 >= N + 1 || y2 >= N + 1)
						break;
					if (board[x2][y2] == 0)
						break;

					if (board[x2][y2] == c) {
						x2 -= dir[d][0];
						y2 -= dir[d][1];
						while (count != 0) {

							board[x2][y2] = c;
							x2 -= dir[d][0];
							y2 -= dir[d][1];
							count--;
						}
						break;
					}
				}
			}
		}

	}

	// 한 번 실행 후 결과
	static void pr() {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++)
				System.out.print(board[i][j] + " ");
			System.out.println("");
		}

	}
}