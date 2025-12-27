public class DischargeStack {
    StackNode top;
    int size;

    public DischargeStack(){
        top = null;
        size = 0;
    }

    public void push(DischargeRecord data){ // adding new element to the top of stack. O(1) time complexity.
        StackNode newNode = new StackNode(data);

        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("New element pushed. ");

    }

    public DischargeRecord pop(){ // deleting the element at the top of stack. O(1) time complexity.
        if(top == null){
            System.out.println("Stack is already empty");
            return null;
        }

        DischargeRecord removedElement = top.data;
        top = top.next;
        size--;
        System.out.println("Element is removed  from stack. ");

        return removedElement;

    }

    public DischargeRecord peek(){ // returns the element at the top of stack. O(1) time complexity.
        if(top == null){
            System.out.println("Stack is already empty");
            return null;
        }

    return top.data;
}
    public void printStack(){ // prints all the elements in the stack. O(n) time complexity.
        if(top == null){
            System.out.println("Stack is empty");
            return;
        }

        StackNode temp = top;

        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Purpose of this task is managing the records of discharged patients with using Stack data structure.
    // It is easy and fast to reach the last discharged patient with using stacks because of LIFO(Last In First Out) rule.
    // The stack data structure has been manually prepared based on linked list structure.
    // Push, pop and peek operations is performed using the top value in the stack.
    // Push() , Pop() and Peek() methods has O(1) time complexity because they do not require any browsing.
    // But the printStack() method requires browsing for printing all the elements so it has O(n) time complexity.

}