import java.util.Scanner;

public class SW_6109 {

	 static int N = 0;
	   static int[][] farm;
	   static boolean[][] result;

	   public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      Scanner sc = new Scanner(System.in);
	      int testCase = Integer.parseInt(sc.nextLine());

	      for (int test_case = 0; test_case < testCase; test_case++) {
	         N = sc.nextInt();
	         String S = sc.next();
	         farm = new int[N][N];
	         result = new boolean[N][N];
	         for (int i = 0; i < N; i++)
	            for (int j = 0; j < N; j++) {
	               farm[i][j] = sc.nextInt();
	               result[i][j] = false;
	            }
	         System.out.println("#" + (test_case + 1));
	         if (S.equals("up"))
	            up();
	         else if (S.equals("down"))
	            down();
	         else if (S.equals("left"))
	            left();
	         else if(S.equals("right"))
	            right();

	         for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	               System.out.print(farm[i][j] + " ");
	            }
	            System.out.println("");
	         }

	      }

	   }

	   static void up() {
	      int count = 0;
	      for (int i = 0; i < N - 1; i++) {
	         for (int j = 0; j < N; j++) {
	            if ((farm[i][j] == farm[i + 1][j]) && result[i][j] == false
	                  && result[i + 1][j] == false) {
	               farm[i][j] = farm[i][j] * 2;
	               
	               if (farm[i][j] == 0) {
	                   farm[i][j] = farm[i + 1][j];
	                   farm[i + 1][j] = 0;
	                }
	               else if (farm[i][j] != 0) {
	                  result[i][j] = true;
	                  farm[i + 1][j] = 0;
	                  count++;
	               }
	            } else if (farm[i][j] == 0 && result[i][j] == false && result[i + 1][j] == false) {
	               farm[i][j] = farm[i + 1][j];
	               farm[i + 1][j] = 0;
	               count++;
	            }


	         }
	      }
	      if (count > 0) {

	         up();
	      }

	   }

	   static void down() {
	      int count = 0;
	      for (int i = N - 1; i > 0; i--) {
	         for (int j = 0; j < N; j++) {
	            if ((farm[i][j] == farm[i - 1][j])  && result[i][j] == false
	                  && result[i - 1][j] == false) {
	               farm[i][j] = farm[i][j] * 2;

	               if (farm[i][j] == 0) {
	                   farm[i][j] = farm[i - 1][j];
	                   farm[i - 1][j] = 0;
	                }
	               else if (farm[i][j] != 0) {

	                  result[i][j] = true;
	                  farm[i - 1][j] = 0;
	                  count++;
	               }

	            } else if ((farm[i][j] == 0) && result[i][j] == false && result[i - 1][j] == false) {
	               farm[i][j] = farm[i - 1][j];
	               farm[i - 1][j] = 0;
	               count++;
	            }

	            
	         }
	      }
	      if (count > 0)
	         down();

	   }

	   static void right() {
	      int count = 0;
	      for (int i = 0; i < N; i++) {
	         for (int j = N - 1; j > 0; j--) {
	            if ((farm[i][j] == farm[i][j - 1]) && result[i][j] == false
	                  && result[i][j - 1] == false) {
	               farm[i][j] = farm[i][j] * 2;
	               
	               if (farm[i][j] == 0) {
	                   farm[i][j] = farm[i][j - 1];
	                   farm[i][j - 1] = 0;
	                }
	               else if (farm[i][j] != 0) {
	                  result[i][j] = true;
	                  farm[i][j - 1] = 0;
	                  count++;

	               }

	            } else if ((farm[i][j] == 0) && result[i][j] == false && result[i][j - 1] == false) {
	               farm[i][j] = farm[i][j - 1];
	               farm[i][j - 1] = 0;
	               count++;
	            }

	         
	         }
	      }
	      if (count > 0)
	         right();

	   }

	   static void left() {

	      int count = 0;
	      for (int i = 0; i < N; i++) {
	         for (int j = 0; j < N - 1; j++) {

	            if ((farm[i][j] == farm[i][j + 1])&& result[i][j] == false
	                  && result[i][j + 1] == false) {
	               farm[i][j] = farm[i][j] * 2;
	              
	               if (farm[i][j] == 0) {
	                   farm[i][j] = farm[i][j + 1];
	                   farm[i][j + 1] = 0;
	                }else if (farm[i][j] != 0) {
	                  result[i][j] = true;
	                  farm[i][j + 1] = 0;
	                  count++;
	               }

	            } else if ((farm[i][j] == 0) && result[i][j] == false && result[i][j + 1] == false) {
	               farm[i][j] = farm[i][j + 1];
	               farm[i][j + 1] = 0;
	               count++;
	            }

	         
	         }
	      }
	      if (count > 0)
	         left();

	   }
}
