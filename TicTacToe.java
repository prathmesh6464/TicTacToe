public class TicTacToe
{
	public static void main(String[] args)
	{ 
		int[][] board = new int[3][3];
		for(int iter=0; iter<3; iter++)
		{
			for(int iter2=0; iter2<3; iter2++)
			{	
				if(iter2 != 0)
				{	
					System.out.print("|");
				}
				System.out.print(board[iter][iter2]);
			}
			System.out.println();
		}
	}
}
