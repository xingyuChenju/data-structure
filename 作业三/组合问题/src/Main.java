import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static int label = 4;
//    public static String filename = "sample"+label+".out";
//    public static String filename1 = "sample"+label+".in";
public static String filename = "test"+label+".out";
public static String filename1 = "test"+label+".in";
    public static void main(String[] args){
        int m = 2;
        int k = 1;
        comb(m,k);
        writeFile(m+" "+k,filename1);
    }
    public static void comb(int m, int k){
        int[] a = new int[k];
        search(0,0,m,a);
    }
    public static void search(int begin,int index,int m,int[] a){
        if (index < a.length){
            for (int i =begin;i<m-a.length+index+1;i++){
                a[index] = i+1;
                search(i+1,index+1,m,a);
            }
        }else{
            for (int i = 0;i<a.length-1;i++){
//                System.out.print(a[i]+" ");
                writeFile(a[i]+" ");
            }
            if (a[0] == m-a.length+1){
                writeFile(a[a.length - 1] + "");
            }else {
//                System.out.print(a[a.length - 1] + "\n");
                writeFile(a[a.length - 1] + "\n");
            }
        }

    }
    public static void writeFile(String str) {
        byte bt[] = new byte[1024];
        bt = str.getBytes();
        try {
            FileOutputStream in = new FileOutputStream(filename, true);
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

    public static void writeFile(String str,String name) {
        byte bt[] = new byte[1024];
        bt = str.getBytes();
        try {
            FileOutputStream in = new FileOutputStream(name, true);
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
