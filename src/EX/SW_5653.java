package EX;
import java.util.Scanner;

class datatype {
	// 0:빈상태 1:비활성화 2:활성화 3:죽은상태
	int status;
	// HP는 피, LP는 라이프?
	int HP, LP;

}

public class SW_5653 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int MAXL = 352;
		int N, M, K;
		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			datatype data[][][] = new datatype[2][MAXL][MAXL];

			// 초기화
			for (int i = 0; i < N + K + 2; i++)
				for (int j = 0; j < M + K + 2; j++) {
					data[0][i][j] = new datatype();
					data[1][i][j] = new datatype();
					data[0][i][j].status = 0;
					data[1][i][j].status = 0;

				}

			// DATA넣기
			for (int i = K / 2 + 1; i <= K / 2 + N; i++)
				for (int j = K / 2 + 1; j <= K / 2 + M; j++) {
					data[0][i][j].LP = sc.nextInt();
					if (data[0][i][j].LP > 0) {
						data[0][i][j].status = 1;
						data[0][i][j].HP = 0;
					}

				}

			int cur = 0;
			for (int k = 0; k < K; k++) { // k시간동안
				for (int i = 0; i < N + K + 2; i++) {
					for (int j = 0; j < M + K + 2; j++) {
						// 죽은상태
						if (data[cur][i][j].status == 3) {
							data[1 - cur][i][j].status = data[cur][i][j].status;
							continue;
						}

						// 비활성화 상태
						if (data[cur][i][j].status == 1) {
							if (data[cur][i][j].HP < data[cur][i][j].LP) {
								data[1 - cur][i][j].HP = data[cur][i][j].HP + 1;
								data[1 - cur][i][j].LP = data[cur][i][j].LP;
							}
							if (data[1 - cur][i][j].HP == data[1 - cur][i][j].LP)
								data[1 - cur][i][j].status = 2; // 활성화로 바꾸기
							else
								data[1 - cur][i][j].status = 1; // 똑같이 비활성화

						}

						// 활성화 상태
						if (data[cur][i][j].status == 2) {
							if (data[cur][i][j].HP == data[cur][i][j].LP) {
								// 첫시작
								for (int w = 0; w < 4; w++) {
									int i2 = i + dx[w];
									int j2 = j + dy[w];
									// 옆이 빈상태 일 때
									if (data[cur][i2][j2].status == 0) {
										// 혼자차지
										if (data[1 - cur][i2][j2].status == 0) {
											data[1 - cur][i2][j2].LP = data[cur][i][j].LP;
											data[1 - cur][i2][j2].status = 1;
											data[1 - cur][i2][j2].HP = 0;

										}
										// 이미누가있음
										else if (data[1 - cur][i2][j2].status == 1
												&& data[1 - cur][i2][j2].LP < data[cur][i][j].LP) {
											data[1 - cur][i2][j2].LP = data[cur][i][j].LP;
											data[1 - cur][i2][j2].status = 1;
											data[1 - cur][i2][j2].HP = 0;
										}
									}
								}
							}
							data[1 - cur][i][j].HP = data[cur][i][j].HP - 1;
							data[1 - cur][i][j].LP = data[cur][i][j].LP;

							if (data[1 - cur][i][j].HP == 0)
								data[1 - cur][i][j].status = 3;
							else
								data[1 - cur][i][j].status = 2;

						}
					}
				}
				cur = 1 - cur;
			}

			// 개수세기
			int count = 0;
			for (int i = 0; i < N + K + 2; i++) {
				for (int j = 0; j < M + K + 2; j++) {
					if (data[cur][i][j].status == 1 || data[cur][i][j].status == 2)
						count++;
				}
			}
			System.out.println("#" + tc + " " + count);

		}
	}

}