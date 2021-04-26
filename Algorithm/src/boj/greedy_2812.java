package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/04/25
 * 문제: 백준 알고리즘 2812번_크게 만들기
 * 설명: 그리디, Deque 사용
 * 		https://steady-coding.tistory.com/54
 */

public class greedy_2812 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = stoi(st.nextToken()); //숫자 개수
		int k = stoi(st.nextToken()); //지우는 개수
		
		String inputStr = br.readLine();
		char[] inputChar = inputStr.toCharArray();
		Deque<Character> dq = new ArrayDeque<>();
		
		for(int i=0; i<n; i++) {
			//데크의 맨 뒤의 값이 inputChar[i]보다 작으면 삭제한다.
			while(k > 0 && !dq.isEmpty() && dq.getLast() < inputChar[i]) {
				dq.removeLast();
				k--;
			}
			dq.add(inputChar[i]);
		}
		
		StringBuffer sb = new StringBuffer();
		//k가 0이 되기 전에 끝난 경우가 있을 수 있으니 dq.size() - k만큼 출력한다.
		while(dq.size() > k)
			sb.append(dq.removeFirst());
		
		System.out.println(sb);
		br.close();
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
