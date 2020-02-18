package leecode155;

import java.util.Stack;

class MinStack {

    class Node{
        int x;
        int minX;
        Node(int x,int minX){
            this.x=x;
            this.minX=minX;
        }
    }
    Stack<Node> stack=new Stack<Node>();    
    public MinStack() {
          
    }
    
    public void push(int x) {
       if(stack.empty()){
           Node node =new Node(x,x);
           stack.push(node);
            return;
       }
       int curMin = stack.peek().minX;
       Node node =new Node(x,Math.min(curMin,x));
       stack.push(node);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().x;
    }
    
    public int getMin() {
    	return stack.peek().minX;
    }
}
