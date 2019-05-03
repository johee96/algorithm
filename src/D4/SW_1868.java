package D4;
//1868. 파핑파핑 지뢰찾기
import java.util.Scanner;

public class SW_1868 {

	static boolean visited[][];
	static char map[][];
	static int N;
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new char[N][N];
			visited = new boolean[N][N];
			sc.nextLine();
			for (int i = 0; i < N; i++) {
				String st = sc.nextLine();
				for (int j = 0; j < N; j++)
					map[i][j] = st.charAt(j);
			}

			// 값채우기
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					value(i, j);

			// 0인 처리
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (map[i][j] == '0' && !visited[i][j]) {
						find0(i, j);
						count++;
					}
			// 남은 것 처리
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (map[i][j] != '*' && !visited[i][j])
						count++;

			System.out.println("#" + tc + " " + count);
			count = 0;
		}
	}

	static void value(int a, int b) {
		int dx[] = { 1, 1, 1, -1, -1, -1, 0, 0 };
		int dy[] = { 0, 1, -1, 0, -1, 1, 1, -1 };

		if (map[a][b] != '*') {
			int count2 = 0;
			for (int i = 0; i < 8; i++) {
				int x = dx[i] + a;
				int y = dy[i] + b;
				if (x >= 0 && y >= 0 && x < N && y < N)
					if (map[x][y] == '*') {
						count2++;
						visited[x][y] = true;
					}
			}

			map[a][b] = Character.forDigit(count2, 10);

		}
	}

	static void find0(int a, int b) {
		visited[a][b] = true;
		int dx[] = { 1, 1, 1, -1, -1, -1, 0, 0 };
		int dy[] = { 0, 1, -1, 0, -1, 1, 1, -1 };
		for (int i = 0; i < 8; i++) {
			int x = dx[i] + a;
			int y = dy[i] + b;
			if (x >= 0 && y >= 0 && x < N && y < N) {
				if (!visited[x][y] && map[x][y] == '0')
					find0(x, y);
				else if (!visited[x][y] && map[x][y] != '*')
					visited[x][y] = true;

			}
		}

	}

}