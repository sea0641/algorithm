package infl;

/*
 * 날짜: 2021/08/23
 * 문제: 인프런 DFSBFS기초 07-05 이진트리순회(DFS: Depth-First Search)
 */

class Node {
	int data;
	Node lt, rt;
	
	public Node(int val) {
		this.data = val;
		this.lt = this.rt = null;
	}
}
public class DfsBfsB_07_05 {
	Node root;
	
	public void DFS(Node root) {
		if( root == null) return;
		else {
			System.out.println(root.data + " "); //전위순회
			DFS(root.lt);
			//System.out.println(root.data + " "); //중위순회
			DFS(root.rt);
			//System.out.println(root.data + " "); //후위순회
		}
	}
	
	public static void main(String[] args) {
		DfsBfsB_07_05 tree = new DfsBfsB_07_05();
		
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		
		tree.DFS(tree.root);
	}

}
