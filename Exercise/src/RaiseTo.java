public class RaiseTo
{

	public static void main(String[] args)
	{
		/*
		 * int base,power; String temp =
		 * javax.swing.JOptionPane.showInputDialog("Base Value"); base =
		 * Integer.parseInt(temp); temp =
		 * javax.swing.JOptionPane.showInputDialog("Power Value"); power =
		 * Integer.parseInt(temp); long result = 1; if(base==0 && power==0) {
		 * result = 0; } else for(int counter = 0;counter < power;counter++) {
		 * result = result * base; } System.out.println( base + " ^ " + power + " = " +
		 * result);
		 */
		int a[][] = new int[4][4];
		int m = 0;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
			{
				a[i][j] = m++;
			}
		move(a, 0, 0);

	}

	private static void move(int[][] a, int i, int j)
	{
		for (int k = 0; k < 4; k++)
			for (int l = 0; l < 4; l++)
			{
//				a[k][k] = 
			}
		int j1 = j+1;
		int i1 = i;
		while (i1 < 4)
		{
			System.out.print(a[i1][j1] + " ");
			i1++;
		}
		i1--;
		while (j1 < 4)
		{
			System.out.print(a[i1][j1++] + " ");
		}
		System.out.println();
		move(a, i, j+1);
	}
}
