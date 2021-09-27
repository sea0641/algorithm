package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class queue_2164 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) {
			que.add(i);
		}
		
		while(que.size() > 1) {
			que.poll();
			if(que.size() == 1) {
				break;
			}
			que.add(que.poll());
		}
		
		System.out.println(que.peek());
	}


}
