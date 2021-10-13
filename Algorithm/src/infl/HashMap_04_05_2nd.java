package infl;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * ��¥: 2021/10/11
 * ����: ������ HashMap 04-05 K��° ū ��
 */

public class HashMap_04_05_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //ī���� ����
		int k = sc.nextInt(); //���� ����
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		Set<Integer> set = new TreeSet<>(Collections.reverseOrder()); //k�� ī���� ��, ��������
		for(int i=0; i<n-2; i++) {
			for(int j=i+1; j<n-1; j++) {
				for(int m=j+1; m<n; m++) {
					set.add(arr[i] + arr[j] + arr[m]);
				}
			}
		}
		
		int cnt = 0;
		for(int i : set) {
			cnt++;
			if(cnt == k) {
				System.out.println(i);
				break;
			}
		}
		
	}

}
