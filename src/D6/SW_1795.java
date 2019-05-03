import java.util.Scanner;

//1795. 인수의 생일 파티 -다익스트라사용
public class SW_1795 {

	public static int edge[][]; // 연결관계
	public static int N; // 노드의 수
	public static int distance1[]; // v에서 다른 노드까지의 최단 거리
	public static int distance2[]; // 다른 노드에서 v까지의 최단 거리

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int test_case = 1; test_case <= test; test_case++) {
			N = sc.nextInt(); // 노드 수
			int M = sc.nextInt(); // 관계 수
			int X = sc.nextInt(); // 기준점
			edge = new int[N + 1][N + 1];

			for (int i = 1; i <= M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				edge[a][b] = c;
			}

			dijkstra(X);

			int max = -1;
			for (int i = 1; i < N + 1; i++) {
				if (distance1[i] + distance2[i] > max)
					max = distance1[i] + distance2[i];
			}
			System.out.println("#" + test_case + " " + max);

		}

	}

	// v에서 돌아가는 것 단방향일때먼저해보자!
	public static void dijkstra(int v) {
		distance1 = new int[N + 1];
		distance2 = new int[N + 1];

		boolean[] visited1 = new boolean[N + 1];
		boolean[] visited2 = new boolean[N + 1];

		for (int i = 1; i < N + 1; i++) {
			distance1[i] = Integer.MAX_VALUE;
			visited1[i] = false;

			distance2[i] = Integer.MAX_VALUE;
			visited2[i] = false;
		}
		distance1[v] = 0;
		visited1[v] = true;

		distance2[v] = 0;
		visited2[v] = true;

		// 초기화
		for (int i = 1; i < N + 1; i++) {
			if (!visited1[i] && edge[v][i] != 0)
				distance1[i] = edge[v][i];
			if (!visited2[i] && edge[i][v] != 0)
				distance2[i] = edge[i][v];
		}

		for (int a = 1; a <= N - 1; a++) {
			int min1 = Integer.MAX_VALUE;
			int minIdx1 = -1;

			int min2 = Integer.MAX_VALUE;
			int minIdx2 = -1;

			// 최소값 찾기
			for (int i = 1; i < N + 1; i++) {
				if (!visited1[i] && distance1[i] != Integer.MAX_VALUE)
					if (min1 > distance1[i]) {
						min1 = distance1[i];
						minIdx1 = i;
					}

				if (!visited2[i] && distance2[i] != Integer.MAX_VALUE)
					if (min2 > distance2[i]) {
						min2 = distance2[i];
						minIdx2 = i;
					}
			}

			// 기준점으로부터 연결된 노드가 없는 것도 처리해야함!!
			if (minIdx1 > -1 && minIdx2 > -1) {
				visited1[minIdx1] = true;
				visited2[minIdx2] = true;

				for (int i = 1; i < N + 1; i++) {
					
					if (!visited1[i] && edge[minIdx1][i] != 0)
						if (distance1[i] > distance1[minIdx1] + edge[minIdx1][i]) {
							distance1[i] = distance1[minIdx1] + edge[minIdx1][i];
						}
					
					if (!visited2[i] && edge[i][minIdx2] != 0)
						if (distance2[i] > distance2[minIdx2] + edge[i][minIdx2])
							distance2[i] = distance2[minIdx2] + edge[i][minIdx2];

				}
			}

		}

	}

}
