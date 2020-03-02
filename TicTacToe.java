import java.util.Random;
import java.util.Scanner;
public class TicTacToe
{
	//2D ARRAY DECLARED 
	static char[][] board = new char[3][3];

	
	//RESETING BOARD
	static void resetBoard()
	{
		for(int iter=0; iter<3; iter++)
		{
			for(int iter2=0; iter2<3; iter2++)
			{	
				if(iter2 != 0)
				{	
					System.out.print('|');
				}
				board[iter][iter2] = '0';
				System.out.print(board[iter][iter2]);				
			}
			System.out.println();
		}
	}


	static void showBoard()
	{
		for(int iter=0; iter<3; iter++)
		{
			for(int iter2=0; iter2<3; iter2++)
			{	
				if(iter2 != 0)
				{	
					System.out.print('|');
				}
				System.out.print(board[iter][iter2]);				
			}
			System.out.println();
		}
	}


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


	//TOSS METHOD
	static int toss()
	{
		//GENERATING RANDOM VALUE
		Random randomValue = new Random();
		int randomValueToss = randomValue.nextInt(2);
		if(randomValueToss == 1)
		{
			System.out.println("Now User Turn ");
			return randomValueToss;
		}
		else
		{
			System.out.println("Now computer Turn ");
			return randomValueToss;
		}
	}


	//PLAY GAME
	static void play()
	{	
		//VARIABLES
		char playerSymbol = assignSymbolToPlayer();
		int temp = 0;
		int temp2 = 0 ;
		int whoWillPlay = 0;
		char computerSymbol = '0';
		
		
		//ASSIGNING SYMBOL TO COMPUTER PLAYER
		if (playerSymbol == 'x')
		{
			computerSymbol = 'O';
		}
		else
		{
			computerSymbol = 'x';
		}
		
		
		//TOSS METHOD CALLED
		if(temp == 0)
		{
			whoWillPlay = toss();
		}


		if(whoWillPlay == 1 && temp2 == 0)
		{
			//TAKING INPUT FROM USER 
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Row Number : ");
			int row =sc.nextInt();
			System.out.println("Enter Column Number : ");
			int column =sc.nextInt();
			System.out.println("Play Enter Your Value ("+playerSymbol+") : ");
			char userValue = sc.next().charAt(0);
			if(board[row][column] == '0')
			{
				board[row][column] = userValue;
				showBoard();
			}
			else
			{
				System.out.println("Entered Position Is Occupied Please Play Again");
				temp++;
				play();
			}
		}
		else
		{
			//GENERATING RANDOM VALUE FOR COMPUTER PLAYER 
			Random randomValue = new Random();
			int row = randomValue.nextInt(3);
			int column = randomValue.nextInt(3);

			if(board[row][column] == '0')
			{
				board[row][column] = computerSymbol;
				showBoard();
			}
			else
			{
				temp2++;
				play();
			}			
		}		
	}

	
	public static void main(String[] args)
	{
		//METHOD CALLED
		resetBoard();
		play();
	}
}