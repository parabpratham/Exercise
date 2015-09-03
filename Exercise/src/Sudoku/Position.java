package Sudoku;

import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Position implements Runnable {
	
	int leftIndex;
	int rightIndex;
	
	Position(int x,int y)
	{
		leftIndex =x;
		rightIndex = y;

	}
	Position()
	{
		

	}
	public void run() {
		
		System.out.print( ""+leftIndex+rightIndex);
		
	}
}
