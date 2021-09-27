package infl;

/*
 * ��¥: 2021/08/23
 * ����: ������ DFSBFS���� 07-04 �Ǻ���ġ ���(�޸������̼�)
 */

public class DfsBfsB_07_04 {
	static int[] fibo; //�޸������̼� �迭
	
	public int DFS(int n) {
		if(fibo[n] > 0) { //������� �ִ� ���̸� �ٷ� return
			return fibo[n];
		}
		
		if(n == 1 || n == 2) return fibo[n] = 1;
		else return fibo[n] = DFS(n-2) + DFS(n-1);
	}
	
	public static void main(String[] args) {
		DfsBfsB_07_04 T = new DfsBfsB_07_04();
		int n = 45;
		fibo = new int[n+1];
		T.DFS(n);
		for(int i=1; i<=n; i++)
			System.out.println(fibo[i] + " ");
	}

}
