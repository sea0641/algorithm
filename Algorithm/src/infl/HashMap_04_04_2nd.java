package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HashMap_04_04_2nd {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine(); //전체 문자열
		String T = br.readLine(); //확인할 아나그램 문자
		Map<Character, Integer> mapS = new HashMap<Character, Integer>();
		Map<Character, Integer> mapT = new HashMap<Character, Integer>();
		
		for(char c : T.toCharArray()) {
			mapT.put(c, mapT.getOrDefault(c, 0) + 1);
		}
		
		int lt = 0;
		int answer = 0;
		for(int rt=0; rt<S.length(); rt++) {
			if(rt < T.length()-1) mapS.put(S.charAt(rt), mapS.getOrDefault(S.charAt(rt), 0)+1);
			else {
				 mapS.put(S.charAt(rt), mapS.getOrDefault(S.charAt(rt), 0)+1);
				 
				 if(mapT.equals(mapS)) answer++;
				 
				 mapS.put(S.charAt(lt), mapS.get(S.charAt(lt))-1);
				 if(mapS.get(S.charAt(lt)) == 0) mapS.remove(S.charAt(lt));
				 
				 lt++;
			}
		}
		
		System.out.println(answer);
	}
	

}
