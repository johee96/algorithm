import java.util.Scanner;
import java.util.ArrayList;
public class SW_5521 {
	 static public boolean visited[];
		static public boolean edge[][];

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			Scanner sc = new Scanner(System.in);
			int testCase = sc.nextInt();
			for (int test = 1; test <= testCase; test++) {

				int N = sc.nextInt();
				int M = sc.nextInt();
				boolean hasf = false;
				visited = new boolean[N + 1];
				edge = new boolean[N + 1][N + 1];
				for (int i = 1; i <= M; i++) {
					int v1 = sc.nextInt();
					int v2 = sc.nextInt();
					edge[v1][v2] = edge[v2][v1] = true;
					if (v1 == 1 || v2 == 1)
						hasf = true;

				}

				if (hasf) {
					int c = party();
					System.out.println("#" + test + " " + (c - 1));

				} else
					System.out.println("#" + test + " 0");

			}
		}

		static int party() {
			int count = 0;
			ArrayList<Integer> data = new ArrayList<Integer>();
			// 1과 연결된 애들
			for (int i = 1; i < edge.length; i++) {
				if (edge[1][i]) {
					data.add(i);
					visited[i] = true;
					count++;
				}
			}

			for (int i = 0; i < data.size(); i++) {
				for (int k = 1; k < edge.length; k++) {
					if (edge[data.get(i)][k] && visited[k] == false) {
						count++;
						visited[k] = true;
					}

				}
			}

			return count;

		}
}
