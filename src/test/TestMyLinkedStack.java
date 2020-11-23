package test;

public class TestMyLinkedStack {
	
	public static void main(String[] args) {
		MyStack<String> stack = new MyStack<>(); 
		for(String s : "Hello World !!!".split(" ")) 
			stack.push(s);
		while(stack.top() != null) {
			System.out.println(stack.pop());
		}
	}
	

}

class MyStack<T> {
	Node<T> top;
	public MyStack() {
		top = new Node<>();
	}
	public void push(T item) {
		top = new Node<>(item, top);
	}
	public T pop() {
		Node<T> oldTop = top;
		if(!oldTop.end())
			top = oldTop.next;
		return oldTop.item;
	}
	public T top() {
		return top.item;
	}
	private class Node<U> {
		U item;
		Node<U> next;
		public Node() {
			this.item = null;
			this.next = null;
		}
		public Node(U item, Node<U> next) {
			this.item = item;
			this.next = next;
		}
		public boolean end() {
			return item == null && next == null;
		}
	}
}