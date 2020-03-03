import java.util.Random;
import java.util.Scanner;
public class TicTacToe
{
	//2D ARRAY DECLARED 
	static char[][] board = new char[3][3];


	//STATIC VARIABLE
	static int tieOrNot = 0;


	//GENERATE RANDOM ROW AND COLUMN METHOD
	static int getRowColumn()
	{
		Random randomValue = new Random();
		int randomRowColumn = randomValue.nextInt(3);
		return randomRowColumn;
	}


	//GENERATE RANDOM ROW AND COLUMN METHOD
	static int getNumber()
	{
		Random randomValue = new Random();
		int randomNumber = randomValue.nextInt(2);
		return randomNumber;
	}


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
				board[iter][iter2] = '_';
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
		//Random randomValue = new Random();
		int chooseSymbol = getNumber();
		if(chooseSymbol == 1)
		{
			System.out.println("Player assign X symbol");
			return 'X';
		}
		else
		{
			System.out.println("Player assign O symbol");
			return 'O';
		}
	}


	//TOSS METHOD
	static int toss()
	{
		//GENERATING RANDOM VALUE
		//Random randomValue = new Random();
		int randomValueToss = getNumber();
		if(randomValueToss == 1)
		{
			System.out.println("Now Player turn ");
			return randomValueToss;
		}
		else
		{
			System.out.println("Now computer turn ");
			return randomValueToss;
		}
	}


	//PLAYER
	static void playerPlaying(char playerSymbol)
	{
		//TAKING INPUT FROM USER 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter row number : ");
		int row =sc.nextInt();
		System.out.println("Enter column number : ");
		int column =sc.nextInt();
		System.out.println("Play enter your value ("+playerSymbol+") : ");
		char userValue = sc.next().charAt(0);
		if(board[row][column] == '_')
		{
			board[row][column] = userValue;
			tieOrNot++;
			showBoard();
			if((board[0][0] == playerSymbol && board[0][1] == playerSymbol && (board[0][2] == playerSymbol)) || 
					(board[1][0] == playerSymbol && board[1][1] == playerSymbol && (board[1][2] == playerSymbol)) ||
					(board[2][0] == playerSymbol && board[2][1] == playerSymbol && (board[2][2] == playerSymbol)) || 
					(board[0][0] == playerSymbol && board[1][0] == playerSymbol && (board[2][0] == playerSymbol)) || 
					(board[0][1] == playerSymbol && board[1][1] == playerSymbol && (board[2][1] == playerSymbol)) || 
					(board[0][2] == playerSymbol && board[1][2] == playerSymbol && (board[2][2] == playerSymbol)) ||
					(board[0][0] == playerSymbol && board[1][1] == playerSymbol && (board[2][2] == playerSymbol)) || 
					(board[2][0] == playerSymbol && board[1][1] == playerSymbol && (board[0][2] == playerSymbol)))
			{
				System.out.println("player won");
				System.exit(0); 
			}
			if(tieOrNot == 9)
			{
				System.out.println("Game Tie");
				System.exit(0);
			}
		}
		else
		{
			System.out.println("Entered position is occupied please play again");
			playerPlaying(playerSymbol);
		}
	}


	//COMPUTER
	static void computerPlayer(char computerSymbol)
	{
		//TAKING RANDOM ROW AND COLUMN
		int row = getRowColumn();
		int column = getRowColumn();
		if(board[row][column] == '_')
		{
			board[row][column] = computerSymbol;
			System.out.println("After Computer Turn : ");
			tieOrNot++;
			showBoard();
			if((board[0][0] == computerSymbol && board[0][1] == computerSymbol && (board[0][2] == computerSymbol)) ||
					(board[1][0] == computerSymbol && board[1][1] == computerSymbol && (board[1][2] == computerSymbol)) ||
					(board[2][0] == computerSymbol && board[2][1] == computerSymbol && (board[2][2] == computerSymbol)) || 
					(board[0][0] == computerSymbol && board[1][0] == computerSymbol && (board[2][0] == computerSymbol)) || 
					(board[0][1] == computerSymbol && board[1][1] == computerSymbol && (board[2][1] == computerSymbol)) || 
					(board[0][2] == computerSymbol && board[1][2] == computerSymbol && (board[2][2] == computerSymbol)) ||
					(board[0][0] == computerSymbol && board[1][1] == computerSymbol && (board[2][2] == computerSymbol)) || 
					(board[2][0] == computerSymbol && board[1][1] == computerSymbol && (board[0][2] == computerSymbol)))
			{
				System.out.println("Computer player won");
				System.exit(0); 
			}
			if(tieOrNot == 9)
			{
				System.out.println("Game Tie");
				System.exit(0);
			}
		}
		else
		{
			System.out.println("Entered position is occupied please play again");
			computerPlayer(computerSymbol);			
		}			
	}


	//PLAY GAME
	static void play(char playerSymbol,char computerSymbol,int whoWillPlay)
	{	
		//TOSS METHOD CALLED
		if(whoWillPlay == 1)
		{

			playerPlaying(playerSymbol);
			computerPlayer(computerSymbol);
		}
		else
		{
			computerPlayer(computerSymbol);
			playerPlaying(playerSymbol);
		}		
	}


	public static void main(String[] args)
	{
		//METHOD CALLED
		resetBoard();		
		char playerSymbol = assignSymbolToPlayer();
		char computerSymbol = '_';
		//ASSIGNING SYMBOL TO COMPUTER PLAYER
		if (playerSymbol == 'X' || playerSymbol == 'x')
		{
			computerSymbol = 'O';
		}
		else
		{
			computerSymbol = 'X';
		}

		int whoWillPlay = toss();
		while(true)
		{
			play(playerSymbol,computerSymbol,whoWillPlay);
		}
	}
}