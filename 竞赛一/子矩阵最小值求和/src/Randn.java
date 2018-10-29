import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Randn {
    public static int len = 6;
    static long max =8;
    public static String filename = "test8";

    public static void main(String args[]){
        writeFile(len+"\n");
        long num;
        for (int i =0;i<len;i++){
            num = System.nanoTime()%(51*i+17+max*max)%max+1;
            if(i==len-1)
                writeFile(num+"");
            else
                writeFile(num+" ");
        }

    }

    public static void writeFile(String str) {
        byte bt[] = new byte[8192];
        bt = str.getBytes();
        try {
            FileOutputStream in = new FileOutputStream(filename+".in", true);
            try {
                in.write(bt, 0, bt.length);
                in.flush();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
