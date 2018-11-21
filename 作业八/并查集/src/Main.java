import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

public class Main {
    public static int[] pre;
    static int counti = 0;
    static int countj = 0;
    static String path = "Union/test0.in";
    public static void main(String args[])throws Exception{
//        File file = new File("DATA\\DA\\D");
//        if (!file.exists() && !file.isDirectory()) {
//            file.mkdirs();
//        }
        String a = "111";
        Writer writer = new FileWriter("DATA\\DA\\D\\a.txt",true);
        writer.write(a);
        writer.close();
//        File file = new File(path);
//        Scanner in = new Scanner(new FileInputStream(file));
////        Scanner in = new Scanner(System.in);
//        String a = in.nextLine();
//        String[] b = a.split(" ");
//       pre = new int[(Integer.parseInt(b[0]))+1];
//        while (in.hasNextLine()){
//            a = in.nextLine();
//            b = a.split(" ");
//            int i = Integer.parseInt(b[1]);
//            int j = Integer.parseInt(b[2]);
//            if (b[0].charAt(0)== 'U')
//                union(i,j);
//            else
//                check(i,j);
//        }
    }
    public static void union(int i,int j){
        counti=0;
        countj=0;
        int ifather = checkfather(i,counti);
        int jfather = checkfather(j,countj);
        if (ifather!=jfather) {
            if (counti >= countj)
                pre[jfather] = ifather;
            else
                pre[ifather] = jfather;
        }
    }
    public static int checkfather(int son,int count){
        if (pre[son]==0)
            return son;
        else {
            count = count+1;
            return checkfather(pre[son],count);
        }
    }
    public static int checkfather(int son){
        if (pre[son]==0)
            return son;
        else
            return checkfather(pre[son]);
    }
    public static void check(int i,int j){
        if (checkfather(i)==checkfather(j))
            System.out.println("True");
        else
            System.out.println("False");
    }
}

