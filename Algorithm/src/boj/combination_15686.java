package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * ��¥: 2021/05/16
 * ����: ���� �˰��� 15686��_ġŲ ���
 * ����: https://girawhale.tistory.com/36
 */

public class combination_15686 {
    static int N, M, ans = Integer.MAX_VALUE;
    static boolean[] ck;
    static List<int[]> home, chicken;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                switch (stoi(st.nextToken())) {
                    case 1:
                        home.add(new int[]{i, j});
                        break;
                    case 2:
                        chicken.add(new int[]{i, j});
                        break;
                }
        }
        ck = new boolean[chicken.size()];
        comb(0, 0);

        System.out.println(ans);
    }

    static void comb(int idx, int cnt) {
        if (cnt == M) {
            int dist = 0;

            for (int[] h : home) {
                int tmp = Integer.MAX_VALUE;
                //�� ������ ġŲ�������� �Ÿ��� ���� �ּҰŸ� ã��
                for (int i = 0; i < ck.length; i++) {
                    if (ck[i])
                        tmp = Math.min(tmp, Math.abs(h[0] - chicken.get(i)[0]) + Math.abs(h[1] - chicken.get(i)[1]));
                }
                dist += tmp;
            }
            //dist = M�� ���պ� ������ ġŲ �Ÿ� => �ּҺ�� ã��
            ans = Math.min(ans, dist);
            return;
        }

        for (int i = idx; i < ck.length; i++) {
            ck[i] = true;
            comb(i, cnt + 1);
            ck[i] = false;
        }
    }
    
    static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}