package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * 날짜: 2021/05/21
 * 문제: 백준 알고리즘 9095번_1,2,3 더하기
 * 설명: https://zorba91.tistory.com/43
 */

public class dp_9095 {
   public static void main(String[] args) throws IOException {
      Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        int n;
        
        int[] output = new int[11]; //동적으로 생성시키니 메모리 초과가 되서 정적으로 선언
        output[1] = 1; // 1을 넣을 경우 경우의 수 1가지(1)
        output[2] = 2; // 2를 넣을 경우 경우의 수 2가지(1+1, 2)
        output[3] = 4; // 3을 넣을 경우 경우의 수 3가지 (1+1+1, 1+2, 2+1, 3)
        
        for(int i=0; i<t; i++){
            n = scanner.nextInt();
            //4부터 점화식 적용,
            //output4 = 1 + output(3)
            //output4 = 2 + output(2)
            //output4 = 3 + output(1)
            //ㄸ라서 output4 = output(3) + output(2) + output(1)
            for(int j=4; j<=n; j++){
                output[j] = output[j-1] + output[j-2] + output[j-3];
            }
            System.out.println(output[n]);
        }
   }

}