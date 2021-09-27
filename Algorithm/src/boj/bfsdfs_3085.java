package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜: 2021/06/24
 * 문제: 백준 알고리즘 3085번_사탕 게임
 * 설명: https://1-7171771.tistory.com/39
 */	

public class bfsdfs_3085 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				//위,왼쪽 swap할 것 없이 오른쪽,아래만 스왑해봐도 된다.
				if(j+1 < n) {
					char c = board[i][j];
					board[i][j] = board[i][j+1];
					board[i][j+1] = c;
					int tmp = check(board);
					if(ans < tmp) {
						ans = tmp;
					}
					
					c = board[i][j];
					board[i][j] = board[i][j+1];
					board[i][j+1] = c;
				}
				
				if(i+1 < n) {
					char c = board[i][j];
					board[i][j] = board[i+1][j];
					board[i+1][j] = c;
					int tmp = check(board);
					if(ans < tmp) {
						ans = tmp;
					}
					
					c = board[i][j];
					board[i][j] = board[i+1][j];
					board[i+1][j] = c;
				}
			}
		}
		
		System.out.println(ans);
	}

	static int check(char[][] board) {
		int n = board.length;
		int ans = 1;
		for(int i=0; i<n; i++) {
			
			//행별로 최대 먹을 수 있는 사탕개수 세기
			int cnt = 1;
			for(int j=1; j<n; j++) {
				if(board[i][j] == board[i][j-1]) {
					cnt++;
				} else {
					cnt = 1;
				}
				
				if(ans < cnt) {
					ans = cnt;
				}
			}
			
			//열별로 최대 먹을 수 있는 사탕개수 세기
			cnt = 1;
			for(int j=1; j<n; j++) {
				if(board[j][i] == board[j-1][i]) {
					cnt++;
				} else {
					cnt = 1;
				}
				
				if(ans < cnt) {
					ans = cnt;
				}
			}
		}
		
		return ans;
	}

}
