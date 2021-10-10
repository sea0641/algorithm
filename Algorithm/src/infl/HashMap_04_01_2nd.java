package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * ��¥: 2021/10/10
 * ����: ������ HashMap 04-01 �б� ȸ��(�ؽ�)
 */

public class HashMap_04_01_2nd {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//�� �л� ��
		String str = br.readLine(); //��ǥ�ĺ�
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(Character c : str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int max = 0;
		Character answer = null;
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() > max) {
				max = entry.getValue();
				answer = entry.getKey();
			}
		}
		
		System.out.println(answer);
	}

}
