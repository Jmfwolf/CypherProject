/* Joseph Wolf CS211
 * Extra Project
 * CypherClient
 * 
*/

//The file included with the program is "test.txt"

import java.util.*;
import java.io.*;

public class Cypher {
   public static void main(String[] args) throws FileNotFoundException{
   
      Scanner console = new Scanner(System.in);
      System.out.println("Please enter the name of the .txt file including extension. If it is not in the same folder, include directory.");
      String file = console.next();
      Scanner text = new Scanner(new File(file));
      PrintStream output = new PrintStream(new File("Cypher"+file));
      
      CypherMade example = new CypherMade(15675);
      encode(text, output, example);
      Scanner cypherText = new Scanner(new File("Cypher"+file));
      PrintStream reverse = new PrintStream(new File("decode"+file));
      decode(cypherText, reverse, example);
   
   }
   public static void encode(Scanner text, PrintStream output, CypherMade example){
      while(text.hasNext()){
         output.print(example.encode(text.next()) + " ");   
      }
   }
   
   public static void decode(Scanner text, PrintStream output, CypherMade example){
      while(text.hasNext()){
         output.print(example.decode(text.next()) + " ");   
      }
   }
}