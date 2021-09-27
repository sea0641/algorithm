package infl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * ��¥: 2021/08/06
 * ����: ������ TwoPointers 03-02 ������� ���ϱ�
 */

public class TwoPointers_03_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for(int i=0; i<n; i++) {
			arr1[i] = sc.nextInt();
		}
		Arrays.sort(arr1);
		
		int m = sc.nextInt();
		int[] arr2 = new int[m];
		for(int i=0; i<m; i++) {
			arr2[i] = sc.nextInt();
		}
		Arrays.sort(arr2);
		
		List<Integer> answer = new ArrayList<Integer>();
		/* �ð��ʰ�
		for(int i : arr1) {
//			���ڴ� �ȵȴ�... Arrays.asList�ϸ� ���ϰ��� List<int[]>�� ����...
//			System.out.println(Arrays.asList(arr2).contains(i));
			if(Arrays.stream(arr2).anyMatch(j -> j == i)) answer.add(i);
		}
		*/
		int p1 = 0, p2 = 0;
		while(p1<n && p2<m) {
			if(arr1[p1] == arr2[p2]) {
				answer.add(arr1[p1++]);
				p2++;
			}
			else if(arr1[p1] < arr2[p2]) p1++;
			else p2++;
		}

		for(int i : answer) {
			System.out.print(i + " ");
		}
	}

}
