package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * ��¥: 2021/05/02
 * ����: ���� �˰��� 1202��_��������
 * ����: 
 */

public class greedy_1202 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = stoi(st.nextToken()); //������ ����
		int k = stoi(st.nextToken()); //�����ǰ���
		
		Jewelry[] arrJew = new Jewelry[n]; //����(����,����) �迭
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arrJew[i] = new Jewelry(stoi(st.nextToken()), stoi(st.nextToken()));
		}
		
		int[] arrBag = new int[k]; //�� ���濡 ���� �� �ִ� ���� �ִ� ����
		for(int i=0; i<k; i++) {
			arrBag[i] = stoi(br.readLine());
		}
		
		Arrays.sort(arrJew); // arrJew ���� �������� ����
		Arrays.sort(arrBag); // arrBag ���� �������� ����
		
		//�켱���� ť ���� �������� ����
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
		int weight; //������ ����
		int price; //������ ����
		
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
