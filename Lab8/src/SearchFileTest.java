import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFileTest {

    public static void main(String[] args) {
        List<File> foundFiles = new ArrayList<>();
        File rootDir = new File("E:/KPI_5/Java");
        SearchFile.findFiles(foundFiles, rootDir, ".java");
        for (File file : foundFiles) {
            System.out.println(file);
        }
    }
}
