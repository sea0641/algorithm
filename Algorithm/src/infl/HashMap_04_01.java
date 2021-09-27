package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * ��¥: 2021/08/08
 * ����: ������ HashMap 04-01 �б� ȸ��(�ؽ�)
 */

public class HashMap_04_01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		String str = br.readLine();
		for(char c : str.toCharArray()) {
			hm.put(c, hm.getOrDefault(c, 0) + 1);
		}
		
		Iterator<Character> it = hm.keySet().iterator();
		int answer = 0;
		Character ch = null;
		while(it.hasNext()) {
			Character c = it.next();
			if ( answer < hm.get(c) ) {
				answer = hm.get(c);
				ch = c;
			}
		}
		
		/*
		1. iterator ���� keySet() For ���
		for(char c : hm.keySet()) {
			if ( answer < hm.get(c) ) {
				answer = hm.get(c);
				ch = c;
			}
		}
		
		2. map.entrySet() ��� 
		for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
			int i = entry.getValue();
			if( answer < i ) {
				answer = i;
				ch = entry.getKey();
			}
		}
		*/
		
		System.out.println(ch);
	}

}
