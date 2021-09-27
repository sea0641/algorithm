package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜: 2021/09/17
 * 문제: 인프런 동적계획법 10-04 가장 높은 탑 쌓기
 */

public class Dynamic_10_04 {
	static int[] dy;
	
	static class Brick implements Comparable<Brick>{
		int area, height, weight;
		Brick(int area, int height, int weight) {
			this.area = area;
			this.height = height;
			this.weight = weight;
		}
		@Override
		public int compareTo(Brick o) {
			return o.area - this.area;
		}
		
	}
	
	public static int solution(ArrayList<Brick> list) {
		Collections.sort(list);
		dy[0] = list.get(0).height;
		int answer = 0;
		for(int i=1; i<list.size(); i++) {
			int maxH = 0;
			for(int j=i-1; j>=0; j--) {
				if(list.get(j).weight > list.get(i).weight && dy[j] > maxH) maxH = dy[j];
			}

			dy[i] = maxH + list.get(i).height;
			answer = Math.max(answer, dy[i]);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //벽돌의 수
		ArrayList<Brick> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int area = sc.nextInt();
			int height = sc.nextInt();
			int weight = sc.nextInt();
			list.add(new Brick(area, height, weight));
		}
		dy = new int[n];

		System.out.print(solution(list));
	}

}
