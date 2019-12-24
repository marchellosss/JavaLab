public class SearchStringsTest {
    public static void main(String[] args) {
        String[] string = {"Vasya","dfghjkld","fghjkl","dfghjklkjhgf","fdghj","rtyui"};
       // String[] string = null;
        SearchStrings searchStrings = new SearchStrings();
        try{
            String result = null;
            result = searchStrings.searchString(string);
            string = result.split(" ");
            for ( int i = 0; i < string.length; i++){
                System.out.println(string[i]);
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("Empty string!!!");
        }
    }
}
