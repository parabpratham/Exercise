package Sudoku;


public class SudokuTable 
{
	public static void main(String[] args) throws InterruptedException
	{
		Position p1 = new Position(12,21);
		Position p2 = new Position(22,23);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		t2.join();
		t1.start();
		System.out.print("End");
		t2.start();
		
		 
	}

}
