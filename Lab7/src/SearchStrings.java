import java.util.ArrayList;
import java.util.List;

public class SearchStrings {

    public String searchString( String[] inputString){
        if ( inputString == null) {
            throw new NullPointerException();
        }
        else{
            AverageSize averageSize;
            FindStrings findStrings;

            averageSize = (String[] string) -> {
                int[] sizeValues = new int[string.length];
                for (int i = 0; i < sizeValues.length; i++) {
                    sizeValues[i] = string[i].length();
                }
                int result = 0;
                for (int i = 1; i < sizeValues.length; i++) {
                    result += sizeValues[i];
                }
                return result / sizeValues.length;
            };

            findStrings = (String[] string, int averageSizeOfStrings) -> {
                List<String> list = new ArrayList<>();
                String result= null;
                for (int i = 0; i < string.length; i++) {
                    if (string[i].length() > averageSizeOfStrings) {
                        list.add(string[i]);
                    }
                }
                String[] resultString = new String[list.size()];
                for (int i = 0; i < resultString.length; i++) {
                    resultString[i] = list.get(i);
                }
                 return result.join(" ", resultString);
            };
            return findStrings.find(inputString, averageSize.getAverageSize(inputString));
        }
    }
}
