package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * ��¥: 2021/08/23
 * ����: ������ �׸��� 09-02 ȸ�ǽ� ����
 */

class Conf implements Comparable<Conf>{
	int sT, eT;
	Conf(int sT, int eT) {
		this.sT = sT;
		this.eT = eT;
	}
	
	@Override
	public int compareTo(Conf o) {
		if(this.eT != o.eT) return this.eT - o.eT; //������ �ð� ��������
		else return this.sT - o.sT; //������ �ð��� ������ ���۽ð� ��������
	}
}
public class Greedy_09_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Conf> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int sT = sc.nextInt();
			int eT = sc.nextInt();
			arr.add(new Conf(sT, eT));
		}
		Collections.sort(arr);
		
		int answer = 0;
		int end = 0;
		for(Conf c : arr) {
			if(end <= c.sT) {
				answer++;
				end = c.eT;
			}
		}
		
		System.out.println(answer);
	}

}
