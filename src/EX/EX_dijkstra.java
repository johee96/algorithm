package EX;
import java.util.Scanner;

public class EX_dijkstra {

	public static int edge[][]; // �������
	public static int N; // ����� ��
	public static int distance1[]; // �������� �ִ� �Ÿ�

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int test_case = 1; test_case <= test; test_case++) {
			N = sc.nextInt(); // ��� ��
			int M = sc.nextInt(); // ���� ��
			int X = sc.nextInt(); // ������
			edge = new int[N + 1][N + 1];

			for (int i = 1; i <= M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				edge[a][b] = c;
			}

			dijkstra(X);
			System.out.print("dist[i] :");
			for(int i=1; i<N+1; i++)
				System.out.print(" " + distance1[i]);

		}

	}

	public static void dijkstra(int v) {
		// v�� ����(������)
		distance1 = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 1; i < N + 1; i++) {
			distance1[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		distance1[v] = 0;
		visited[v] = true;

		// �ʱ�ȭ
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i] && edge[v][i] != 0)
				distance1[i] = edge[v][i];
		}

		// dijkstra��� �� n-1�� �ݺ���
		for (int a = 0; a < N - 1; a++) {
			int min = Integer.MAX_VALUE;
			int minIdx = -1;

			// �ּҰ� ã��
			for (int i = 1; i < N + 1; i++) {
				if (!visited[i] && distance1[i] != Integer.MAX_VALUE)
					if (min > distance1[i]) {
						min = distance1[i];
						minIdx = i;
					}
			}
			visited[minIdx] = true;

			for (int i = 1; i < N + 1; i++) {
				if (!visited[i] && edge[minIdx][i] != 0)
					if (distance1[i] > distance1[minIdx] + edge[minIdx][i])
						distance1[i] = distance1[minIdx] + edge[minIdx][i];

			}

		}

	}
}
