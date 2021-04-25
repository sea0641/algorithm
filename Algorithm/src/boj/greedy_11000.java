package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * ��¥: 2021/04/25
 * ����: ���� �˰��� 11000��_���ǽ� ����
 * ����: �׸���, �켱���� ť ���
 * 		https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-11000-%EA%B0%95%EC%9D%98%EC%8B%A4-%EB%B0%B0%EC%A0%95-Java
 */

public class greedy_11000 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		
		//1. Input Data�� 2���� �迭�� �޴´�.
		int[][] classes = new int[n][2];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			classes[i][0] = stoi(st.nextToken());
			classes[i][1] = stoi(st.nextToken());
		}
		
		//2. �Է� �����͸� ������������ �������ش�. (���� �ð��� ���ٸ�, ������ �ð��� ������������ ����)
		Arrays.sort(classes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
			}
			
		});
		
		//3. Priority Queue(�켱���� ť)�� ������ְ�, (���ĵ�)�迭�� ù ��° end���� ť�� �ִ´�.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(classes[0][1]);
		
		//4. �迭�� �� ��° ������ ��ȸ�ϸ鼭
		for(int i=1; i<n; i++) {
			//start�� PriorityQueue�� peek()���� �۰ų� ���ٸ�, pq���� �ϳ� ����.
			if(pq.peek() <= classes[i][0]) pq.poll();
			
			//4-1. ��ȸ�ϸ鼭, ���� end���� ���� pq�� �־��ش�.
			pq.add(classes[i][1]);
		}
		
		//5. pq�� �����ִ� �������� ������ �ʿ��� ���ǽ��� �����̴�.
		System.out.println(pq.size());
		br.close();
	}
	
	public static int stoi(String str) {return Integer.parseInt(str);}

}