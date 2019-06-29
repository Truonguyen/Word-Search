import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Pattern;

public class Methods {

	public static void accrossBackward(String userWords[], char puzzleBoard[][], int i) {
		// places word from right to left, 9:00 direction
		int r;
		int c;
		String word;
		boolean empty;
		Random rand = new Random();

		do {
			empty = true;// flag
			// random numbers for row and column
			r = rand.nextInt(30);
			c = rand.nextInt(60 - userWords[i].length());

			word = userWords[i];
			word = Methods.reverseString(word);// reverses string
			// checks if the cells are 'empty'
			for (int x = 0; x < userWords[i].length(); x++) {
				if (puzzleBoard[r][c + x] != word.charAt(x) && puzzleBoard[r][c + x] != '*') {
					empty = false;
				} // end if
			} // end for
		} while (!empty);// end do while

		for (int j = 0; j < userWords[i].length(); j++) {
			puzzleBoard[r][c + j] = word.charAt(j);
		} // end for
	}// end acrossBackward

	public static void accrossForward(String userWords[], char puzzleBoard[][], int i) {
		// places word from left to right, 3:00 direction
		int r;
		int c;
		String word;
		boolean empty;
		Random rand = new Random();

		do {
			empty = true;// flag
			// random numbers for row and column
			r = rand.nextInt(30);
			c = rand.nextInt(60 - userWords[i].length());
			// checks if the cells are 'available'
			for (int x = 0; x < userWords[i].length(); x++) {
				if (puzzleBoard[r][c + x] != userWords[i].charAt(x) && puzzleBoard[r][c + x] != '*') {
					empty = false;
				} // end if
			} // end for
		} while (!empty);// end do while

		// places letters in the board
		for (int j = 0; j < userWords[i].length(); j++) {
			puzzleBoard[r][c + j] = userWords[i].charAt(j);
		} // end for
	}// end acrossForward

	public static int askNumberOfWords(int wordsmax) {
		int num = 0;
		boolean ask = false;
		Scanner input = new Scanner(System.in);

		while (!ask) {
			try {
				System.out.print("How many words would you like to input? ");
				num = input.nextInt();
				if (num > 0 && num <= wordsmax) {// checks for max number of words
					String[] userWords = new String[num];
					ask = true;
				} else if (num > 16) {
					System.out.println(">>> Sorry, you can enter up to " + wordsmax + " words.\n");
					ask = false;
				} else {
					System.out.println(
							">>> Sorry, you can't enter negative values. \n>>> Please, enter a number between 1 and "
									+ wordsmax + ".\n");
					ask = false;
				} // end if else
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, try again!\n");
				input.nextLine();// "flush", consumes the \n character
			} // end try catch
		} // end while
		return num;
	}// end askNumberOfWords

	public static void diaLeftBackward(String userWords[], char puzzleBoard[][], int i) {
		// places word from right to left, top bottom, 1:00 direction
		int r;
		int c;
		String word;
		boolean empty;
		Random rand = new Random();

		do {
			empty = true;// flag
			// random numbers for row and column
			r = rand.nextInt(30 - userWords[i].length());
			c = rand.nextInt(60 - userWords[i].length()) + userWords[i].length();

			word = userWords[i];
			word = Methods.reverseString(word);// reverses string
			// checks if the cells are 'available'
			for (int x = 0; x < userWords[i].length(); x++) {
				if (puzzleBoard[r + x][c - x] != word.charAt(x) && puzzleBoard[r + x][c - x] != '*') {
					empty = false;
				} // end if
			} // end for
		} while (!empty);// end do while

		// places letters in the board
		for (int j = 0; j < userWords[i].length(); j++) {
			puzzleBoard[r + j][c - j] = word.charAt(j);
		} // end inner for loop
	}// end diaLeftBackward

	public static void diaLeftForward(String userWords[], char puzzleBoard[][], int i) {
		// places word from right to left, top bottom, 8:00 direction
		int r;
		int c;
		String word;
		boolean empty;
		Random rand = new Random();

		do {
			empty = true;// flag
			// random numbers for row and column
			r = rand.nextInt(30 - userWords[i].length());
			c = rand.nextInt(60 - userWords[i].length()) + userWords[i].length();
			// checks if the cells are 'available'
			for (int x = 0; x < userWords[i].length(); x++) {
				if (puzzleBoard[r + x][c - x] != userWords[i].charAt(x) && puzzleBoard[r + x][c - x] != '*') {
					empty = false;
				} // end if
			} // end for
		} while (!empty);// end do while

		// places letters in the board
		for (int j = 0; j < userWords[i].length(); j++) {
			puzzleBoard[r + j][c - j] = userWords[i].charAt(j);
		} // end inner for loop
	}// end diaLeftForward

	public static void diaRightBackward(String userWords[], char puzzleBoard[][], int i) {
		// places word from right to left, bottom to top, 11:00 direction
		int r;
		int c;
		String word;
		boolean empty;
		Random rand = new Random();

		do {
			empty = true;// flag
			// random numbers for row and column
			r = rand.nextInt(30 - userWords[i].length());
			c = rand.nextInt(60 - userWords[i].length());

			word = userWords[i];
			word = Methods.reverseString(word);// reverses string

			// checks if the cells are 'available'
			for (int x = 0; x < userWords[i].length(); x++) {
				if (puzzleBoard[r + x][c + x] != word.charAt(x) && puzzleBoard[r + x][c + x] != '*') {
					empty = false;
				} // end if
			} // end for
		} while (!empty);// end do while

		// places letters in the board
		for (int j = 0; j < word.length(); j++) {
			puzzleBoard[r + j][c + j] = word.charAt(j);
		} // end for
	}// end diaRightBackward

	public static void diaRightForward(String userWords[], char puzzleBoard[][], int i) {
		// places word from left to right, top bottom, 5:00 direction
		int r;
		int c;
		String word;
		boolean empty;
		Random rand = new Random();

		do {
			empty = true;// flag
			// random numbers for row and column
			r = rand.nextInt(30 - userWords[i].length());
			c = rand.nextInt(60 - userWords[i].length());

			// checks if the cells are 'available'
			for (int x = 0; x < userWords[i].length(); x++) {
				if (puzzleBoard[r + x][c + x] != userWords[i].charAt(x) && puzzleBoard[r + x][c + x] != '*') {
					empty = false;
				} // end if
			} // end for
		} while (!empty);// end do while

		// places letters in the board
		for (int j = 0; j < userWords[i].length(); j++) {
			puzzleBoard[(r + j)][c + j] = userWords[i].charAt(j);
		} // end for
	}// end diaRightForward

	public static void fillPuzzle(char a[][]) {
		// fills cells with '*' of the 2D array with random letters

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == '*') {
					int number = (int) (Math.random() * 26) + 65;
					a[i][j] = (char) number;
				} // end if
			} // end inner for loop
		} // end outer for loop
	}// end fillPuzzle

	public static void printPuzzle(char a[][]) {
		// outputs the puzzleBoard on the console

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			} // end inner for
			System.out.println((i + 1));
		} // end outer for
	}// end printPuzzle

	public static void prepareBoard(char a[][]) {
		// fills the board with asterisks
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = '*';
			} // end inner for
		} // end outer for
	}// end prepareBoard

	public static void puzzleAnswerFile(String a[], char b[][]) throws IOException {
		// saves the answer of the puzzle to a txt file
		File file = new File("puzzleAnswer.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			} // end if

			PrintWriter pw = new PrintWriter(file);
			pw.println("									W O R D S E A R C H   A N S W E R\n\n");

			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b[i].length; j++) {
					pw.print(b[i][j] + " ");
				} // end inner for
				pw.println();
			} // end outer for

			for (int i = 0; i < a.length; i++) {
				pw.println((i + 1) + ". " + a[i]);
			} // end for

			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		} // end try catch
	}// end puzzleAnswerFile

	public static void puzzleFile(String a[], char b[][]) throws IOException {
		// saves the puzzle to a txt file
		File file = new File("puzzle.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			} // end if

			PrintWriter pw = new PrintWriter(file);
			pw.println("                                         W O R D S E A R C H   P U Z Z L E\n\n");

			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b[i].length; j++) {
					pw.print(b[i][j] + " ");
				} // end inner for
				pw.println();
			} // end outer for

			pw.println("\nFind these words:\n");

			for (int i = 0; i < a.length; i++) {
				pw.println((i + 1) + ". " + a[i]);
			} // end for

			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		} // end try catch
	}// end puzzleFile

	public static String reverseString(String n) {
		String result = "";
		// reverses the String
		// it gets the last character of the string and
		// concatenates with the previous one
		for (int i = n.length() - 1; i >= 0; i--) {
			result += n.charAt(i);
		} // end for
		return result;
	}// end reverseString

	public static void upBackward(String userWords[], char puzzleBoard[][], int i) {
		// places word vertically, direction: 12:00
		int r;
		int c;
		String word;
		boolean empty;
		Random rand = new Random();

		do {
			empty = true;// flag
			// random numbers for row and column
			r = rand.nextInt(30 - userWords[i].length());
			c = rand.nextInt(60);

			word = userWords[i];
			word = Methods.reverseString(word);// reverses string

			// checks if the cells are 'available'
			for (int x = 0; x < userWords[i].length(); x++) {
				if (puzzleBoard[r + x][c] != word.charAt(x) && puzzleBoard[r + x][c] != '*') {
					empty = false;
				} // end if
			} // end for
		} while (!empty);// end do while
		// places letters in the board
		for (int j = 0; j < userWords[i].length(); j++) {
			puzzleBoard[r + j][c] = word.charAt(j);
		} // end for
	}// end upBackward

	public static void upForward(String userWords[], char puzzleBoard[][], int i) {
		// places word vertically, direction: 6:00
		int r;
		int c;
		String word;
		boolean empty;

		Random rand = new Random();

		do {
			empty = true;// flag
			// random numbers for row and column
			r = rand.nextInt(30 - userWords[i].length());
			c = rand.nextInt(60);

			// checks if the cells are 'available'
			for (int x = 0; x < userWords[i].length(); x++) {
				if (puzzleBoard[r + x][c] != userWords[i].charAt(x) && puzzleBoard[r + x][c] != '*') {
					empty = false;
				} // end if
			} // end for
		} while (!empty);// end do while

		// places letters in the board
		for (int j = 0; j < userWords[i].length(); j++) {
			puzzleBoard[r + j][c] = userWords[i].charAt(j);
		} // end for

	}// end upForward

	public static void userInput(String a[]) {
		Scanner input = new Scanner(System.in);
		boolean good = false;

		for (int i = 0; i < a.length; i++) {
			do {				
				System.out.println((i + 1) + ". enter word:");
				a[i] = input.next();
				a[i] = a[i].toUpperCase();
				good = true;
				 if (!Character.isWhitespace(a[i].charAt(i))) {
					System.out.println("=====================================");
					System.out.println(">>>Please, enter ONE letters only.<<<");
					System.out.println("=====================================");
					good = false;
				}
				if (!Pattern.matches("[a-zA-Z]+", a[i])) {
					System.out.println("=================================");
					System.out.println(">>>Please, enter only letters.<<<");
					System.out.println("=================================");
					good = false;
				} // end if
				if (a[i].length() > 10) {
					System.out.println("================================================");
					System.out.println(">>>Sorry, enter words with 10 or less letters<<<");
					System.out.println("================================================");
					good = false;
				} else if (a[i].length() < 2 ) {
					System.out.println("================================================");
					System.out.println(">>>Sorry, enter words with at least 2 letters<<<");
					System.out.println("================================================");					
				}// end if
			} while (!good);// end do while
		} // end for
	}// end userInput

	public static void printpuzzle(String a[], char b[][]) throws IOException {

		File file = new File("puzzle.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			} // end if

			PrintWriter pw = new PrintWriter(file);
			pw.println("Crossword Puzzle");

			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b[i].length; j++) {
					pw.print(b[i][j] + " ");
				} // end inner for
				pw.println();
			} // end outer for

			for (int i = 0; i < a.length; i++) {
				pw.println((i + 1) + ". " + a[i]);
			} // end for

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} // end try catch
	}// end printPuzzle

	public static void welcomeMessage() {
		//Art found at: http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20
		System.out.println(" \n");

		System.out.println("                                                   n     ,-------------.\r\n"
				+ "    -*~*-             xxx                     ____/_\\____| Welcome to  |\r\n"
				+ "    (o o)            (o o)                       (z z)   _)------------'\r\n"
				+ "ooO--(_)--Ooo----ooO--(_)--Ooo---------------ooO--(_)--Ooo--------------\r\n"
				+ "                                                                                      ");

		System.out.println("         _    _               _   _____                     _     \r\n" + 
				"        | |  | |             | | /  ___|                   | |    \r\n" + 
				"        | |  | | ___  _ __ __| | \\ `--.  ___  __ _ _ __ ___| |__  \r\n" + 
				"        | |/\\| |/ _ \\| '__/ _` |  `--. \\/ _ \\/ _` | '__/ __| '_ \\ \r\n" + 
				"        \\  /\\  / (_) | | | (_| | /\\__/ /  __/ (_| | | | (__| | | |\r\n" + 
				"         \\/  \\/ \\___/|_|  \\__,_| \\____/ \\___|\\__,_|_|  \\___|_| |_|\r\n" + 
				"                                                    Generator Tool\n");

		System.out.println("This tool will generate a word search puzzle.\n"
				+ "You can input up to 16 words, each word containing 10 or less letters.\n"
				+ "Are you ready to start?\n");

	}

}// end Methods
