package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class practice {
	static Scanner sc = new Scanner(System.in);
	static int iN; //정점 개수
	static int iM; //간선 개수
	static int iV; //시작 번호
	static ArrayList<Integer>[] list;
	static boolean[] check;
	
	public static void main(String[] args) {
		int iN = sc.nextInt();
		int iM = sc.nextInt();
		int iV = sc.nextInt();
		
		list = new ArrayList[iN+1];
		for(int i=1; i<=iN; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		int iA;
		int iB;
		for(int i=0; i<iM; i++) {
			iA = sc.nextInt();
			iB = sc.nextInt();
			
			list[iA].add(iB);
			list[iB].add(iA);
		}
		
		for(int i=1; i<=iN; i++) {
			Collections.sort(list[i]);
		}
		
		check = new boolean[iN+1];
	}
	
	private static void dfs(int x) {
		if( check[x] ) return;
		
		check[x] = true;
		System.out.print(x + " ");
		
		for(int i : list[x]) {
			if(!check[i]) {
				dfs(i);
			}
		}
	}
	
	private static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x);
		check[x] = true;
		
		while(!queue.isEmpty()) {
			int y = queue.poll();
			System.out.print(y + " ");
			
			for(int z : list[x]) {
				if(!check[z]) {
					check[z] = true;
					queue.add(z);
				}
			}
		}
	}

}
