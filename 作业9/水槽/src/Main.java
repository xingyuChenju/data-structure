import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

public class Main {
    static String path = "input\\test5.in";
    static String opath = "input\\test5.out";
    public static void main(String[] args) throws Exception{
//        String a = "1,8,6,2,5,4,8,3,7";
//        Writer writer = new FileWriter(opath);
//        File file = new File(path);
//        Scanner scanner = new Scanner(new FileInputStream(file));

//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            scanner.nextLine();
//            String[] strings = scanner.nextLine().split(" ");
//            long[] height = new long[strings.length];
//            for (int i = 0; i < height.length; i++)
//                height[i] = Long.parseLong(strings[i]);
//            System.out.print(findMAX(height));
////            writer.write("" + findMAX(height));
////            writer.close();
//        }


    }

    public static long findMAX(long[] height) {
        int begin = 0;
        int end = height.length - 1;
        long temp = height[begin] < height[end] ? height[begin] : height[end];
        long max = (end-begin)*temp;
        while (begin < end) {
            if (height[begin] == height[end]) {
                temp = height[begin];
                begin = begin + 1;
                while (height[begin] <= temp&&begin<end) {
                    begin++;
                }
                end = end - 1;
                while (height[end] <= temp&&begin<end) {
                    end--;
                }
                if (end >= begin) {
                    temp = height[begin] < height[end] ? height[begin] : height[end];
                    max = max > temp * (end - begin) ? max : temp * (end - begin);
                }
            } else {
                if (height[begin] < height[end]) {
                    temp = height[begin];
                    begin = begin + 1;
                    while (height[begin] <= temp&&begin<end) {
                        begin++;
                    }
                    if (end >= begin) {
                        temp = height[begin] < height[end] ? height[begin] : height[end];
                        max = max > temp * (end - begin) ? max : temp * (end - begin);
                    }
                } else {
                    temp = height[end];
                    end = end - 1;
                    while (height[end] <= temp&&begin<end) {
                        end--;
                    }
                    if (end >= begin) {
                        temp = height[begin] < height[end] ? height[begin] : height[end];
                        max = max > temp * (end - begin) ? max : temp * (end - begin);
                    }
                }
            }
        }
        return max;
    }
}