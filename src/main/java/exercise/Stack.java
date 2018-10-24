package exercise;

public class Stack<x> {

    static final int MAX = 1000;
    private x [] data;
    private int stackPointer;

    public Stack(){
        data=(x[]) new Object[MAX];
        stackPointer=0;
    }

    public void push(x newItem){

        if(stackPointer>=MAX){
            System.out.println ("Stack is overflow.");
        }else {
            data[stackPointer++] = newItem;
        }
    }
    public x pop(){
        if(stackPointer<=0){
            throw new IllegalStateException ("There is no item on the Stack.");
        }

        return data[--stackPointer];
    }

    public boolean contains(x item){
        boolean found=false;
        for(int i=0;i<=stackPointer;i++){
            if(data[i].equals (item)){
                found=true;
                break;
            }
        }
        return found;
    }
    public x access(x item){
        while(stackPointer>0){
            x tmpItem=pop();
            if(item.equals (tmpItem)){
                return tmpItem;
            }
        }
        //If we didn't find the item in the Stack.
        throw new IllegalArgumentException ("Could not find item in the Stack.");
    }

    public int size(){
        return stackPointer;
    }

    public boolean isEmpty(){
        return (stackPointer<=0);
    }

}
