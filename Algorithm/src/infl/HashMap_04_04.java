package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 날짜: 2021/08/08
 * 문제: 인프런 HashMap 04-04 모든 아나그램 찾기
 */

public class HashMap_04_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String t = sc.nextLine();
		
		char[] ch = t.toCharArray();
		Arrays.sort(ch);
		t = new String(ch);
		
		int answer = 0;
		for(int i=0; i<=s.length()-t.length(); i++) {
			String tmp = s.substring(i, i + t.length());
			ch = tmp.toCharArray();
			Arrays.sort(ch);
			if(t.equals(new String(ch))) answer++;
		}
		
		/*
		1. HashMap, substring() 사용 
		Map<Character, Integer> hm1 = new HashMap<Character, Integer>();
		for(Character c : t.toCharArray()) {
			hm1.put(c, hm1.getOrDefault(c, 0) + 1);
		}
		Map<Character, Integer> hm2;
		int answer = 0;
		for(int i=0; i<=s.length()-t.length(); i++) {
			String tmp = s.substring(i, i + t.length());
			hm2 = new HashMap<Character, Integer>();
			for(char c : tmp.toCharArray()) {
				hm2.put(c, hm2.getOrDefault(c, 0) + 1);
			}
			
			if(hm1.equals(hm2)) answer++;
		}
		
		2. HashMap, two pointers 사용
		Map<Character, Integer> hm1 = new HashMap<Character, Integer>();
		for(Character c : t.toCharArray()) {
			hm1.put(c, hm1.getOrDefault(c, 0) + 1);
		}
		
		Map<Character, Integer> hm2 = new HashMap<Character, Integer>();
		for(int i=0; i<t.length()-1; i++) {
			hm2.put(s.charAt(i), hm2.getOrDefault(s.charAt(i), 0) + 1);
		}
		int lt = 0;
		for(int rt=t.length()-1; rt<s.length(); rt++) {
			hm2.put(s.charAt(rt), hm2.getOrDefault(s.charAt(rt), 0) + 1);
			if(hm1.equals(hm2)) answer++;
			hm2.put(s.charAt(lt), hm2.get(s.charAt(lt)) -1);
			if(hm2.get(s.charAt(lt)) == 0) hm2.remove(s.charAt(lt));
			lt++;
		}
		*/
		
		System.out.println(answer);
		
		
	}

}
