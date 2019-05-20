package EX;

import java.util.Scanner;

public class SW_4131 {

   static int count;
   static int N;
   static int X;
   static int map[][];
   static int m[];

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      for (int tc = 1; tc <= T; tc++) {
         N = sc.nextInt();
         X = sc.nextInt();
         map = new int[N][N];
         m = new int[N];
         count = 0;
         for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
               map[i][j] = sc.nextInt();

         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
               m[j] = map[i][j];
            if (runway())
               count++;

         }

         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
               m[j] = map[j][i];
            if (runway())
               count++;

         }
         System.out.println("#" + tc + " " + count);
      }

   }

   static boolean runway() {
      boolean up[] = new boolean[N];
      boolean down[] = new boolean[N];

      // 2차이 날 때
      for (int i = 0; i < N - 1; i++)
         if (m[i] - m[i + 1] >= 2 || m[i] - m[i + 1] <= -2)
            return false;

      //다 똑같으면
      int c=0;
      for (int i = 0; i < N-1; i++)
         if (m[i] == m[i + 1])
            c++;
      if(c==N-1)
         return true;
      
      for (int i = 0; i < N - 1; i++) {
         if (m[i] + 1 == m[i + 1]) {
            int s = i - X + 1;
            int e = i;
            if (check(s, e)) {
               for (int j = s; j <= e; j++)
                  up[j] = true;
            } else {
               return false;
            }
         } else if (m[i] - 1 == m[i + 1]) {
            int s = i + 1;
            int e = i + X;
            if (check(s, e)) {
               for (int j = s; j <= e; j++)
                  down[j] = true;
            } else
               return false;
         }

      }

      for (int i = 0; i < N; i++)
         if (up[i] && down[i])
            return false;

      return true;
   }

   static boolean check(int s, int e) {
      if (s < 0 || N <= e)
         return false;

      for (int i = s; i < e; i++)
         if (m[i] != m[i + 1])
            return false;

      return true;

   }

}