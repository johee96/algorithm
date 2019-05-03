package EX;

//1���� [����SW�����׽�Ʈ �ؼ�] �ٱ⼼�����
import java.util.*;

class data_type {
   // 0:�� ����, 1: ��Ȱ��ȭ ����, 2: Ȱ��ȭ ����, 3: ��������
   int status;
   // HP - 0: ��������, ��Ȱ��ȭ ������ ��� ����, Ȱ��ȭ ������ ��� ����
   int LP, HP;
} 

public class SW_5653_EX {

   static final int MAXL = 352;
   static int T, N, M, K; // T:test case, N:����, M:����, K:�ð�
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

         // �ʱ�ȭ
         for (int i = 0; i < N + K + 2; i++)
            for (int j = 0; j < M + K + 2; j++) {
               Map[0][i][j] = new data_type();
               Map[1][i][j] = new data_type();
               Map[0][i][j].status = 0;
               Map[1][i][j].status = 0;
            }
         // �ʱ� �ٱ⼼���� life point
         for (int i = 0 + K / 2 + 1; i < N + K / 2 + 1; i++)
            for (int j = 0 + K / 2 + 1; j < M + K / 2 + 1; j++) {
               Map[0][i][j].LP = sc.nextInt();
               if (Map[0][i][j].LP > 0) {
                  Map[0][i][j].status = 1;
                  Map[0][i][j].HP = 0;
               }
            }
         // �ٱ� ������ K �ð� ���� ���� �� �� �ִ� �ִ� ����
         N = N + K + 2;
         M = M + K + 2;

         int CurMap = 0;
         // �ð�����for��
         for (int k = 0; k < K; k++) {
            for (int i = 0; i < N; i++) {
               for (int j = 0; j < M; j++) {

                  // ���� ������ ���
                  if (Map[CurMap][i][j].status == 3) {
                     // �ƹ����۵���������
                     Map[1 - CurMap][i][j].status = Map[CurMap][i][j].status;
                     continue;
                  }
                  // ��Ȱ��ȭ ������ ���
                  else if (Map[CurMap][i][j].status == 1) {
                     Map[1 - CurMap][i][j].HP = Map[CurMap][i][j].HP + 1;
                     Map[1 - CurMap][i][j].LP = Map[CurMap][i][j].LP;

                     if (Map[1 - CurMap][i][j].HP == Map[1 - CurMap][i][j].LP)
                        Map[1 - CurMap][i][j].status = 2;
                     else
                        Map[1 - CurMap][i][j].status = 1;
                  }
                  // Ȱ��ȭ ������ ���
                  else if (Map[CurMap][i][j].status == 2) {
                     // Ȱ��ȭ ���°� �� ��, ù �ð��� ���
                     if (Map[CurMap][i][j].HP == Map[CurMap][i][j].LP) {
                        // ���� ��ġ���� �� �� �� �� Ž��
                        for (int d = 0; d < 4; d++) {
                           int i2, j2;
                           i2 = i + dir[d][0];
                           j2 = j + dir[d][1];

                           // �ٱ� ������ �����ϴ� ������ ������� ���
                           if (Map[CurMap][i2][j2].status == 0) {

                              // �ϳ��� �ٱ� ������ �����Ϸ��� �ϴ� ���
                              if (Map[1 - CurMap][i2][j2].status == 0) {
                                 // �ش� �ٱ� ������ ���� ����
                                 Map[1 - CurMap][i2][j2].status = 1;
                                 Map[1 - CurMap][i2][j2].LP = Map[CurMap][i][j].LP;
                                 Map[1 - CurMap][i2][j2].HP = 0;

                              }
                              // �� �� �̻��� �ٱ� ������ ���� ���ÿ� �����Ϸ��� �ϴ� ���
                              // LP�� ���� ���� �켱������ ��
                              else if (Map[1 - CurMap][i2][j2].status == 1
                                    && Map[1 - CurMap][i2][j2].LP < Map[CurMap][i][j].LP) {
                                 Map[1 - CurMap][i2][j2].LP = Map[CurMap][i][j].LP;

                              }
                           }
                        }

                     }

                     // Ȱ�� �ð� ����
                     Map[1 - CurMap][i][j].HP = Map[CurMap][i][j].HP - 1;

                     // Ȱ�� ���� �ð��� LP�ð� ��ŭ ������ ���
                     if (Map[1 - CurMap][i][j].HP == 0)
                        Map[1 - CurMap][i][j].status = 3;
                     else
                        Map[1 - CurMap][i][j].status = 2;

                  }

               }

            }
            // ���� ���¸� ������ ���� MAP�� ���� MAP���� ����
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