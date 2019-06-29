//============================================================
//== Program: Exam III - Word Search Puzzle Exam 3 			==
//== Written: Truong Nguyen, Luciana Nardi, Chris Hayden    ==
//============================================================


import java.io.IOException;
import java.util.*;

public class Driver {

	public static void main(String[] args) {
		// 60 columns and 30 rows
		// each word contain 10 or less letters
		// up to 16 words
		// fill remaining spaces with random letters

		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		final int ROW = 30;
		final int COLUMN = 60;
		final int wordsmax = 16;// maximum quantity of words
		char[][] puzzleBoard = new char[ROW][COLUMN];		
		
		//displays welcome message
		Methods.welcomeMessage();

		int words = Methods.askNumberOfWords(wordsmax);
		String[] userWords = new String[words];
		//array used for debugging
		/*userWords[0] = "EVERYTHING";
		userWords[1] = "ADAPTATION";
		userWords[2] = "WEATHERING";
		userWords[3] = "CHARACTERS";
		userWords[4] = "LITERATURE";
		userWords[5] = "PERFECTION";
		userWords[6] = "HOMECOMING";
		userWords[7] = "TECHNOLOGY";
		userWords[8] = "APPRECIATE";
		userWords[9] = "RELAXATION";
		userWords[10] = "UNIVERSITY";
		userWords[11] = "FRIENDSHIP";
		userWords[12] = "CALIFORNIA";
		userWords[13] = "RENOVATION";
		userWords[14] = "MOTIVATION";
		userWords[15] = "MANAGEMENT";*/
		

		Methods.userInput(userWords); //ask user for input
		Methods.prepareBoard(puzzleBoard);
		for (int i = 0; i < userWords.length; i++) { // 1D array of words string
			int ranNum = rand.nextInt(8) + 1;//generates random number for direction 
			
			//switch menu, used to randomly select one of the eight directions
			switch (ranNum) {
			case 1: // accrossBackward, direction: 9 o'clock 
				// word string displayed from right to left				
				Methods.accrossBackward(userWords, puzzleBoard, i);
				break;

			case 2: // accrossForward, direction: 3 o'clock 
				// word string displayed from left to right
				Methods.accrossForward(userWords, puzzleBoard, i);				
				break;

			case 3: // upBackward, direction: 12 o'clock 
				// word string displayed vertically from bottom to top
				Methods.upBackward(userWords, puzzleBoard, i);				
				break;

			case 4: // upForward, direction: 6 o'clock 
				// word string displayed vertically from top to bottom
				Methods.upForward(userWords, puzzleBoard, i);
				break;

			case 5: // diaRightForward, direction: 5 o'clock 
				// word string displayed left to right, top bottom				
				Methods.diaRightForward(userWords, puzzleBoard, i);			
				break;

			case 6: // diaRightBackward, direction: 11 o'clock 
				// word string displayed right to left, bottom to top
				Methods.diaRightBackward(userWords, puzzleBoard, i);
				break;

			case 7: // diaLeftForward, direction: 8 o'clock 
				// word string displayed right to left, top to bottom
				Methods.diaLeftForward(userWords, puzzleBoard, i);
				break;

			case 8: // diaLeftBackward, direction: 5 o'clock 
				// word string displayed left to right, bottom to top
				Methods.diaLeftBackward(userWords, puzzleBoard, i);
				break;
			}// end switch
		} // end for
		

		System.out.println("Answers:\n");

		Methods.printPuzzle(puzzleBoard); // print out the puzzle
				
		try {
            Methods.puzzleAnswerFile(userWords,puzzleBoard);//saves answers to file
        } catch (IOException e) {
            e.printStackTrace();
        }//end try catch
		
		System.out.println("\n\n");
        Methods.fillPuzzle(puzzleBoard);
        Methods.printPuzzle(puzzleBoard);

        try {
            Methods.puzzleFile(userWords,puzzleBoard);//saves board to file
        } catch (IOException e) {
            e.printStackTrace();
        }//end try catch
		
	}// end main
}//end TestClass
