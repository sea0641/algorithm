package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * ��¥: 2021/09/17
 * ����: ������ �׸��� 09-07 ��������(�ּҽ��д�Ʈ��: ũ�罺Į, Disjoint-Set: Union&Find Ȱ��)
 */

public class Greedy_09_07 {
	static int[] unf; //union&find �Ҽ� ���� �迭
	
	static class Edge implements Comparable<Edge> {
		public int v1, v2, cost;
		
		Edge(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge ob) {
			return this.cost - ob.cost;
		}
	}
	
	//v�� ��� ���� �������� + ��� ����
	public static int Find(int v) {
		if(v == unf[v]) return v;
		else return unf[v] = Find(unf[v]);
	}
	
	//��ģ��.. a�� b ����
	public static void Union(int a, int b) {
		int fa = Find(a); //a�� ���� ����
		int fb = Find(b); //b�� ���� ����
		if(fa != fb) unf[fa] = fb;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		unf = new int[n+1];
		ArrayList<Edge> arr = new ArrayList<>();
		
		//���� �ڱ��ڽ����� �ʱ�ȭ
		for(int i=1; i<=n; i++) unf[i] = i;
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr.add(new Edge(a, b, c));
		}
		
		int answer = 0;
		//��� �������� ����
		Collections.sort(arr);
		
		for(Edge ob : arr) {
			int fv1 = Find(ob.v1);
			int fv2 = Find(ob.v2);
			//���� ������ �ƴҶ���. ���� �����̶�� �̹� Ʈ���� ���Ҷ� �����ϸ� ȸ�ΰ� �ǹ���
			if(fv1 != fv2) {
				answer += ob.cost;
				Union(ob.v1, ob.v2); //�� �������� �����
			}
		}
		
		System.out.println(answer);
	}

}
