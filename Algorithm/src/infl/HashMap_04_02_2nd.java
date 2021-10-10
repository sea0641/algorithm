package infl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 날짜: 2021/10/10
 * 문제: 인프런 HashMap 04-02 아나그램(해쉬)
 */


public class HashMap_04_02_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		Map<Character, Integer> map2 = new HashMap<Character, Integer>();
		
		for(char c : str1.toCharArray()) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}
		for(char c : str2.toCharArray()) {
			map2.put(c, map2.getOrDefault(c, 0) + 1);
		}
		
		System.out.println(map1.equals(map2) ? "YES" : "NO");
	}

}
