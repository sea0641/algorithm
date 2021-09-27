package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/06/27
 * 문제: 백준 알고리즘 10451번_순열 사이클
 * 설명: https://1-7171771.tistory.com/39
 */	

public class bfsdfs_10451 {
	static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            visited = new boolean[n + 1];
            graph = new ArrayList<>(); //테스트케이스별
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>()); //순열별
            }
            
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                graph.get(i).add(stoi(st.nextToken())); //순서대로 담기
            }
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if(dfs(i)) answer++; //하나의 사이클이 끝날때마다 증가
            }
            
            System.out.println(answer);
        }
    }

    private static boolean dfs(int x) {
        if(visited[x]) return false;
        visited[x] = true;
        for(int value: graph.get(x)) { //링크, x -> get(x):value
            if (!visited[value]) dfs(value);
        }
        return true;
    }
    
    static int stoi(String str) {
    	return Integer.parseInt(str);
    }

}
