/**
 * This WordLine class stores a word and the line number it appears on and is
 * used as an object throughout this project.
 * 
 * @author James Post
 *
 */
public class WordLine {
   String word;
   int number;
   /**
    * Two argument constructor
    * @param w The word
    * @param n The line number it appears on
    */
   public WordLine(String w, int n) {
      word = w;
      n = number;
   }
   /**
    * This is used to validate whether the WordLine constructed has a line number that is 1 or more
    * @param n the line number
    */
   public void validate(int n) {
      if (n < 1)
         throw new InvalidWordLineException("Line number cannot be less than 1");
      else
         System.out.println("Good!");
   }

}
