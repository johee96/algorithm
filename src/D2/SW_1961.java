//1961. 숫자 배열 회전
import java.util.*;

public class SW_1961 {
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int T = 1; T <= tc; T++) {
			N = sc.nextInt();
			int[][] M = new int[N][N];

			// 입력
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					M[i][j] = sc.nextInt();

			int[][] M90 = rotation90(M);
			int[][] M180 = rotation90(M90);
			int[][] M270 = rotation90(M180);
			System.out.println("#"+T);

			printM(M90, M180, M270);
			
			

		}
	}
	
	//90씩 회전
	static int[][] rotation90(int[][] M) {
		int[][] RM = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				RM[i][j] = M[N - 1 - j][i];

		return RM;
	}

	// 행렬출력
	static void printM(int[][] M90, int[][] M180, int[][] M270) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(M90[i][j]);
			}
			System.out.print(" ");
			for (int j = 0; j < N; j++) {
				System.out.print(M180[i][j]);
			}
			System.out.print(" ");

			for (int j = 0; j < N; j++) {
				System.out.print(M270[i][j]);
			}
			System.out.println(" ");
		}

	}
}
