import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

public class Main {
    static int index = 4;
    static String Ipath = "test\\test"+index+".in";
    static String Opath = "test\\test"+index+".out";
    public static void main(String[] args)throws Exception{
        Writer writer = new FileWriter(Opath);
        Scanner scanner = new Scanner(new FileInputStream(new File(Ipath)));
        scanner.nextLine();
        while (scanner.hasNextLine()){
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            writer.write(Boolean.toString((first+first).contains(second)));
        }
        writer.flush();
        writer.close();
    }
}
