package ICS4U4.retro_stack;

public class MyStack implements SimpleStack {

	private int[] stack;//creating a parameter for the stack so all functions have access
	private int top;//creating a parameter for the top of the stack so all functions have access
	private int capacity;//creating a parameter for the capacity of the stack so all functions have access
	//Constructor; set up the empty stack
	//capacity indicates the maximum size of the stack 
	public MyStack(int capacity)
	{
		this.stack=new int[capacity];//creating the stack array and storing in stack parameter
		this.capacity=capacity;//storing the capacity kn the capacity parameter
		this.top=-1;//storing -1 as the top of the stack as its currently empty in the top parameter
	}
	
	@Override
	public boolean push(int value) {
		//Check if the stack is full; if so, return false
		if(top>=capacity-1){
			return false;
		}
		//Increase the index of the top of the stack
		top++;
		//Store the new value at the top of the stack
		stack[top]=value;
		return true;
	}

	@Override
	public int pop() {
		
		//Check if the stack is empty, if so, return 0
		if(top<0){
			return 0;
		}
		//Check the value at the top of the stack
		int value=stack[top];
		//Reduce the index of the top of the stack by 1
		top--;
		//Return the value that was at the top of the stack
		return value;
	}

	@Override
	public int size() {
		return top+1;
	}

	@Override
	public boolean isEmpty() {
		if(top==-1){
		return true;
		}
		else{
			return false;
		}
	}
}
