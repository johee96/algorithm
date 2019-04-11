import java.util.Scanner;

//1795. �μ��� ���� ��Ƽ -���ͽ�Ʈ����
public class SW_1795 {

	public static int edge[][]; // �������
	public static int N; // ����� ��
	public static int distance1[]; // v���� �ٸ� �������� �ִ� �Ÿ�
	public static int distance2[]; // �ٸ� ��忡�� v������ �ִ� �Ÿ�

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

			int max = -1;
			for (int i = 1; i < N + 1; i++) {
				if (distance1[i] + distance2[i] > max)
					max = distance1[i] + distance2[i];
			}
			System.out.println("#" + test_case + " " + max);

		}

	}

	// v���� ���ư��� �� �ܹ����϶������غ���!
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

		// �ʱ�ȭ
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

			// �ּҰ� ã��
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

			// ���������κ��� ����� ��尡 ���� �͵� ó���ؾ���!!
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
