package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * 날짜: 2021/10/10
 * 문제: 인프런 HashMap 04-01 학급 회장(해쉬)
 */

public class HashMap_04_01_2nd {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//반 학생 수
		String str = br.readLine(); //투표후보
		
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
