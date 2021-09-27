package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
public class sdffds {
	static int n,m,answer = Integer.MAX_VALUE;
	static List<int[]> listHome, listCk;
	static boolean[] visited;
	
  public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = stoi(st.nextToken());
      m = stoi(st.nextToken());

      listHome = new ArrayList<>();
      listCk = new ArrayList<>();
      
      for(int i=0; i<n; i++) {
    	  st = new StringTokenizer(br.readLine());
    	  for(int j=0; j<n; j++) {
    		  switch(stoi(st.nextToken())) {
    		  	case 1: //집일 때
    		  		listHome.add(new int[] {i, j});
    		  		break;
    		  	case 2: //치킨집일 때
    		  		listCk.add(new int[] {i, j});
    		  		break;
    		  }
    	  }
      }
      
      visited = new boolean[listCk.size()];
      
      comb(0, 0);
      System.out.println(answer);
   }
  /**
   * 
   * @param idx : 현재 탐색 위치
   * @param cnt : 조합 개수
   */
  static void comb(int idx, int cnt) {
	 //종료조건
	  if( cnt == m) {
		  int dist = 0;
		  
		  for(int[] home : listHome) {
			  int tmp = Integer.MAX_VALUE;
			  //FOR문: 각 집마다 치킨집까지의 최소 거리를 구한다.
			  for(int i=0; i<visited.length; i++) {
				  int[] chicken = listCk.get(i);
				  if(visited[i])
					  tmp = Math.min(tmp, Math.abs(chicken[0] - home[0])+ Math.abs(chicken[1] - home[1]));
			  }
			  
			  dist += tmp;
		  }
		  
		  //dist : m개의 조합으로 치킨집을 선택했을 때 도시의 치킨 거리이다. -> dist가 작을 때를 구해야 함
		  answer = Math.min(answer, dist);
		  return;
	  }
	 
	  for(int i=idx; i<visited.length; i++) {
		  visited[i] = true;
		  comb(i+1, cnt+1);
		  //다음 조합 탐색을 위해 돌려놓음
		  visited[i] = false;
	  }
  }
  
   public static int stoi(String str) {
      return Integer.parseInt(str);
   }

}