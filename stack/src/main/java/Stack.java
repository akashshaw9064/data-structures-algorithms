import java.util.EmptyStackException;

// this is a stack implementation example using array
public class Stack {
    //stack size is 10
    private final int[] stack = new int[10];
    private volatile int top = -1;
    public synchronized int push(int x) throws OverFlowException {
        if(++top==stack.length){
            --top;
            throw new OverFlowException("Stack Overflow!");
        }
        stack[top]=x;
        return x;
    }
    public synchronized int pop()throws UnderFlowException{
        if(top==-1){
            throw new UnderFlowException("Stack Underflow!");
        }
        return stack[top--];
    }
    public synchronized int peek() throws StackEmptyException{
        if(top==-1){
            throw new StackEmptyException("The stack is Empty");
        }
        return stack[top];
    }

    public void display() {
        if(top==-1){
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack contains:");
        for(int i = top; i>=0; i--){
            System.out.println(stack[i]);
        }
    }
}
