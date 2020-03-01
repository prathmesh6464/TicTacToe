import java.util.Random;
public class TicTacToe
{
	static char assignSymbolToPlayer()
	{
		Random randomValue = new Random();
		int chooseSymbol = randomValue.nextInt(2);
		if(chooseSymbol == 1)
		{
			System.out.println("Player Assign X Symbol");
			return 'X';
			
		}
		else
		{
			System.out.println("Player Assign O Symbol");
			return 'O';
		}
	}


	static void board()
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

	
	public static void main(String[] args)
	{ 
		board();
		char result = assignSymbolToPlayer();
		System.out.println("Result : "+result);
	}
}