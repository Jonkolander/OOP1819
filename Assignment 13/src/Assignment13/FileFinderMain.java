package Assignment13;

import java.io.IOException;

/**
 *
 * @author pieterkoopman
 */
public class FileFinderMain {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    FileFinderTest();
  }

  public static void FileFinderTest() {
    try {
      String goal = "FileFinder.java";
      String root = "/home/mkl/radboud";
      FileFinder filefinder = new FileFinder(root);
      filefinder.findFile(goal);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
