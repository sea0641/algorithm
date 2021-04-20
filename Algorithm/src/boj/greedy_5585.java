package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜: 2021/04/19
 * 문제: 백준 알고리즘 5585번_거스름돈
 * 설명: 그리디
 */

public class greedy_5585 {
	static int change; //거스름돈
	static BufferedReader br;
	static int[] moneys = {500, 100, 50, 10, 5, 1};
	static int n = 0; //잔돈의 개수
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int price = Integer.parseInt(br.readLine());
		change = 1000 - price;
		
		for(int m : moneys) {
			if(change >= m) {
				n = n + change / m;
				change = change % m ;
			} else if (change == 0) {
				break;
			}
		}
		
		System.out.println(n);
		
	}

}
