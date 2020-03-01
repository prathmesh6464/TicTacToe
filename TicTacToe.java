import java.util.Random;
public class TicTacToe
{
	//ASSIGNING SYMBOL TO PLAYER
	static char assignSymbolToPlayer()
	{
		//GENERATING RANDOM VALUE
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

	
	//GENERATING BOARD
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

	
	//TOSS FUNCTION
	static int toss()
	{
		//GENERATING RANDOM VALUE
		Random randomValue = new Random();
		int randomValueToss = randomValue.nextInt(2);
		if(randomValueToss == 1)
		{
			System.out.println("Now User Turn : ");
			return randomValueToss;
		}
		else
		{
			System.out.println("Now computer Turn : ");
			return randomValueToss;
		}
	}


	public static void main(String[] args)
	{ 
		board();
		assignSymbolToPlayer();
		//TOSS FUNCTION CALLED
		int tossResult = toss();
		System.out.println("Toss Result : "+tossResult);
	}
}