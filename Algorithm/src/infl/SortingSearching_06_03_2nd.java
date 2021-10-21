package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/10/21
 * 문제: 인프런 SortingSearching 06-03 삽입 정렬
 */

public class SortingSearching_06_03_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		/*
		 * 1. 두번째 숫자부터 앞의 숫자들의 적절한 순서에 삽입한다.
		 * 2. 바로 이전숫자부터 첫번째 숫자까지 확인한다. 이때 바로 앞의 숫자들은 정렬되어 있는 상태이다.
		 * 3. 삽입할 숫자를 기억해놓고 적절한 위치까지 숫자를 뒤로 미룬다.
		 * 4. 삽입할 자리에 기억해논 숫자를 입력해 정렬된 상태를 만든다.
		 */
		for(int i=1; i<n; i++) {
			int tmp = arr[i];
			
			int j;
			for(j=i-1; j>=0; j--) {
				if(tmp < arr[j]) arr[j+1] = arr[j]; //뒤로 미루기
				else break; //이미 그 앞은 정렬되어 있으므로 더 볼필요 X
			}
			
			//삽입할 자리에 삽입
			arr[j+1] = tmp;
		}
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

}
