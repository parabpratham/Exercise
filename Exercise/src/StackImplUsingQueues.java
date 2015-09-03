import java.util.*;

/**
 *
 * @author Mahmood
 */
public class StackImplUsingQueues {

    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    int insertCount=0,removeCount=0;
    public int pop() {
        if (q1.peek() == null) {
            System.out.println("The stack is empty, nothing to return");
            int i = 0;
            System.out.println("Insert = " + getInsertCount());
            System.out.println("Remove = " + getRemoveCount());
            return i;
        } else {
            int pop = q1.remove();
            removeCount ++;
            System.out.println("Insert = " + getInsertCount());
            System.out.println("Remove = " + getRemoveCount());
            return pop;
        }
    }

    public void push(int data) {

        if (q1.peek() == null) {
        	insertCount++;
            q1.add(data);
        } else {
            for (int i = q1.size(); i > 0; i--) {
            	insertCount++;
            	removeCount++;
                q2.add(q1.remove());
            }
            q1.add(data);
            for (int j = q2.size(); j > 0; j--) {
            	removeCount++;
                q1.add(q2.remove());
            }

        }
        System.out.println("Insert = " + getInsertCount());
        System.out.println("Remove = " + getRemoveCount());
    }

    public static void main(String[] args) {
        StackImplUsingQueues s1 = new StackImplUsingQueues();
        //       Stack s1 = new Stack();
        s1.push(1);
        System.out.println("1st = push(1)");
        s1.push(2);
        System.out.println("1st = push(2)");
        s1.push(3);
        System.out.println("1st = push(3)");
        s1.push(4);
        System.out.println("1st = push(4)");
        s1.push(5);
        System.out.println("1st = push(5)");
        s1.push(6);
        System.out.println("1st = push(6)");
        s1.push(7);
        System.out.println("1st = push(7)");
        s1.push(8);
        System.out.println("1st = push(8)");
        s1.push(9);
        System.out.println("1st = push(9)");
        s1.push(10);
        System.out.println("1st = push(10)");
        // s1.push(6);
        System.out.println("1st = " + s1.pop());
        System.out.println("2nd = " + s1.pop());
        System.out.println("3rd = " + s1.pop());
        System.out.println("4th = " + s1.pop());
        System.out.println("5th = " + s1.pop());
        System.out.println("6th = " + s1.pop());
        System.out.println("7th = " + s1.pop());
        System.out.println("8th = " + s1.pop());
        System.out.println("9th = " + s1.pop());
        System.out.println("10th= " + s1.pop());
        s1.push(10);
        System.out.println("1st = push(10)");
        s1.push(10);
        System.out.println("1st = push(10)");
        s1.push(10);
        System.out.println("1st = push(10)");
        s1.push(10);
        System.out.println("1st = push(10)");
        s1.push(10);
        System.out.println("1st = push(10)");
        s1.push(10);
        System.out.println("1st = push(10)");
        s1.push(10);
        System.out.println("1st = push(10)");
        s1.push(10);
        System.out.println("1st = push(10)");
        s1.push(10);
        System.out.println("1st = push(10)");
        s1.push(10);
        System.out.println("1st = push(10)");
        
        // 10 push 10 pop
        
        System.out.println("Insert = " + s1.getInsertCount());
        System.out.println("Remove = " + s1.getRemoveCount());
    }

	public int getInsertCount()
	{
		return insertCount;
	}

	public int getRemoveCount()
	{
		return removeCount;
	}
}