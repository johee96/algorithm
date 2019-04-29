//1242. 암호코드 스캔
import java.util.ArrayList;
import java.util.Scanner;

public class SW_1242 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			// 암호 추출
			ArrayList<String> pass = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				s = s.replace("0", " ");
				String k = s.trim();
				if (k.length() > 0) {
					s = s.replace(" ", "0");
					if (!pass.contains(s))
						pass.add(s);
				}

			}
			// 암호 이진수로 바꾸기
			String bin;
			int sum = 0;
			ArrayList<String> codes = new ArrayList<>(); // 전체암호
			for (int i = 0; i < pass.size(); i++) {
				bin = change16to2(pass.get(i));	//2진수로바꾸고
				int last_index = bin.lastIndexOf("1");
				bin = bin.substring(0, last_index + 1); // 뒤애 0제거

				ArrayList<String> c = pass(bin);
				for (int j = 0; j < c.size(); j++) {
					if (!codes.contains(c.get(j)))
						codes.add(c.get(j));

				}

			}
			sum = print(codes);
			System.out.println("#" + tc + " " + sum);

		}
	}

	
	static int bi(String str) {
		// 비를 통해서 두께를 알아야함
		int x1 = 0, x2 = 0, x3 = 0;
		boolean change1 = false, change2 = false;
		int last_idx = str.lastIndexOf("1");
		for (int i = last_idx; i >= 0; i--) {
			if (str.charAt(i) == '1' && !change1) {
				x1++;
			} else if (str.charAt(i) == '0' && !change2) {
				x2++;
				change1 = true;
			} else if (str.charAt(i) == '1' && change1) {
				x3++;
				change2 = true;
			} else if (str.charAt(i) == '0' && change2)
				break;
		}
		int bi = 1;
		while (true) {
			if (x1 == bi * 1 && x2 == bi * 1 && x3 == bi * 2)
				break;
			else if (x1 == bi * 1 && x2 == bi * 2 && x3 == bi * 2)
				break;
			else if (x1 == bi * 2 && x2 == bi * 2 && x3 == bi * 1)
				break;
			else if (x1 == bi * 1 && x2 == bi * 1 && x3 == bi * 4)
				break;
			else if (x1 == bi * 2 && x2 == bi * 3 && x3 == bi * 1)
				break;
			else if (x1 == bi * 1 && x2 == bi * 3 && x3 == bi * 2)
				break;
			else if (x1 == bi * 4 && x2 == bi * 1 && x3 == bi * 1)
				break;
			else if (x1 == bi * 2 && x2 == bi * 1 && x3 == bi * 3)
				break;
			else if (x1 == bi * 3 && x2 == bi * 1 && x3 == bi * 2)
				break;
			else if (x1 == bi * 2 && x2 == bi * 1 && x3 == bi * 1)
				break;
			else
				bi++;

		}
		return bi;
	}

	static ArrayList<String> pass(String str) {
		ArrayList<String> code = new ArrayList<>();
		while (str.contains("1")) {
			int last = str.lastIndexOf("1");
			int bi=bi(str);
			
			String sub=str.substring(last-55*bi,last+1);
			String changeSub =sub;
			String chan0 = "";
			String chan1 = "";

			for (int i = 0; i < bi; i++) {
				chan0 += "0";
				chan1 += "1";
			}
			changeSub = changeSub.replace(chan0, "0");
			changeSub = changeSub.replace(chan1, "1");
		
			String t = pass2(changeSub);
			if (!code.contains(t))
				code.add(t);
			str = str.replace(sub, "0");
		}
		return code;
	}
	static String pass2(String str) {

		String s = "";
		int last = str.lastIndexOf("1");
		String code = "";

		for (int index = 7; index >= 0; index--) {

			if (last < 0)
				break;
			if (last - 6 > 0)
				s = str.substring(last - 6, last + 1);
			else
				s = str.substring(0, last + 1);

			if (s.equals("0001101"))
				code = "0" + code;
			else if (s.equals("0011001"))
				code = "1" + code;
			else if (s.equals("0010011"))
				code = "2" + code;
			else if (s.equals("0111101"))
				code = "3" + code;
			else if (s.equals("0100011"))
				code = "4" + code;
			else if (s.equals("0110001"))
				code = "5" + code;
			else if (s.equals("0101111"))
				code = "6" + code;
			else if (s.equals("0111011"))
				code = "7" + code;
			else if (s.equals("0110111"))
				code = "8" + code;
			else if (s.equals("0001011"))
				code = "9" + code;
			last -= 7;

		}

		return code;
	}

	// 16진수를 2진수로 변환
	static String change16to2(String str) {
		String value = "";
		String[] hexa = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010",
				"1011", "1100", "1101", "1110", "1111" };
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case '0':
				value += hexa[0];
				break;
			case '1':
				value += hexa[1];
				break;
			case '2':
				value += hexa[2];
				break;
			case '3':
				value += hexa[3];
				break;
			case '4':
				value += hexa[4];
				break;
			case '5':
				value += hexa[5];
				break;
			case '6':
				value += hexa[6];
				break;
			case '7':
				value += hexa[7];
				break;
			case '8':
				value += hexa[8];
				break;
			case '9':
				value += hexa[9];
				break;
			case 'A':
				value += hexa[10];
				break;
			case 'B':
				value += hexa[11];
				break;
			case 'C':
				value += hexa[12];
				break;
			case 'D':
				value += hexa[13];
				break;
			case 'E':
				value += hexa[14];
				break;
			case 'F':
				value += hexa[15];
				break;
			default:
				System.out.println("wrong value");
			}
		}
		return value;
	}
	static int print(ArrayList<String> codes) {
		int sum = 0;
		for (int i = 0; i < codes.size(); i++) {
			if (((codes.get(i).charAt(0) - '0' + codes.get(i).charAt(2) - '0' + codes.get(i).charAt(4) - '0'
					+ codes.get(i).charAt(6) - '0') * 3 + codes.get(i).charAt(1) - '0' + codes.get(i).charAt(3) - '0'
					+ codes.get(i).charAt(5) - '0' + codes.get(i).charAt(7) - '0') > 9
					&& ((codes.get(i).charAt(0) - '0' + codes.get(i).charAt(2) - '0' + codes.get(i).charAt(4) - '0'
							+ codes.get(i).charAt(6) - '0') * 3 + codes.get(i).charAt(1) - '0' + codes.get(i).charAt(3)
							- '0' + codes.get(i).charAt(5) - '0' + codes.get(i).charAt(7) - '0') % 10 == 0)
				for (int j = 0; j < 8; j++)
					sum += codes.get(i).charAt(j) - '0';
		}
		return sum;
	}

}