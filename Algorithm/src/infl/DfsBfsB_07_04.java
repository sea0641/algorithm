package infl;

/*
 * 날짜: 2021/08/23
 * 문제: 인프런 DFSBFS기초 07-04 피보나치 재귀(메모이제이션)
 */

public class DfsBfsB_07_04 {
	static int[] fibo; //메모이제이션 배열
	
	public int DFS(int n) {
		if(fibo[n] > 0) { //계산한적 있는 것이면 바로 return
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
