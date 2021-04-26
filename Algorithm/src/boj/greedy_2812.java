package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * ��¥: 2021/04/25
 * ����: ���� �˰��� 2812��_ũ�� �����
 * ����: �׸���, Deque ���
 * 		https://steady-coding.tistory.com/54
 */

public class greedy_2812 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = stoi(st.nextToken()); //���� ����
		int k = stoi(st.nextToken()); //����� ����
		
		String inputStr = br.readLine();
		char[] inputChar = inputStr.toCharArray();
		Deque<Character> dq = new ArrayDeque<>();
		
		for(int i=0; i<n; i++) {
			//��ũ�� �� ���� ���� inputChar[i]���� ������ �����Ѵ�.
			while(k > 0 && !dq.isEmpty() && dq.getLast() < inputChar[i]) {
				dq.removeLast();
				k--;
			}
			dq.add(inputChar[i]);
		}
		
		StringBuffer sb = new StringBuffer();
		//k�� 0�� �Ǳ� ���� ���� ��찡 ���� �� ������ dq.size() - k��ŭ ����Ѵ�.
		while(dq.size() > k)
			sb.append(dq.removeFirst());
		
		System.out.println(sb);
		br.close();
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
