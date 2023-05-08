package dsa;

public class StackClass {
	private int arr[];
	private int top;
	private int capacity;
	
	//created a stack
	public StackClass(int size) {
		arr = new int[size];
		capacity = size;
		top=-1;
	}
	
	//add elements into the stack
	public void push(int x) {
		if(top==capacity-1) {
			System.out.println("The stack is full");
		} else {
			System.out.println("Inserted "+ x);
			arr[++top] = x;
		}
	}
	
	//remove top element
	public int pop() {
		if(top<0) {
			System.out.println("Stack is empty");
			return -1;
		} else {
			return arr[top--];
		}
	}
	
	//return size of stack
	public int size() {
		return top+1;
	}
	
	//top element of the stack
	public int peek() {
		return arr[top];
	}
	
	//print the entire stack
	public void printStack() {
		for(int i=0;i<=top;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String args[]) {
		StackClass stack = new StackClass(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println(stack.pop());
		System.out.println("Top element: "+stack.peek());
		System.out.println("Size of stack: "+stack.size());
		stack.printStack();
	}
}
