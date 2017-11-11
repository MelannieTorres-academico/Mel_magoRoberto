import java.io.*;
import java.util.*;

public class ChooseWord {
  private int     random_num;
  private String  word;

  ChooseWord(){ //constructor
    String word = null;
    Random randomGenerator = new Random();
    random_num = randomGenerator.nextInt(11); //num 1-10

    try {
      Scanner word_file = new Scanner(new File("words.txt"));
      List<String> words = new ArrayList<String>(); //creates an arraylist to store all the words in the text file

      //stores the words of the file in the arraylist
      while (word_file.hasNext()) {
        word = word_file.next();
        words.add(word);
      }
      word_file.close();

      word = words.get(random_num);//chooses random word
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getWord(){
    return word;
  }
}
