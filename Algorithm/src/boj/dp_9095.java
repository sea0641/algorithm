package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * ��¥: 2021/05/21
 * ����: ���� �˰��� 9095��_1,2,3 ���ϱ�
 * ����: https://zorba91.tistory.com/43
 */

public class dp_9095 {
   public static void main(String[] args) throws IOException {
      Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        int n;
        
        int[] output = new int[11]; //�������� ������Ű�� �޸� �ʰ��� �Ǽ� �������� ����
        output[1] = 1; // 1�� ���� ��� ����� �� 1����(1)
        output[2] = 2; // 2�� ���� ��� ����� �� 2����(1+1, 2)
        output[3] = 4; // 3�� ���� ��� ����� �� 3���� (1+1+1, 1+2, 2+1, 3)
        
        for(int i=0; i<t; i++){
            n = scanner.nextInt();
            //4���� ��ȭ�� ����,
            //output4 = 1 + output(3)
            //output4 = 2 + output(2)
            //output4 = 3 + output(1)
            //���� output4 = output(3) + output(2) + output(1)
            for(int j=4; j<=n; j++){
                output[j] = output[j-1] + output[j-2] + output[j-3];
            }
            System.out.println(output[n]);
        }
   }

}