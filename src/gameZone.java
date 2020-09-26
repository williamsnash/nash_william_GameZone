import java.util.Random;
import java.util.Scanner;

/**
 * This program will prompt the user to pick between two game, twenty-One and Rock Paper Scissors
 * @author William Nash
 *
 */
public class gameZone
{
	/**
	 * This is a welcome function
	 * This has not returns or input
	 */
	public static void welcome()
	{
		System.out.println("***************************");
		System.out.println("Welcome to the GAME ZONE!!!");
		System.out.println("***************************");
	}//welcome

	public static void main(String[] args)
	{
		welcome();
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		int choice = 4;
		do
		{

				System.out.println("Here are your options");
				System.out.println("1: Twenty-One");
				System.out.println("2: Rock Paper Scissors");
				System.out.println("3: Exit");
				choice = sc.nextInt();
				if(choice == 1)
				{
					System.out.println("Launching--- Twenty-One");
					twentyOne(sc, ran);
				}//if
				else if(choice == 2)
				{
					System.out.println("Launching--- Rock Paper Scisoors");
					rps(sc, ran);
				}

		}while(choice != 3);
		System.out.println("Goodbye, have a good day");
		sc.close();
	}  
	
	/**
	 * twentyOne contains the game logic for Twenty-One
	 * @param Sc Passes scanner to not have to recreate scanner
	 * @param Ran to not recreate random
	 * @return though there are return statements, they are being used to exit the function to stop the rest of the code from running
	 */
	public static void twentyOne(Scanner sc, Random ran)
	{
		String choice = "y";
		int total = 0;
		do 
		{
			try
			{
				int user = ran.nextInt(11)+1;
				System.out.printf("You drew %d \n", user);
				total = total + user;
				System.out.printf("Your current total is %d \n", total);
				if(total == 21) {
					choice = "n";
					System.out.println("You Win!!!");
					return;
				}
				else if(total > 21)
				{
					choice = "n";
					System.out.println("Sorry you went over");
					System.out.println("You lose");
					return;
				}
				else
				{
					System.out.println("Would you like to draw again? ");
					choice = sc.next();
				}
			}catch(Exception ex){
				System.out.println("Something went terrible wrong");
				System.out.println("21");
			}
		}while(choice.equalsIgnoreCase("y"));
		
		int comp = ran.nextInt(21-13)+13;
		System.out.printf("The computer drew %d \n", comp);
		if(comp > total)
		{
			System.out.println("You lost");
		}
		else if(comp < total)
		{
			System.out.println("You Won!");
		}
		else if(comp == total)
		{
			System.out.println("You tied!!!");
			System.out.println("Thats rare!");
		}
		else
		{
			System.out.println("You should never have gotten here");
		}
		
	}//twentyOne
	
	/**
	 * rps contains the game logic for Rock, paper scissors
	 * @param Sc Passes scanner to not have to recreate scanner
	 * @param Ran to not recreate random 
	 */
	public static void rps(Scanner sc, Random ran)
	{
		//0 = rock
		//1 = paper
		//2 = scissor
		int computer = ran.nextInt(3);
		int user = ran.nextInt(3);
		String compString = rpsSub(computer);
		String userString = rpsSub(user);
		
		if(user == 0)
		{
			if(computer == 0)//user and computer played rock
			{
				System.out.printf("You played %s, and the computer played %s \n", userString, compString);
				System.out.println("It was a tie");
			}
			else if(computer == 1)//user played rock / computer played paper
			{
				System.out.printf("You played %s, and the computer played %s \n", userString, compString);
				System.out.println("You lose");
			}
			else if(computer == 2)//user played rock / computer played scissor
			{
				System.out.printf("You played %s, and the computer played %s \n", userString, compString);
				System.out.println("You win");
			}
		}//rock
		else if(user == 1)// user plays paper
		{
			if(computer == 0)//user played paper/ computer played rock
			{
				System.out.printf("You played %s, and the computer played %s \n", userString, compString);
				System.out.println("You win");
			}
			else if(computer == 1)//user played paper / computer played paper
			{
				System.out.printf("You played %s, and the computer played %s \n", userString, compString);
				System.out.println("It was a tie");
			}
			else if(computer == 2)//user played paper / computer played scissor
			{
				System.out.printf("You played %s, and the computer played %s \n", userString, compString);
				System.out.println("You lose");
			}
		}//paper
		else if(user == 2)//user played scissor
		{
			if(computer == 0)//user played scissor/ computer played rock
			{
				System.out.printf("You played %s, and the computer played %s \n", userString, compString);
				System.out.println("You lose");
			}
			else if(computer == 1)//user played scissor / computer played paper
			{
				System.out.printf("You played %s, and the computer played %s \n", userString, compString);
				System.out.println("You win");
			}
			else if(computer == 2)//user played scissor / computer played scissor
			{
				System.out.printf("You played %s, and the computer played %s \n", userString, compString);
				System.out.println("It was a tie");
			}
		}//scissor
		
	}
	
	/**
	 * Takes the number generated by the random number generator and converts to string
	 * @param num Number generated by random number generator
	 * @return String rock, paper, scissor
	 */
	public static String rpsSub(int num)
	{
		String temp;
		if(num == 0)
		{
			temp = "rock";
			return temp;
		}
		else if(num == 1)
		{
			temp = "paper";
			return temp;
		}
		else if(num == 2)
		{
			temp = "scissor";
			return temp;
		}
		else
		{
			System.out.println("You should never see this, if you do everything broke!");
			temp = "This is broken";
			return temp;
		}
	}
}
