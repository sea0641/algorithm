package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/09/11
 * ����: ������ �׸��� 09-06 ģ���ΰ�(Disjoint-Set: Union&Find)
 */

public class Greedy_09_06 {
	static int[] unf;
	
	public static int Find(int v) {
		if(v == unf[v]) return v;
		else return unf[v] = Find(unf[v]); //��ξ���
	}
	
	public static void Union(int a, int b) {
		int fa = Find(a);
		int fb = Find(b);
		if(fa != fb) unf[fa] = fb;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		unf = new int[n+1];
		for(int i=1; i<=n; i++) unf[i] = i;
		for(int i=1; i<=m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			Union(a, b);
		}
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int fa = Find(a);
		int fb = Find(b);
		if(fa == fb) System.out.println("YES");
		else System.out.println("NO");
	}

}
