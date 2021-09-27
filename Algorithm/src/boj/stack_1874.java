package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class stack_1874 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = stoi(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int k;
		int top = 1;
		while(n-- > 0){
			k = stoi(br.readLine());

			if(stack.isEmpty()) {
				stack.push(top++);
				sb.append("+\n");
			}

			if(k == stack.peek()) {
				stack.pop();
				sb.append("-\n");
			} else if (k > stack.peek()) {
				for(int i=top; i<=k; i++) {
					stack.push(i);
					sb.append("+\n");
				}
				top = k+1;
				stack.pop();
				sb.append("-\n");
			} else {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println(sb);
	}
	
	static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
