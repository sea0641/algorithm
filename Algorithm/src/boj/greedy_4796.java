package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ��¥: 2021/04/20
 * ����: ���� �˰��� 4796��_ķ��
 * ����: �׸���
 */

public class greedy_4796 {
	static int v; //�ް��ϼ�
	static int p; //�����ϴ� �ϼ�
	static int l; //��� ���� �ϼ�
	static int c; //ķ�� ��� �ϼ�
	static int cnt = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		while(true) {
			c = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			if( l == 0 && p == 0 && v == 0 ) break;
			
			//�ް��ϼ� % �����ϴ��ϼ� > ��밡���ϼ� �� ��� ����!
			c = c + l*(v/p) + (v%p > l ? l : v%p);
			sb.append("Case ").append(cnt++).append(": ").append(c).append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
