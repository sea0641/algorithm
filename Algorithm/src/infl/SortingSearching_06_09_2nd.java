package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 날짜: 2021/10/25
 * 문제: 인프런 SortingSearching 06-09 뮤직비디오(결정알고리즘)
 */

public class SortingSearching_06_09_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //곡 길이 수
		int m = sc.nextInt(); //나누어 담을 DVD 수
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int lt = Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum();
		//이분탐색, DVD 한장에 담을 수 있는 최소 크기 구하기. 최소:배열의 가장 큰값, 최대:배열의 합
		int answer = 0;
		while(lt <= rt) {
			int mid = (lt+rt)/2; //DVD 한장에 담을 용량
			//mid 용량으로 담았을 때 아직 여유가 있다면 현재 용량 기록하고 용량 줄이기
			if(count(arr, mid) <= m) {
				answer = mid;
				rt = mid-1;
			}
			//mid 용량으로 담았을 때 DVD 장수가 m보다 크다면 용량 늘리기
			else lt = mid+1;
		}
		
		System.out.println(answer);
	}
	
	public static int count(int[] arr, int capacity) {
		int cnt=1; //DVD 장수
		int sum=0; //DVD에 담은 곡 길이의 합
		
		for(int x : arr) {
			//기존DVD의 용량이 초과한다면 다음 DVD장에 담는다.
			if( sum+x > capacity ) {
				cnt++;
				sum = x;
			} else sum += x; //기존 DVD에 곡 길이 더하기
		}
		
		return cnt;
	}

}
