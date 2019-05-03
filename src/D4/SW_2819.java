package D4;
//2819. 격자판의 숫자 이어 붙이기
import java.util.ArrayList;
import java.util.Scanner;

public class SW_2819 {
	static ArrayList<Integer> value;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			value = new ArrayList<Integer>();

			int map[][] = new int[4][4];
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					map[i][j] = sc.nextInt();

			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++) {
					dfs(i, j, map, 0, 0);

				}
			System.out.println("#" + tc + " " + value.size());

		}

	}

	static void dfs(int a, int b, int[][] map, int v, int count) {

		v += map[a][b] * Math.pow(10, count);
		count++;
		int x[] = { 0, 0, 1, -1 };
		int y[] = { 1, -1, 0, 0 };

		if (count < 7) {
			for (int i = 0; i < 4; i++) {
				int f = x[i] + a;
				int s = y[i] + b;
				if (f >= 0 && f < 4 && s >= 0 && s < 4) {
					dfs(f, s, map, v, count);
				}

			}

		} else if (count == 7) {
			if (!value.contains(v)) {
				value.add(v);
				// System.out.println(v);
			}
		}
	}

}