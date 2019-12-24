import java.util.HashMap;
import java.util.Map;

public class Dictionary {
     private Map<String, String> map = new HashMap<>();
     public void addWord( String foreignWord, String translatedWord) {
         if( foreignWord!=null && translatedWord!=null) {
             foreignWord.toLowerCase();
             translatedWord.toLowerCase();
             map.put( foreignWord.toLowerCase(), translatedWord.toLowerCase());
         }
         else throw new IllegalArgumentException("Word cannot be null");
     }
     public String translateWord ( String foreignWord){
         if ( map.isEmpty()){
             throw new RuntimeException ("Dictionary is Empty");
         }

         if(map.containsKey( foreignWord.toLowerCase())){
            return map.get(foreignWord);
         }
         else throw new IllegalArgumentException("No such word in dictionary");
     }
     public String translatePhrase (String phrase){
         String[] parsePhrase;
         parsePhrase = phrase.split(" ");
         String[] result = new String[parsePhrase.length];
         String resultString;
         int count = parsePhrase.length;
         int index = 0;
         while (count>0)
         {
             try {
                 result[index] = translateWord(parsePhrase[count-1]);
             }
             catch (IllegalArgumentException e){
                 result[index]= parsePhrase[count-1];
             }
            /* catch (RuntimeException e){
                 throw new RuntimeException("Dictionary is empty");
             }*/
             index++;
             count--;
         }
         resultString = String.join(" ", result);
         return resultString;
     }
}
