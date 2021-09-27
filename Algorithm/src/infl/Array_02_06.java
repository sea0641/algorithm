package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/08/05
 * 문제: 인프런 Array 02-06 뒤집은 소수
 */

public class Array_02_06 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			String str = new StringBuilder(st.nextToken()).reverse().toString();
			/*
			 * 숫자 뒤집는 법 reverse 사용 X
			 * int tmp = stoi(st.nextToken());
			 * int res = 0;
			 * while(tmp > 0) {
			 * 	int t = tmp % 10;
			 * 	res = res*10 + t;
			 * 	tmp = tmp/10;
			 * }
			 */
			
			if(isPrime(stoi(str))) System.out.print(stoi(str) + " "); 
		}
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
	
	public static boolean isPrime(int n) {
		boolean b = true;
		
		if(n == 1) {
			b = false;
			return b;
		}
		
		for(int i=2; i<n; i++) {
			if(n % i == 0) {
				b = false;
				break;
			}
		}
		
		return b;
	}

}
