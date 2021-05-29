package boj;

import java.util.Scanner;

public class dp_1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[1000001];
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		
		for(int i=4; i<=n; i++) {
			//방안 1. 1을 뺀다.
			arr[i] = arr[i-1] + 1;
			//방안 2. 3으로 나눈다.
			if ( i%3 == 0 ) {
				arr[i] = Math.min(arr[i], arr[i/3] + 1);
			}
			//방안 3. 2로 나눈다.
			if ( i%2 == 0 ) {
				arr[i] = Math.min(arr[i], arr[i/2] + 1);
			}
			
		}
		
		System.out.println(arr[n]);
	}

}
