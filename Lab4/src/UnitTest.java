import Animals.Lion;
import org.junit.jupiter.api.Test;
import org.testng.Assert;



public class UnitTest {
    @Test
    public void test(){
        Lion lion = new Lion(1,5,"Wild");
        Lion lion1 = new Lion(2,5,"Wild");
        Zoo zoo = new Zoo();

        Assert.assertEquals(zoo.addAnimalToEnclosure(lion),true);
        Assert.assertEquals(zoo.getCountOfAnimals(),1);
        Assert.assertEquals(zoo.removeAnimalFromEnclosure(lion),true);
        Assert.assertEquals(zoo.removeAnimalFromEnclosure(lion1),false);
        Assert.assertEquals(zoo.addCage(1),true);



    }
}