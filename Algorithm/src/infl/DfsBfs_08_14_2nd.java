package infl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * ��¥: 2021/11/07
 * ����: ������ DFSBFS 08-14 ���� ��� �Ÿ�(DFSȰ��)
 */

/*
 * �������� ����Ʈ�� ��Ƴ��� �������� M�� �̾��� ���� ���Ѵ�.
 * �� ���� �ش� ������ ������ ���� ��� �Ÿ��� ���ϰ� �� ���յ� �� �ּҰ� �Ǵ� ���� ���Ѵ�.
 */
public class DfsBfs_08_14_2nd {
	static int N, M;
	static int[][] map;
	static List<Point> listPz, listHm;
	static int[] combi;
	static int anaswer = Integer.MAX_VALUE;
	
	static void DFS(int L, int s) {
		//������ ���� �ϼ��Ǿ��� �� �ּ� ���� ��� �Ÿ� ���Ѵ�.
		if(L == M) {
			int cityPzDelDis = 0;
			
			for(Point hm : listHm) {
				//�� ������ �ּҰ� �Ǵ� ���ڹ�ްŸ��� ���Ѵ�.
				int hmPzDelDis = Integer.MAX_VALUE;
				for(int i : combi) {
					hmPzDelDis = Math.min(hmPzDelDis, Math.abs(listPz.get(i).y - hm.y) + Math.abs(listPz.get(i).x - hm.x));
				}
				//������ ���ڹ�� �Ÿ� ���ϱ�
				cityPzDelDis += hmPzDelDis;
			}

			//�ش� ������ ������ ���ڹ�� �Ÿ� �ּڰ� ���ϱ�
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
		N = sc.nextInt(); //������ ���� �ʺ�
		M = sc.nextInt(); //�츱 ������ ��
		map = new int[N][N];
		combi = new int[M]; //�츱 ������ �������� list�� index�� ��´�
		
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
