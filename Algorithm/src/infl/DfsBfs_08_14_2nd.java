package infl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜: 2021/11/07
 * 문제: 인프런 DFSBFS 08-14 피자 배달 거리(DFS활용)
 */

/*
 * 피자집들 리스트에 모아놓고 조합으로 M개 뽑았을 때를 구한다.
 * 그 다음 해당 조합의 도시의 피자 배달 거리를 구하고 각 조합들 중 최소가 되는 것을 구한다.
 */
public class DfsBfs_08_14_2nd {
	static int N, M;
	static int[][] map;
	static List<Point> listPz, listHm;
	static int[] combi;
	static int anaswer = Integer.MAX_VALUE;
	
	static void DFS(int L, int s) {
		//피자집 조합 완성되었을 때 최소 피자 배달 거리 구한다.
		if(L == M) {
			int cityPzDelDis = 0;
			
			for(Point hm : listHm) {
				//각 집에서 최소가 되는 피자배달거리를 구한다.
				int hmPzDelDis = Integer.MAX_VALUE;
				for(int i : combi) {
					hmPzDelDis = Math.min(hmPzDelDis, Math.abs(listPz.get(i).y - hm.y) + Math.abs(listPz.get(i).x - hm.x));
				}
				//도시의 피자배달 거리 구하기
				cityPzDelDis += hmPzDelDis;
			}

			//해당 조합의 도시의 피자배달 거리 최솟값 구하기
			anaswer = Math.min(anaswer, cityPzDelDis);
		} else {
			for(int i=s; i<listPz.size(); i++) {
				combi[L] = i;
				DFS(L+1, i+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //도시의 지도 너비
		M = sc.nextInt(); //살릴 피자집 수
		map = new int[N][N];
		combi = new int[M]; //살릴 피자집 조합으로 list의 index를 담는다
		
		listPz = new ArrayList<Point>();
		listHm = new ArrayList<Point>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) listHm.add(new Point(i, j));
				else if (map[i][j] == 2) listPz.add(new Point(i, j));
			}
		}
		
		DFS(0, 0);
		
		System.out.println(anaswer);
	}

}
