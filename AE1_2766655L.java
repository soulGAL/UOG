

//AE1_<2766655L>



import java.util.Scanner;
public class AE1_2766655L {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }
    public static void task1() {
        //capture user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the length");
        double length = sc.nextDouble();
        System.out.println("Please enter the width");
        double width = sc.nextDouble();
        //calculate the area of a rectangle
        double area = length * width;
        //print area to the screen
        System.out.println("the length of the rectangle is " + length);
        System.out.println("the width of the rectangle is " + width);
        System.out.println("the area of the rectangle equals " + area);
    }

    public static void task2() {
        //input parameters: max and number
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the max");
        int max = sc.nextInt();
        System.out.println("Please enter the number");
        int number = sc.nextInt();
        //Set a counter
        int count = 0;
        //between 1 and max (inclusive)
        for (int i = 1; i <= max; i++) {
            //The value must be odd, and the value must be a factor of number
            if((i % 2 == 1) && (number % i == 0)) {
                count++;
            }
        }
        //The print counter is the required number
        System.out.println("the total number of values is: " + count);
    }

    public static void task3() {
        //Take an int parameter and assign it to the variable 'challenge'
        int challenge = 10;
        //Both the player and the monster start with 3 hit points.
        int player = 3;
        int monster = 3;
        //The number of player unsuccessfully
        int count = 0;

        //The game continues until either the player or the monster lose all their hit points.
        while((player != 0) && (monster != 0)){
            //the user will input a number between 1 and 20
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter a number between 1 and 20");
            int number = sc.nextInt();
            // the number should between 1 and 20
            if((number < 1) || (number > 20)) {
                System.out.println("Wrong number, please enter again");
            }
            //the number higher than the challenge, the monster will lose 1 hit point
            else if(number > challenge) {
                monster--;
                System.out.println("Win! the monster have " + monster + " hit point");
            }
            //If the player rolls less than or the value of challenge
            else{
                //the first time the monster will miss and the player will not lose a hit point
                if(count == 0) {
                    System.out.println("Loss! but the monster miss");
                }else {
                    player--;
                    System.out.println("Loss! the monster have " + monster + " hit point");
                }
                count++;
            }
        }if (monster == 0){
            System.out.println("Game over! The player win!");
        }else{
            System.out.println("Game over! The monster win!");
        }
    }

    public static void task4() {
        //take an integer as an input parameter
        int secretNumber = 364;
        while (true){//the user is to input 2 numbers, separated by a single space
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter two numbers:(Separated by spaces)\n");
            String guesses = sc.nextLine();
            Scanner t = new Scanner(guesses);
            //ensure that exactly 2 guesses are entered
            if (!t.hasNext()) {
                System.out.println("You didn't enter any integers");
            } else {
                int number1 = t.nextInt();
                if (!t.hasNext()) {
                    System.out.println("You didn't enter two integers");
                } else {
                    int number2 = t.nextInt();
                    if (!t.hasNext()) {
                        System.out.println("You entered two integer");
                        //the guesses are correct, the player wins, then break
                        if (number1 == secretNumber || number2 == secretNumber) {
                            System.out.println("the guesses are correct, the player wins");
                            break;
                        } else {
                            //determine which value is closer to the secret number
                            int tempor1 = (number1 - secretNumber);
                            int tempor2 = (number2 - secretNumber);
                            //Comparing the absolute value of the difference between two numbers and the secret number
                            if (((tempor1 < 0) ? -tempor1 : tempor1) <= ((tempor2 < 0) ? -tempor2 : tempor2)) {
                                String line = String.format("You are %03d away from the secret number!", ((tempor1 < 0) ? -tempor1 : tempor1));
                                System.out.println(line);
                            } else {
                                String line = String.format("You are %03d away from the secret number!", ((tempor2 < 0) ? -tempor2 : tempor2));
                                System.out.println(line);
                            }
                        }
                    } else {
                        //If not 2 guesses, it should print an error message
                        System.out.println("You entered too many integers");
                    }
                }
            }
        }
    }

    public static void task5() {
        Scanner sc = new Scanner(System.in);
        //Specify 2 int parameters rows and columns
        System.out.println("Please enter the rows");
        int rows = sc.nextInt();
        System.out.println("Please enter the columns");
        int columns = sc.nextInt();
        //The minimum value that must be entered for the rows and columns is 5, and the maximum is 10
        if (((rows > 4) && (rows < 11)) && ((columns > 4) && (columns < 11))){
            //Specify three mines
            while (true){System.out.println("Please enter the row of the first mine");
            int mineRow1 = sc.nextInt();
            System.out.println("Please enter the colum of the first mine");
            int mineColumn1 = sc.nextInt();
            System.out.println("Please enter the row of the second mine");
            int mineRow2 = sc.nextInt();
            System.out.println("Please enter the colum of the second mine");
            int mineColumn2 = sc.nextInt();
            System.out.println("Please enter the row of the third mine");
            int mineRow3 = sc.nextInt();
            System.out.println("Please enter the colum of the third mine");
            int mineColumn3 = sc.nextInt();
            //Make sure the rows and columns of mines are within the given range
            if ((mineColumn1 <= columns) && (mineColumn1 >= 1) && (mineRow1<= rows) && (mineRow1 >= 1)
                && (mineColumn2 <= columns) && (mineColumn2 >= 1) && (mineRow2 <= rows) && (mineRow2 >= 1)
                && (mineColumn3 <= columns) && (mineColumn3 >= 1) && (mineRow3 <= rows) && (mineRow3 >= 1)){
                //Print a header for the table
                System.out.print("    |");
                for(int i = 0; i < columns; i++) {
                    String line = String.format("%3d", (i+1));
                    System.out.print(line);
                }
                System.out.print('\n');
                System.out.print("    |");
                //Print the separator
                for(int i = 0; i < columns; i++) {
                    String separator;
                    separator = String.format("%3c", '-');
                    System.out.print(separator);
                }
                System.out.print('\n');
                //Print the table
                for(int j = 1; j <= rows; j++) {
                    String firstColumn;
                    firstColumn = String.format("%3d" + " |", j);
                    System.out.print(firstColumn);
                    for(int i = 1; i <= columns; i++) {
                        //Specify three mines
                        if(((i == mineColumn1) && (j == mineRow1)) || ((i == mineColumn2) &&
                                (j == mineRow2)) || ((i == mineColumn3)&&(j == mineRow3))){
                            //Using the character 'x' to represent mines
                            String line = String.format("%3c", 'x');
                            System.out.print(line);
                        }else {
                            //Using the character 'o' to represent clear cells
                            String line = String.format("%3c", 'o');
                            System.out.print(line);
                        }
                    }System.out.print('\n'); System.out.print('\n');
                }break;
            }else {
                System.out.println("The rows and columns of mines are not in the given range");
            }
            }
        }else {
            //The minimum value that must be entered for the rows and columns is 5, and the maximum is 10
            System.out.println("The entered rows and columns do not meet requirements");
        }

    }
}


