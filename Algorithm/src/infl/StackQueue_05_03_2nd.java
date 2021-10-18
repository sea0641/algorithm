package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class StackQueue_05_03_2nd {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = stoi(br.readLine());
		int[][] arr = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) arr[i][j] = stoi(st.nextToken());
		}
		
		int m = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int answer = 0;
		for(int i=0; i<m; i++) {
			int mov = stoi(st.nextToken());
			for(int j=1; j<arr.length; j++) {
				if(arr[j][mov] == 0) continue;
				
				int prevDoll = 0;
				if(!stack.isEmpty()) prevDoll = stack.peek();
				int doll = arr[j][mov];
	
				if(prevDoll == doll) {
					answer += 2;
					stack.pop();
				} else {
					stack.push(doll);
				}
				
				arr[j][mov] = 0;
				break;
			}
		}
		
		System.out.println(answer);
		
		
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
