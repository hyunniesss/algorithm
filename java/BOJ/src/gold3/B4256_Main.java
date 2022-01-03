package gold3;

public class B4256_Main {
	
	static class Node {
		int x;
		Node left;
		Node right;
		public Node(int x) {
			this.x = x;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public void setRight(Node right) {
			this.right = right;
		}
	}
	
	public static void main(String[] args) {
		// 전위 순회 순서대로 할 수 있는 BT를 만들고
		// 만들때마다 중위 순회를 해서 입력받은 중위랑 같으면 OK
		// 후위 순회 출력
	}
	
	public void preOrder(Node v) {
		
	}
	
	public void postOrder(Node v) {
		if(v.left != null) {
			postOrder(v.left);
		}
		if(v.right != null) {
			postOrder(v.right);
		}
		System.out.println(v.x);
	}

}
