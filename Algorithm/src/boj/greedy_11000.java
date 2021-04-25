package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/04/25
 * 문제: 백준 알고리즘 11000번_강의실 배정
 * 설명: 그리디, 우선순위 큐 사용
 * 		https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-11000-%EA%B0%95%EC%9D%98%EC%8B%A4-%EB%B0%B0%EC%A0%95-Java
 */

public class greedy_11000 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		
		//1. Input Data를 2차원 배열로 받는다.
		int[][] classes = new int[n][2];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			classes[i][0] = stoi(st.nextToken());
			classes[i][1] = stoi(st.nextToken());
		}
		
		//2. 입력 데이터를 오름차순으로 정렬해준다. (시작 시간이 같다면, 끝나는 시간을 오름차순으로 정렬)
		Arrays.sort(classes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
			}
			
		});
		
		//3. Priority Queue(우선순위 큐)를 만들어주고, (정렬된)배열의 첫 번째 end값을 큐에 넣는다.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(classes[0][1]);
		
		//4. 배열을 두 번째 값부터 순회하면서
		for(int i=1; i<n; i++) {
			//start가 PriorityQueue의 peek()보다 작거나 같다면, pq에서 하나 뺀다.
			if(pq.peek() <= classes[i][0]) pq.poll();
			
			//4-1. 순회하면서, 현재 end값을 새로 pq에 넣어준다.
			pq.add(classes[i][1]);
		}
		
		//5. pq에 남아있는 데이터의 갯수가 필요한 강의실의 갯수이다.
		System.out.println(pq.size());
		br.close();
	}
	
	public static int stoi(String str) {return Integer.parseInt(str);}

}