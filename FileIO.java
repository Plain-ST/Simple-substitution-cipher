import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO {
  public static String read(String filename) {
    String str = null;
    try {
      File infile = new File(filename);
      Scanner fin = new Scanner(infile);
      while(fin.hasNext()) {
        if (str == null) {
          str = fin.nextLine();
        } else {
          str = str + "\r\n" +fin.nextLine();
        }
      }
      fin.close();
    }catch (FileNotFoundException e) {
      System.out.println("File Not Found");
    }
    return str;
  }
  public static void write(String filename, String str) {
    try {
      File outfile = new File(filename);
      PrintWriter fout = new PrintWriter(outfile);
      fout.println(str);
      fout.close();
    }catch (FileNotFoundException e) {
      System.out.println("File Not Found");
    }
  }
}