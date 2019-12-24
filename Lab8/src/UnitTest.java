import org.junit.Assert;
import org.junit.Test;


public class UnitTest {
    @Test
    public void test(){
        Assert.assertEquals(ForkJoinAdd.startForkJoinSum(1000),500500);
    }
}