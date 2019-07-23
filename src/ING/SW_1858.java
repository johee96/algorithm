package ING;
import java.util.ArrayList;
import java.util.Scanner;

public class SW_1858 {

	public static double edgeV[][];
	public static double edgeL[][];
	public static double time[];
	public static boolean visited[];

	public static double preV;
	public static int N;
	public static int c[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);//test
		int test = sc.nextInt();
		for (int test_case = 1; test_case <= test; test_case++) {

			N = sc.nextInt(); // ������ ��
			int M = sc.nextInt(); // ���� ��
			int D = sc.nextInt(); // ��ǥ���� D

			edgeV = new double[M][M];
			edgeL = new double[M][M];
			time = new double[N];
			visited = new boolean[N];
			c = new int[N];
			for (int i = 0; i < M; i++)
				for (int j = 0; j < M; j++) {
					edgeV[i][j] = -1;
					edgeL[i][j] = -1;

				}

			for (int i = 0; i < M; i++) {
				int S = sc.nextInt(); // ����
				int E = sc.nextInt(); // ��
				int V = sc.nextInt(); // �ӵ�
				int L = sc.nextInt(); // �Ÿ�

				edgeV[S][E] = V;
				edgeL[S][E] = L;

			}

			dijkstra(D);

			int path[] = new int[N];

			int path_cnt = 0;

			int k = D;

			while (true)

			{

				path[path_cnt++] = k;

				if (k == 0)

					break;

				k = c[k];

			}

			System.out.print(" ��� :");
			int i = 0;
			for (i = path_cnt - 1; i >= 1; i--)

			{

				System.out.printf("%d -> ", path[i]);

			}

			System.out.printf("%d .", path[i]);

			/*
			 * System.out.print("#" + test_case +" 0");
			 * 
			 * for (int i = 0; i < time.length; i++) { System.out.print(" " + time[i]); }
			 * System.out.println(" ");
			 */

			/*
			 * for (int i = 0; i < N; i++) { System.out.print(i + "�� ������ �ִ� ��� : ");
			 * 
			 * int j = i;
			 * 
			 * System.out.print(j);
			 * 
			 * while (j != 0) { System.out.print(" <- " + c[j]); j = c[j]; }
			 * 
			 * System.out.println(""); }
			 * 
			 * 
			 * for(int i=0; i<N;i++) System.out.print(" " + c[i]);
			 */
			System.out.println(" ");

			for (int kk = 0; kk < c.length; kk++)
				System.out.println(c[kk] + " ");
		}

	}

	public static void dijkstra(int d) {
		// time�� �� �ɸ� �ð�
		for (int i = 0; i < N; i++) {
			time[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

		visited[0] = true;
		time[0] = 0;
		// �ʱ�ȭ
		for (int i = 0; i < N; i++) {
			if (!visited[i] && edgeL[0][i] >= 0) {
				if (edgeV[0][i] > 0) {
					time[i] = edgeL[0][i] / edgeV[0][i];
					preV = edgeV[0][i];
				} else if (edgeV[0][i] == 0) {
					time[i] = edgeL[0][i] / 70;
					preV = 70;
				}
				System.out.println("[-2] time[" + i + "] : " + time[i]);

			}
		}

		// ���ã��!!!
		for (int a = 0; a < N - 1; a++) {

			double min = Integer.MAX_VALUE;
			int minIdx = -1;

			// �ּҰ�ã��
			for (int i = 0; i < N; i++) {
				if (!visited[i] && time[i] != Integer.MAX_VALUE)
					if (min > time[i]) {
						min = time[i];
						minIdx = i;
					}
			}
			System.out.println("[-1] min: " + minIdx + " time[i] : " + min);

			if (minIdx > -1) {
				visited[minIdx] = true;
				for (int i = 0; i < N; i++) {

					if (!visited[i] && edgeV[minIdx][i] >= 0) {
						double v;
						if (edgeV[minIdx][i] == 0)
							v = preV;
						else
							v = edgeV[minIdx][i];
						System.out.println("[0] min: " + minIdx + " i: " + i + " time[i] : " + time[i] + " time[min] : "
								+ time[minIdx] + " ���:" + (time[minIdx] + edgeL[minIdx][i] / v));

						if (time[i] > time[minIdx] + edgeL[minIdx][i] / v) {
							System.out.println("[1] min: " + minIdx + " i: " + i + " time[i] : " + time[i]
									+ " time[min] : " + time[minIdx] + " ���:" + (time[minIdx] + edgeL[minIdx][i] / v));

							time[i] = time[minIdx] + edgeL[minIdx][i] / v;
							System.out.println("[3] : c[ " + i + "] :" + minIdx);

							c[i] = minIdx;
							preV = v;
						}

					}
					/*
					 * else if (!visited[i] && edgeV[minIdx][i] == 0) { if (time[i] > time[minIdx] +
					 * edgeL[minIdx][i] / preV) { System.out.println("[2] min: " + minIdx +" i: " +
					 * i+ " time[i] : " + time[i] + " time[min] : " + time[minIdx] + " ���:" + (
					 * time[minIdx] + edgeL[minIdx][i] / preV)); c[i]=minIdx; time[i] = time[minIdx]
					 * + edgeL[minIdx][i] / preV;
					 * 
					 * 
					 * } }
					 */
				}

			}

		}

	}

}