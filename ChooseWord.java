import java.io.*;
import java.util.*;

public class ChooseWord {
  private int     random_num;
  private String  word;

  public ChooseWord(){
    word = null;
    Random randomGenerator = new Random();
    random_num = randomGenerator.nextInt(10); //num 0-9

    try {
      Scanner word_file = new Scanner(new File("words.txt"));
      List<String> words = new ArrayList<String>();

      while (word_file.hasNext()) {//stores the words of the file in the arraylist
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
