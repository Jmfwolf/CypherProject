/* Joseph Wolf CS211
 * Extra Project
 * Cypher object
 * 
 * Takes a text document and creates an encryption program based on a integer key
 * The program excludes punctuation.
*/


//Long term I would like to take the value of the char rather than the index of the String
//The challenge is to decode based on the char value

public class CypherMade{
   private String ABC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
   private int key;
   private int modulo = 62;
   
   public CypherMade(int key){
      this.key = key;
   }
   
   public String encode(String token){
      String newLine = "";
      for(int i = 0; i < token.length(); i++){
         if(ABC.indexOf(token.charAt(i)) < 0) break;
         int cryptNum = this.key * ABC.indexOf(token.charAt(i))% this.modulo;
         newLine += ABC.charAt(cryptNum);
      }
      return newLine;      
   }
   
   
   public String decode(String token){
      String newLine = "";
      for(int i = 0; i < token.length(); i++){
         for(int j = 0; j < 62; j++){
            int hold = this.key * j % this.modulo;
            if(ABC.charAt(hold) == token.charAt(i)){
               newLine += ABC.charAt(j);
              if((newLine.length() > i+1 && j== ABC.length()-1) || (newLine.length() < i && j== ABC.length()-1)){
                  return "Impossible to decode, please check the key provided.";
              }
            }
         }
      }
      return newLine;
   }
   
   public int getKey(){
      return this.key;
   }
   public void setKey(int newKey){
      this.key = newKey;
   }
}