package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int ans = Integer.MAX_VALUE;
	static List<int[]> listHome;
	static List<int[]> listChicken;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		
		listHome = new ArrayList<>();
		listChicken = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				switch(stoi(st.nextToken())) {
					case 1:
						listHome.add(new int[] {i, j});
						break;
					case 2:
						listChicken.add(new int[] {i, j});
						break;
				}
			}
		}
		
		visited = new boolean[listChicken.size()];
		
		comb(0, 0);
		System.out.println(ans);
	}
	
	static void comb(int idx, int cnt) {
		//종료조건(뽑은 조합으로 최소비용 구하기)
		if( cnt == m ) {
			int dist = 0;
			
			//각 집마다 치킨집까지의 최소거리를 구한다.
			for(int[] h : listHome) {
				int tmp = Integer.MAX_VALUE;
				for(int i=0; i<listChicken.size(); i++) {
					if(visited[i]) {
						tmp = Math.min(tmp, Math.abs(listChicken.get(i)[0] - h[0]) + Math.abs(listChicken.get(i)[1] - h[1]));
					}
				}
				
				dist += tmp;
			}
			
			ans = Math.min(ans, dist);
			
			return;
		}
		
		//조합 뽑는 부분
		for(int i=idx; i<listChicken.size(); i++) {
			visited[i] = true;
			comb(i+1, cnt+1);
			//다음 조합탐색을 위해 되돌려줌
			visited[i] = false;
		}
	}
	
	static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
