package infl;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 날짜: 2021/08/23
 * 문제: 인프런 DFSBFS기초 07-07 이진트리 레벨탐색(BFS: Breadth-First Search)
 */
/*
class Node {
	int data;
	Node lt, rt;
	
	public Node(int val) {
		this.data = val;
		this.lt = this.rt = null;
	}
}
*/

public class DfsBfsB_07_07 {
	Node root;
	
	public void BFS(Node root) {
		Queue<Node> Q = new LinkedList<Node>();
		Q.offer(root);
		int L = 0; //레벨
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			System.out.print(L + " : ");
			for(int i=0; i<len; i++) {
				Node cur = Q.poll();
				System.out.print(cur.data + " ");
				if(cur.lt != null) Q.offer(cur.lt);
				if(cur.rt != null) Q.offer(cur.rt);
			}
			L++;
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		DfsBfsB_07_07 tree = new DfsBfsB_07_07();
		
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		
		tree.BFS(tree.root);
	}

}
