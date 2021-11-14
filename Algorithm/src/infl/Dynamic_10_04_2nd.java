package infl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜: 2021/11/11
 * 문제: 인프런 동적계획법 10-04 가장 높은 탑 쌓기
 */

class Brick implements Comparable<Brick>{
	int area; //밑면의 넓이
	int height; //높이
	int weight; //무게
	
	Brick(int area, int height, int weight) {
		this.area = area;
		this.height = height;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Brick o) {
		return o.area - this.area; //밑면 넓이 내립차순
	}
}
public class Dynamic_10_04_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Brick> list = new ArrayList<Brick>();
		for(int i=0; i<n; i++) {
			int area = sc.nextInt();
			int height = sc.nextInt();
			int weight = sc.nextInt();
			
			list.add(new Brick(area, height, weight));
		}
		
		Collections.sort(list);

		int[] dp = new int[n];
		int answer = 0;
		for(int i=0; i<n; i++) {
			dp[i] = list.get(i).height;
			for(int j=i-1; j>=0; j--) {
				//위에 벽돌을 올릴 수 있다면
				if(list.get(i).weight < list.get(j).weight) {
					dp[i] = Math.max(dp[i], dp[j] + list.get(i).height);
				}
			}
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
//		System.out.println(Arrays.stream(dp).max().getAsInt()); 시간 더 오래걸림
		
	}

}
