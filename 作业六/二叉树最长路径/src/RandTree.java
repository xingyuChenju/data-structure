import java.io.File;
import java.io.FileWriter;
public class RandTree {
    public static FileWriter writer;
    public static String path = "sample2.txt";
    public  static int shift = 0;
    public static void main(String[] args)throws Exception{
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        writer = new FileWriter(file,true);
        int len = 60;
        int mod = 15;

        int a[] = new int[len];
        a[0] =1;
        for (int i=1;i<a.length;i++){
            if ((System.nanoTime()+shift)%mod!=0) {
                a[i] = 1;
            }
            else {
                a[i] = 0;
                shift++;
            }
        }
        a = fixError(a);
        int count =0;
        for (int i=0;i<a.length;i++)
            count+=a[i];
        count = count*2+1;
        writer.write(count+"\n");
        中序遍历(a,0);
        writer.close();
    }
    public static void 中序遍历(int[] a,int index)throws Exception{
       if (index<a.length) {
           if (a[index]==1){
//               System.out.print((char) ('a' + System.nanoTime() % 26));
                writer.write((char) ('a' + System.nanoTime() % 26));
               中序遍历(a, 2 * index + 1);
               中序遍历(a, 2 * index + 2);
           }
           else {
               writer.write('@');
           }
       }
       else {
//           System.out.print('@');
           writer.write('@');
       }
    }
    public static int[] fixError(int[] arr){
        for (int i = 0;i<arr.length;i++){
            if (arr[(i+1)/2]==0){
                arr[i]=0;
            }
        }
        return arr;
    }

}
