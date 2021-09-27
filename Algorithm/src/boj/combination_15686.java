package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/05/16
 * 문제: 백준 알고리즘 15686번_치킨 배달
 * 설명: https://girawhale.tistory.com/36
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
                //각 집에서 치킨집까지의 거리를 비교후 최소거리 찾기
                for (int i = 0; i < ck.length; i++) {
                    if (ck[i])
                        tmp = Math.min(tmp, Math.abs(h[0] - chicken.get(i)[0]) + Math.abs(h[1] - chicken.get(i)[1]));
                }
                dist += tmp;
            }
            //dist = M개 조합별 도시의 치킨 거리 => 최소비용 찾기
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