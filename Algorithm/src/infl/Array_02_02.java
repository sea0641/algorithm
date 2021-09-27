package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 날짜: 2021/08/05
 * 문제: 인프런 Array 02-02 보이는 학생
 */

public class Array_02_02 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] student = new int[n];
		for(int i=0; i<n; i++) {
			student[i] = stoi(st.nextToken());
		}
		
		int cnt = 1;
		int max = student[0];
		for(int i=1; i<n; i++) {
			if(student[i] > max) {
				cnt++;
				max = student[i];
			}
		}
		
		System.out.println(cnt);
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
