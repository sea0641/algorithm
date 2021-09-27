package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 조합 {
   static int[] arr = { 1, 2, 3, 4, 5 };
   static boolean[] used = new boolean[arr.length];
   static List<String> result = new LinkedList<>();

   public static void main(String[] args) {
//      perm1(arr.length,0);
      combi(0, 3, 0);
   }

   private static void combi(int cnt, int end, int start) {
      if (cnt == end) {
         System.out.println(result);
         return;
      }

      for (int i = start; i < 5; i++) {
            result.add(new Integer(arr[i]).toString()); // i번쨰는 뽑을게
            used[i] = true; // i번 방문상태
            combi(cnt + 1, end, i+1); // 재귀
            used[i] = false; // i번 방문상태 없애기
            result.remove(new Integer(arr[i]).toString());

      }
   }

}