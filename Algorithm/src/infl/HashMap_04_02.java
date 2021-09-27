package infl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * ��¥: 2021/08/08
 * ����: ������ HashMap 04-02 �Ƴ��׷�(�ؽ�)
 */

public class HashMap_04_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		Map<Character, Integer> map2 = new HashMap<Character, Integer>();
		
		for(Character c : str1.toCharArray()) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}
		for(Character c : str2.toCharArray()) {
			map2.put(c, map2.getOrDefault(c, 0) + 1);
		}
		
		System.out.println(map1.equals(map2) == true ? "YES" : "NO");
		
		/* ���� ��� �� ��
		char[] arr1 = str1.toCharArray();
		Arrays.sort(arr1);
		char[] arr2 = str2.toCharArray();
		Arrays.sort(arr2);
		
		System.out.println(new String(arr1).equals(new String(arr2)) ? "YES" : "NO");
		*/
	}

}
