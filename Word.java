import java.io.*;
import java.util.*;

public class Word{
	private ArrayList<Character> correctLetters;   // correct guesses
	private ArrayList<Character> incorrectLetters; // incorrect guesses
	private ArrayList<Character> secret_word_arr;	//the secret word converted to array
	private Scanner scan = new Scanner(System.in); // for user input
	private ChooseWord word;

	public Word(){
		word = new ChooseWord();
		String secretword=word.getWord();

		//fills correctLetters with underscore equal to the letters of the secret word
		this.correctLetters = new ArrayList<Character>();
		for (int i = 0; i < secretword.length(); i++){
			this.correctLetters.add('_');
    }

    this.incorrectLetters = new ArrayList<Character>();

		//creates an arraylist with the letters of the secret word as elements
		this.secret_word_arr = new ArrayList<Character>();
    for(int i = 0; i < secretword.length();i++){
        secret_word_arr.add(secretword.charAt(i));
    }

		while(!gameOver()){
			System.out.print("Word   :  ");

			//Print the correct guesses in the secret word
			for (int i = 0; i < this.correctLetters.size(); i++){
				System.out.print(this.correctLetters.get(i) + " ");
      }

			//Print the incorrect letters that have been guessed
			System.out.print("\nMisses :  ");
			for (int i = 0; i < this.incorrectLetters.size(); i++){
				System.out.print(this.incorrectLetters.get(i) + " ");
      }

			//Prompt and read the next guess
			System.out.print("\nGuess  :  ");
			String guess = scan.nextLine();

			//Process the next guess
			handleGuess(guess.charAt(0));
		}

		System.out.println("The secret word was: " + secretword);
		if (gameWon()) {
			System.out.println("Congratulations, you won!");
		} else
			System.out.println("Sorry, you lost.");
	}

	private boolean gameOver() {
		if((this.incorrectLetters.size()==5)||(gameWon())){
			return true;
		}else{
      return false;
    }
	}

	private boolean gameWon() {
		for(int i = 0; i < this.correctLetters.size(); i++){
			if(this.correctLetters.get(i)=='_'){//if there is at least one underscore
				return false;					//return a false
			}
		}
		return true;
	}

	private void handleGuess(char ch) {
		boolean correct= false; //if the letter entered by the user is correct, returs a true
		for(int i = 0; i<this.correctLetters.size();i++){
			if(ch==this.secret_word_arr.get(i)){
				this.correctLetters.set(i,ch);
				correct=true;
			}
		}
		if(correct==false){
			this.incorrectLetters.add(ch);
      //change turn
		}
	}
}
