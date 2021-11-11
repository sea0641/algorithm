package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * ��¥: 2021/11/08
 * ����: ������ �׸��� 09-02 ȸ�ǽ� ����
 */

/*
 * ������ �ð�, ���۽ð� �������� ����
 * ȸ�� �� ���� ����: �ռ� ȸ�� ������ �ð� <= ���� ȸ�� ���۽ð�
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

public class Greedy_09_02_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Conf> list = new ArrayList<Conf>();
		for(int i=0; i<n; i++) {
			int sT = sc.nextInt();
			int eT = sc.nextInt();
			list.add(new Conf(sT, eT));
		}
		
		Collections.sort(list);
		
		int answer = 0;
		int eT = 0;
		for(Conf c : list) {
			//ȸ�� �� ����
			if(c.sT >= eT) {
				answer++;
				//�ش� ȸ�� ������ �ð� ����
				eT = c.eT;
			}
		}
		
		System.out.println(answer);
	}

}
