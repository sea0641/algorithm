package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/05/02
 * 문제: 백준 알고리즘 1202번_보석도둑
 * 설명: 
 */

public class greedy_1202 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = stoi(st.nextToken()); //보석의 개수
		int k = stoi(st.nextToken()); //가방의개수
		
		Jewelry[] arrJew = new Jewelry[n]; //보석(무게,가격) 배열
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arrJew[i] = new Jewelry(stoi(st.nextToken()), stoi(st.nextToken()));
		}
		
		int[] arrBag = new int[k]; //각 가방에 담을 수 있는 보석 최대 무게
		for(int i=0; i<k; i++) {
			arrBag[i] = stoi(br.readLine());
		}
		
		Arrays.sort(arrJew); // arrJew 무게 오름차순 정렬
		Arrays.sort(arrBag); // arrBag 무게 오름차순 정렬
		
		//우선순위 큐 가격 내림차순 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
		long totPrice = 0;
		int idx = 0;
		for(int i=0; i<k; i++) {
			while(idx < n && arrJew[idx].weight <= arrBag[i]) {
				pq.add(arrJew[idx].price);
				idx++;
			}
			
			if(!pq.isEmpty()) totPrice += pq.poll();
		}
		
		System.out.println(totPrice);
	
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
	
	static class Jewelry implements Comparable<Jewelry> {
		int weight; //보석의 무게
		int price; //보석의 가격
		
		private Jewelry(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
		
		@Override
		public int compareTo(Jewelry j) {
			return this.weight - j.weight;
		}
	}

}
