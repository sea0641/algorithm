package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * ��¥: 2021/08/04
 * ����: ������ String 01-10 ���� ª�� ���ڰŸ�
 */

public class String_01_10 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		char t = st.nextToken().charAt(0);
		
		int[] arrMinDis = new int[s.length()];
		Arrays.fill(arrMinDis, s.length());
		
		//���� -> ������ �Ÿ� Ž��
		int dis = s.length(); //Ÿ�ٹ��ڸ� ������ 0, �ƴϸ� +1
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == t) {
				dis = 0;
			} else {
				dis++;
			}
			arrMinDis[i] = Math.min(arrMinDis[i], dis);
		}
		
		//������ -> ���� �Ÿ� Ž��
		dis = s.length(); //Ÿ�ٹ��ڸ� ������ 0, �ƴϸ� +1
		for(int i=s.length()-1; i>=0; i--) {
			if(s.charAt(i) == t) {
				dis = 0;
			} else {
				dis++;
			}
			arrMinDis[i] = Math.min(arrMinDis[i], dis);
		}
		
		for(int i : arrMinDis) {
			System.out.print(i + " ");
		}
	}

}
