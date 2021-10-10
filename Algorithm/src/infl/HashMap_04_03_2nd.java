package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HashMap_04_03_2nd {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = stoi(st.nextToken()); //n일동안의 매출
		int k = stoi(st.nextToken()); //k구간

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = stoi(st.nextToken());
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int lt = 0;
		for(int i=0; i<n; i++) {
			if(i<k-1) map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			else {
				 map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
				
				 System.out.print(map.size() + " ");

				 if(map.get(arr[lt]) == 1) map.remove(arr[lt]);
				 else map.put(arr[lt], map.get(arr[lt])-1);
				 lt++;
			}
		}
		
		/* two pointers 사용
		for(int i=0; i<k-1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		int lt = 0;
		for(int rt=k-1; rt<n; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
			System.out.print(map.size() + " ");
			map.put(arr[lt], map.get(arr[lt])-1);
			if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
			lt++;
		}
		*/
	}
	
	public static Integer stoi(String str) {
		return Integer.parseInt(str);
	}

}
