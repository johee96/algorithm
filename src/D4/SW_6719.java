import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
public class SW_6719 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			double A = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int data[]=new int[N];
			for(int i=0;i<N;i++) {
				data[i] = sc.nextInt();
			}
			Arrays.sort(data);
			
			for(int i =N-M; i<N;i++) {
				A = (A+data[i])/2;
			}
			
			System.out.println("#"+(test_case)+" "+A);

		}
	}

}
