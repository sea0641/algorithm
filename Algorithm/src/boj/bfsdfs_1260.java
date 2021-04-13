package boj;

/*
 * ��¥: 2021/04/11
 * ����: ���� �˰��� 1260��_DFS�� BFS
 * ����: DFS�� ���, BFS�� Queue ���
 * 		+ https://developer-mac.tistory.com/63
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class bfsdfs_1260 {
	static int iN; //��������
	static int iM; //��������
	static int iV; //���۹�ȣ
	static ArrayList<Integer>[] list; //�� �������� ������ ����Ǿ��ִ� ������ȣ�� ���� �迭����Ʈ
	static boolean[] check; //���� �湮����
	
	public static void main(String[] args) throws IOException {
//		System.out.println("��������, ��������, ���۹�ȣ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			iN = Integer.parseInt(st.nextToken());
			iM = Integer.parseInt(st.nextToken());
			iV = Integer.parseInt(st.nextToken());
		}
			
		list = new ArrayList[iN+1];
		for ( int i=0; i<iN+1; i++ ) {
			list[i] = new ArrayList<Integer>();
		}
		
		//������ ����Ǿ��ִ� ������ �Է¹����鼭 �迭����Ʈ�� �߰��Ѵ�.
		for ( int i=0; i<iM; i++ ) {
			st = new StringTokenizer(br.readLine());
			int iA = Integer.parseInt(st.nextToken());
			int iB = Integer.parseInt(st.nextToken());
			
			list[iA].add(iB);
			list[iB].add(iA);
		}
		
		//���� ��ȣ���� �湮�ϱ� ���� ����
		for ( int i=1; i<iN+1; i++ ) {
			Collections.sort(list[i]);
		}
		
		check = new boolean[iN+1];
		dfs(iV);
		System.out.println();
		
		check = new boolean[iN + 1];
        bfs(iV);
        System.out.println();
		
		br.close();
		}
		
	private static void dfs(int x) {
        if (check[x]) {
            return;
        }

        check[x] = true;
        System.out.print(x + " ");
        
        for (int y : list[x]) {
        	if(!check[y])
        		dfs(y);
        }

    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int y : list[x]) {
                if (!check[y]) {
                    check[y] = true;
                    queue.add(y);
                }
            }
        }
    }
}
