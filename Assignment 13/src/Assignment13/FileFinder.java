package Assignment13;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author pieterkoopman
 */
public class FileFinder {

  private final File rootDir;

  public FileFinder(String root) throws IOException {
    rootDir = new File(root);
    if (!(rootDir.exists() && rootDir.isDirectory())) {
      throw new IOException(root + " is not a directory");
    }
  }

  public void findFile(String file) {
    find(rootDir, file);
  }

  private void find(File rootDir, String fileName) {
    File[] files = rootDir.listFiles();
    if (files != null) {
      for (File file : files) {
        if (file.getName().equals(fileName)) {
          System.out.println("Found at: " + file.getAbsolutePath());
          return;
        } else if (file.isDirectory()) {
          find(file, fileName);
        }
      }
    }
  }
}
