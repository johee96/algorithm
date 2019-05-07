//1824. 혁진이의 프로그램 검증
package D4;

import java.util.Scanner;

public class SW_1824 {
	static int mem;
	static char[][] map;
	static String value = "";
	static int R, C;
	static boolean[][][][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			mem = 0;
			value = "NO";
			R = sc.nextInt();
			C = sc.nextInt();
			map = new char[R][C];
			visited = new boolean[R][C][4][16];
			boolean start = false;
			for (int i = 0; i < R; i++) {
				String str = sc.next();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
					if (str.charAt(j) == '@')
						start = true;
				}
			}
			if (start)
				check(0, 0, 3, 0);
			System.out.println("#" + tc + " " + value);
		}

	}

	static void check(int x, int y, int d, int count) {

		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, -1, 0, 1 };
		if (!visited[x][y][d][mem] && count < 3000) {
			if (map[x][y] >= '0' && map[x][y] <= '9')
				mem = map[x][y] - '0';
			else if (map[x][y] == '<')
				d = 1;
			else if (map[x][y] == '>')
				d = 3;
			else if (map[x][y] == '^')
				d = 2;
			else if (map[x][y] == 'v')
				d = 0;
			else if (map[x][y] == '_') {
				if (mem == 0)
					d = 3;
				else
					d = 1;

			} else if (map[x][y] == '|') {
				if (mem == 0)
					d = 0;
				else
					d = 2;
			} else if (map[x][y] == '.') {

			} else if (map[x][y] == '?') {

				for (int i = 0; i < 4; i++) {

					visited[x][y][d][mem] = true;
					if (x + dx[i] < 0)
						check(R - 1, y + dy[i], i, count + 1);
					else if (x + dx[i] > R - 1)
						check(0, y + dy[i], i, count + 1);
					else if (y + dy[i] < 0)
						check(x + dx[i], C - 1, i, count + 1);
					else if (y + dy[i] > C - 1)
						check(x + dx[i], 0, i, count + 1);
					else
						check(x + dx[i], y + dy[i], i, count + 1);
				}

			} else if (map[x][y] == '@') {
				value = "YES";
			} else if (map[x][y] == '+') {
				if (mem == 15)
					mem = 0;
				else
					mem++;

			} else if (map[x][y] == '-') {
				if (mem == 0)
					mem = 15;
				else
					mem--;
			}
			if (!value.equals("YES")) {
				visited[x][y][d][mem] = true;
				if (x + dx[d] < 0)
					check(R - 1, y + dy[d], d, count + 1);
				else if (x + dx[d] > R - 1)
					check(0, y + dy[d], d, count + 1);
				else if (y + dy[d] < 0)
					check(x + dx[d], C - 1, d, count + 1);
				else if (y + dy[d] > C - 1)
					check(x + dx[d], 0, d, count + 1);
				else
					check(x + dx[d], y + dy[d], d, count + 1);
			}
		} else {
			value = "NO";
		}
	}

}
