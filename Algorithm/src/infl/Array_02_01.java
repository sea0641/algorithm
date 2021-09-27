package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/08/04
 * 문제: 인프런 Array 02-01 큰 수 출력하기
 */

public class Array_02_01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int num = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a > num) System.out.print(a + " ");
			num = a;
		}
		
		/*
		 * Array 사용
		 * String[] arr = str.split(" ");
		 * System.out.print(arr[0]);
		 * for(int i=1; i<n; i++) {
		 * 	if(Integer.parseInt(arr[i]) > Integer.parseInt(arr[i-1])) System.out.print(" " + arr[i]);
		 * }
		 */
	}

}
