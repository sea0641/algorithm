package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ��¥: 2021/05/06
 * ����: ���� �˰��� 15651��_N�� M(3)
 * ����: �ߺ�����, DFS ���
 * https://st-lab.tistory.com/116
 */

public class nPr_15651 {
	static int n;
	static int m;
	static int[] arrNum;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arrNum = new int[m]; //���̰� m�̴�.
		
		dfs(0);
		System.out.println(sb);
	}
	
	static void dfs(int depth) {
		//���̰� M�̶� �������� ��� �� return
		if(depth == m) {
			for(int i=0; i<m; i++) {
				sb.append(arrNum[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=n; i++) {
			arrNum[depth] = i;
			dfs(depth+1);
		}
	}

}
