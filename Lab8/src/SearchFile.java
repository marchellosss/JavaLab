import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFile {

    public static void findFiles(List<File> foundFiles, File rootDir, String extension) {
         Thread finder =  new Thread(new Runnable() {
              @Override
              public void run() {
                  while (!Thread.interrupted()) {
                      try {
                          if (rootDir.isDirectory()) {
                              for (File file : rootDir.listFiles()) {
                                  if (file.isDirectory()) {
                                      findFiles(foundFiles, file, extension);
                                  } else if (file.isFile()) {
                                      if (file.getName().endsWith(extension)) {
                                          foundFiles.add(file);

                                      }
                                  }
                              }
                          } else {
                              throw new IllegalArgumentException("rootDir should be directory: " + rootDir);

                          }
                      }
                      catch (IllegalArgumentException e) {
                          e.printStackTrace();
                      }
                      finally{
                          break;
                      }
                  }
              }
          });
         finder.start();
         while(finder.isAlive());
    }
}