//Student 1 full name: Jordan Lau
//Student 2 full name: Tim Mao
//==================================================


/**
 * The class <b> LinkedStack </b> implements the abstract data type Stack.
 * A stack is a list of reference data types that is generally accessible only from the top.
 * In this implementation, the elements of the stack are linked together to form a LinkedStack.
 * Each element of the LinkedStack, Elem, has an instance variable next that points to the element "below" it.
 * This class is used in the class HanoiTowerGame, which has an instance variable that is an array of LinkedStack.
 * Each LinkedStack is used to represent each Tower in the game.
 * <p>
 * @author Jordan Lau
 * @author Tim Mao
 */
public class LinkedStack implements Stack{

    /**
     * This nested (private) class represents an element in a LinkedStack.
     * Each element, Elem, has an instance variable next that points to the element "below" it.
     * Each element also has an instance variable, value, that represents a value of an Integer type Object.
     * <p>
     * @author Jordan Lau
     * @author Tim Mao
     */
    private static class Elem {

        private Integer value;
        private Elem next;

        /** 
         * Constructor method that initializes an Elem for use in the LinkedStack.
         * @param value This represents a value of an Integer type Object.
         * @param next This points to the element "below" it.
         */
        private Elem(Integer value, Elem next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem top;// Designates the top element (that can be taken out)
    private Elem bottom;// Designates the bottom element
    private int size;

    @SuppressWarnings( "unchecked" )

    /** 
     * Constructor method that initializes a LinkedStack.
     * This method has no parameters.
     * This method initializes the instance variables top and bottom as null and the size of the LinkedStack as 0.
     */
    public LinkedStack() {   
        top = null;
        bottom = null;
        size = 0;
    }

    /**
     * This method checks if a Stack is empty or not.
     * It is included simply to obey the best practices of encapsulation.
     * It is not called anywhere in this implementation of the game "The Tower Of Hanoi."
     * 
     * @return boolean This returns true if the Stack is empty and false if the stack is not empty.
     */ 
    public boolean isEmpty() {
        return ( bottom == null );
    }

    /**
     * This method returns but does not remove the top element of the Stack.
     * Pre-conditions: ! isEmpty()
     * It is used any time we want to see the disk at the top of the tower.
     * 
     * @return Object This returns the top element of the Stack.
     */ 
    public Integer peek() {
        return top.value;
    }

    /**
     * This method removes and returns the value of top element of the Stack.
     * Pre-conditions: ! isEmpty()
     * It is used any time we want to remove a disk from the top of a tower.
     * 
     * @return Object This returns the top element of the Stack.
     */
    public Integer pop() {
        Elem temporary = top; //Saves the top Elem
        top = top.next; // moves the top down one, to the Elem it was linking to
        size--;
        return temporary.value; //Returns the value of the Elem that was on top
    }

    /**
     * This method adds an element to the top of the Stack.
     * Pre-conditions: ! isEmpty()
     * It is used any time we want to add a disk to the top of a tower.
     * @param Object This represents the elem to be added to the top of the Stack.
     */
    public void push(Object o) {
        Integer element = (Integer) o;
        if (this.isEmpty()){//If stack is completely empty
            bottom = new Elem(element, null);
            top = bottom;
        }
        else{//if the stack has at least one item in it
            Elem temporary = new Elem(element, top);//Initializes the "next" Elem, and links it to the previous top Elem
            top = temporary;//Sets the new Elem as the top
        }

        size++;
    }

    /**
     * This method returns the number of elements in (the size of) the Stack.
     * It is used in the method play() of the class HanoiTowerGame to check if any towers are empty.
     * It is also used in the method checkWinner() of the class HanoiTowerGame to check if the 3rd tower has the right number of disks to win the game.
     * 
     * @return int This returns the number of elements in (the size of) the Stack.
     */ 
    public int size(){
        return size;
    }

    @SuppressWarnings( "unchecked" )

    /**
     * This method clears the stack by setting its top and bottom values to null.
     * It is included simply to obey the best practices of encapsulation.
     * It is not called anywhere in this implementation of the game "The Tower Of Hanoi."
     * 
     */ 
    public void clear(){
        bottom = null;
        top = bottom;
    }

}