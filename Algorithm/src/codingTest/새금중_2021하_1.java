package codingTest;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 총 4문제 2시간
 * 1. 알파벳 정렬 순서가 qwertyuiopasdfghjklzxcvbnm 이와 같을 때
 * [c, cb, qeg, qea, h, r] 배열을 위 정렬 순서대로 나열하시오.
 */
public class 새금중_2021하_1 {

	public static void main(String[] args) {
		String[] arr = {"c", "cb", "qeg", "qea", "h", "r"};
		String sort = "qwertyuiopasdfghjklzxcvbnm";
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int minLen = Math.min(o1.length(), o2.length());
				for(int i=0; i<minLen; i++) {
					int od1 = sort.indexOf(o1.charAt(i));
					int od2 = sort.indexOf(o2.charAt(i));
					if(od1 != od2) {
						return od1 - od2;
					}
				}
				return o1.length() - o2.length();
			}
		});
		
		System.out.println(Arrays.toString(arr));
	}

}
