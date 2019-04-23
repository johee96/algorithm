
//1차시 [모의SW역량테스트 해설] 줄기세포배양
import java.util.*;

class data_type {
   // 0:빈 공간, 1: 비활성화 상태, 2: 활성화 상태, 3: 죽은상태
   int status;
   // HP - 0: 죽은상태, 비활성화 상태일 경우 증가, 활성화 상태일 경우 감소
   int LP, HP;
} 

public class SW_5653_EX {

   static final int MAXL = 352;
   static int T, N, M, K; // T:test case, N:세로, M:가로, K:시간
   static data_type[][][] Map = new data_type[2][MAXL][MAXL];
   static int[][] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      T = sc.nextInt();

      for (int tc = 1; tc <= T; tc++) {

         N = sc.nextInt();
         M = sc.nextInt();
         K = sc.nextInt();

         // 초기화
         for (int i = 0; i < N + K + 2; i++)
            for (int j = 0; j < M + K + 2; j++) {
               Map[0][i][j] = new data_type();
               Map[1][i][j] = new data_type();
               Map[0][i][j].status = 0;
               Map[1][i][j].status = 0;
            }
         // 초기 줄기세포의 life point
         for (int i = 0 + K / 2 + 1; i < N + K / 2 + 1; i++)
            for (int j = 0 + K / 2 + 1; j < M + K / 2 + 1; j++) {
               Map[0][i][j].LP = sc.nextInt();
               if (Map[0][i][j].LP > 0) {
                  Map[0][i][j].status = 1;
                  Map[0][i][j].HP = 0;
               }
            }
         // 줄기 세포가 K 시간 내에 분포 할 수 있는 최대 범위
         N = N + K + 2;
         M = M + K + 2;

         int CurMap = 0;
         // 시간동안for문
         for (int k = 0; k < K; k++) {
            for (int i = 0; i < N; i++) {
               for (int j = 0; j < M; j++) {

                  // 죽은 세포일 경우
                  if (Map[CurMap][i][j].status == 3) {
                     // 아무동작도하지않음
                     Map[1 - CurMap][i][j].status = Map[CurMap][i][j].status;
                     continue;
                  }
                  // 비활성화 세포일 경우
                  else if (Map[CurMap][i][j].status == 1) {
                     Map[1 - CurMap][i][j].HP = Map[CurMap][i][j].HP + 1;
                     Map[1 - CurMap][i][j].LP = Map[CurMap][i][j].LP;

                     if (Map[1 - CurMap][i][j].HP == Map[1 - CurMap][i][j].LP)
                        Map[1 - CurMap][i][j].status = 2;
                     else
                        Map[1 - CurMap][i][j].status = 1;
                  }
                  // 활성화 세포일 경우
                  else if (Map[CurMap][i][j].status == 2) {
                     // 활성화 상태가 된 후, 첫 시간일 경우
                     if (Map[CurMap][i][j].HP == Map[CurMap][i][j].LP) {
                        // 현재 위치에서 상 하 좌 우 탐색
                        for (int d = 0; d < 4; d++) {
                           int i2, j2;
                           i2 = i + dir[d][0];
                           j2 = j + dir[d][1];

                           // 줄기 세포가 번식하는 방향이 비어있을 경우
                           if (Map[CurMap][i2][j2].status == 0) {

                              // 하나의 줄기 세포가 번식하려고 하는 경우
                              if (Map[1 - CurMap][i2][j2].status == 0) {
                                 // 해당 줄기 세포가 셀을 차지
                                 Map[1 - CurMap][i2][j2].status = 1;
                                 Map[1 - CurMap][i2][j2].LP = Map[CurMap][i][j].LP;
                                 Map[1 - CurMap][i2][j2].HP = 0;

                              }
                              // 두 개 이상의 줄기 세포가 셀에 동시에 번식하려고 하는 경우
                              // LP가 높은 것을 우선순위로 함
                              else if (Map[1 - CurMap][i2][j2].status == 1
                                    && Map[1 - CurMap][i2][j2].LP < Map[CurMap][i][j].LP) {
                                 Map[1 - CurMap][i2][j2].LP = Map[CurMap][i][j].LP;

                              }
                           }
                        }

                     }

                     // 활성 시간 증가
                     Map[1 - CurMap][i][j].HP = Map[CurMap][i][j].HP - 1;

                     // 활성 상태 시간이 LP시간 만큼 지났을 경우
                     if (Map[1 - CurMap][i][j].HP == 0)
                        Map[1 - CurMap][i][j].status = 3;
                     else
                        Map[1 - CurMap][i][j].status = 2;

                  }

               }

            }
            // 현재 상태를 저장해 놓은 MAP을 현재 MAP으로 변경
            CurMap = 1 - CurMap;
         }

         int Answer = 0;
         for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
               if (Map[CurMap][i][j].status == 1 || Map[CurMap][i][j].status == 2)
                  Answer++;
         System.out.printf("#%d %d\n", tc, Answer);

      }

   }

}