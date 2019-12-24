import org.junit.Assert;
import org.junit.Test;


public class UnitTest {
    @Test
    public void test(){
        Dictionary dictionary = new Dictionary();
        dictionary.addWord("dog", "собака");
        Assert.assertEquals(dictionary.translateWord("dog"),"собака");



    }
}