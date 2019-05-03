import java.util.Scanner;
import java.util.Arrays;
public class SW_4050 {


    
	static int[] value;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for (int i = 1; i <= test_case; i++) {
			int sum = 0;
			int N = sc.nextInt();
			
			value = new int[N];

			for (int j = 0; j < N; j++)
				value[j] = sc.nextInt();

			Arrays.sort(value);
            
            for(int a=N-3;a>=0;a-=3)
				value[a] = 0;

			for (int k = 0; k < N; k++)
				sum += value[k];

			System.out.println("#" + i + " " + sum);

		}
	}
}
