//Student 1 full name: Jordan Lau
//Student 2 full name: Tim Mao
//==================================================


/**
 * The interface <b> Stack </b> represents the abstract data type Stack.
 * A stack is a list of reference data types that is generally accessible only from the top.
 * It has an implementation, the class LinkedStack, that is used to represent each Tower.
 * <p>
 * @author Jordan Lau
 * @author Tim Mao
 */

public interface Stack{

    /**
     * This method checks if a Stack is empty or not.
     * 
     * @return boolean This returns true if the Stack is empty and false if the stack is not empty.
     */ 
    public abstract boolean isEmpty();

    /**
     * This method adds an element to the top of the Stack.
     * Pre-conditions: ! isEmpty()
     * @param Object This represents the elem to be added to the top of the Stack.
     */
    public abstract void push(Object o);

    /**
     * This method removes and returns the value of top element of the Stack.
     * Pre-conditions: ! isEmpty()
     * 
     * @return Object This returns the top element of the Stack.
     */
    public abstract Object pop();

    /**
     * This method returns but does not remove the top element of the Stack.
     * Pre-conditions: ! isEmpty()
     * 
     * @return Object This returns the top element of the Stack.
     */ 
    public abstract Object peek();
    
    /**
     * This method returns the number of elements in (the size of) the Stack.
     * 
     * @return int This returns the number of elements in (the size of) the Stack.
     */ 
    public abstract int size();

}