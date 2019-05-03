package D4;
import java.util.Scanner;
import java.util.Arrays;
public class SW_6855 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			int data[]=new int[N];
			int gap[] = new int[N-1];
			int dist = 0;
			for(int i=0;i<N;i++) {
				data[i] = sc.nextInt();
				}
			if(N<K || N==K) {
				dist = 0;
			}
			else {
				for(int i=1;i<N;i++) {
					gap[i-1]= data[i]-data[i-1];
				}
				int sortGap[] =gap;
			    Arrays.sort(sortGap);
			    
			    int count=0;
			    for(int i = N-2; i>=0;i--) {
			    	if(sortGap[i] == gap[i] && count<K) {
			    		if(count==K-1) {
			    			dist+=gap[i];
			    		
			    		}
			    		count++;
			    	}else {
			    		dist+=gap[i];

			    	}
			    }
			}	
			
			System.out.println("#"+(test_case)+" "+dist);

		}
	}

}
