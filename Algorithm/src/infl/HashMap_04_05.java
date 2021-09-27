package infl;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * ��¥: 2021/08/08
 * ����: ������ HashMap 04-05 K��° ū ��
 */

public class HashMap_04_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Integer[] arr = new Integer[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//3������ �� treeSet�� �ֱ�
		TreeSet<Integer> ts = new TreeSet<>();
		for(int i=0; i<n-2; i++) {
			for(int j=i+1; j<n-1; j++) {
				for(int m=j+1; m<n; m++) {
					ts.add(arr[i] + arr[j] + arr[m]);
				}
			}
		}
		
		//last()�� �̿��� k��°�� ū ���� ã��
		int answer = 0;
		for(int i=0; i<k; i++) {
			if(!ts.isEmpty()) {
				answer = ts.last(); //�������� ���� ������ ��: �ִ밪
				ts.remove(answer);
			} else {
				answer = -1;
				break;
			}
		}
		
		/* TreeSet�� �������� ���� �ֱ�_last()���� �ð� ���ɸ���.
		TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
		for(int i=0; i<n-2; i++) {
			for(int j=i+1; j<n-1; j++) {
				for(int m=j+1; m<n; m++) {
					ts.add(arr[i] + arr[j] + arr[m]);
				}
			}
		}
		
		int answer = -1;
		int cnt=0;
		for(int x : ts) {
			cnt++;
			if(cnt == k) {
				answer = x;
				break;
			}
		}
		*/
		
		System.out.println(answer);
		
	}
	
}
