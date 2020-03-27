package leecode155;

import java.util.LinkedList;
import java.util.Queue;


class MaxQueue {

    class Node{
        int x;
        int maxX;
        Node(int x,int maxX){
            this.x=x;
            this.maxX=maxX;
        }
    }
    LinkedList<Node> stack=new LinkedList<Node>();    
    public MaxQueue() {

    }
    
    public int max_value() {
    	return stack.peek().maxX;
    }
    
    public void push_back(int value) {
    	 if(stack.isEmpty()){
             Node node =new Node(value,value);
             stack.add(node);
              return;
         }
        for(Node node : stack) {
        	node.maxX = Math.max(node.maxX,value);
         
        }
        Node node =new Node(value,value);
         stack.add(node);
    }
    
    public int pop_front() {
    	return stack.remove().x;
    }
}
