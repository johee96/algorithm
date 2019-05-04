//1974.스도쿠 검증
package D2;

import java.util.Scanner;
import java.util.TreeSet;

public class SW_1974 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int map[][] = new int[9][9];
			int score = 1;
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					map[i][j] = sc.nextInt();
			TreeSet<Integer> set = new TreeSet(); // 중복확인

			for (int i = 0; i < 9; i++) {
				set.clear();
				for (int j = 0; j < 9; j++)
					set.add(map[i][j]);

				if (set.size() != 9) {
					score = 0;
					break;
				}
			}
			if (score == 1) {
				for (int i = 0; i < 9; i++) {
					set.clear();
					for (int j = 0; j < 9; j++)
						set.add(map[j][i]);

					if (set.size() != 9) {
						score = 0;
						break;
					}
				}
			}

			if (score == 1) {
				for (int i = 0; i < 9; i = i + 3) {
					set.clear();
					int count = 1;
					while (count <= 3) {

						for (int a = i; a < i + 3; a++)
							for (int b = 3 * (count - 1); b < 3 * count; b++)
								set.add(map[a][b]);

						if (set.size() != 9) {
							score = 0;
							break;
						}
						count++;
					}

				}
			}

			System.out.println("#" + tc + " " + score);
		}

	}

}
