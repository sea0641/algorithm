package prg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class hash_marathon {
	static String[] participant;
	static String[] completion;
	
	public static void main(String[] args) {
		solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"});
	}
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        List<String> listParticipant = new ArrayList<>(Arrays.asList(participant));
        for( var name : completion ) {
        	listParticipant.remove(name);
        }
        
        answer = listParticipant.get(0);
        
        return answer;
    }
	
	public static String solution2(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }

}
