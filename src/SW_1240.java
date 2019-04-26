
//1240. [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드 
import java.util.Scanner;

public class SW_1240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String r = "";
			int code[] = new int[8];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				if (s.contains("1"))
					r = s;

			}
			// 7개씩 잘라서 0~9를정의
			int last = r.lastIndexOf("1");	
			String s;
			for (int index = 7; index >= 0; index--) {
				s = r.substring(last - 6, last + 1);
				if (s.equals("0001101"))
					code[index] = 0;
				else if (s.equals("0011001"))
					code[index] = 1;
				else if (s.equals("0010011"))
					code[index] = 2;
				else if (s.equals("0111101"))
					code[index] = 3;
				else if (s.equals("0100011"))
					code[index] = 4;
				else if (s.equals("0110001"))
					code[index] = 5;
				else if (s.equals("0101111"))
					code[index] = 6;
				else if (s.equals("0111011"))
					code[index] = 7;
				else if (s.equals("0110111"))
					code[index] = 8;
				else if (s.equals("0001011"))
					code[index] = 9;
				else
					;
				last -= 7;

			}

			int sum = 0;
			if (((code[0] + code[2] + code[4] + code[6]) * 3 + code[1] + code[3] + code[5] + code[7]) > 9
					&& ((code[0] + code[2] + code[4] + code[6]) * 3 + code[1] + code[3] + code[5] + code[7]) % 10 == 0)
				for (int i = 0; i < 8; i++)
					sum += code[i];

			System.out.println("#" + tc + " " + sum);
		}

	}

}