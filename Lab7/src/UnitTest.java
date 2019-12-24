import org.junit.Assert;
import org.junit.Test;


public class UnitTest {
    @Test
    public void test(){
        String[] string = {"Vasya","dfghjkld","fghjkl","dfghjklkjhgf","fdghj","rtyui"};
         //String[] string = null;
        SearchStrings searchStrings = new SearchStrings();
        try{
            String result = null;
            result = searchStrings.searchString(string);
            string = result.split(" ");
        }
        catch(NullPointerException e)
        {
            System.out.println("Empty string!!!");
        }
        Assert.assertEquals(string[0],"dfghjkld");



    }
}