import java.io.*;
import java.util.Scanner;

public class Main {
//    public static String arr = "3 1 2 4";
    static String filename = "test8";
    public static void main(String args[])throws Exception{
        Scanner a = new Scanner(System.in);

//            File file = new File(filename+".in");
//            Scanner a = new Scanner(new FileInputStream(file));
            while (a.hasNext()){
                if (Integer.parseInt(a.nextLine())==0){
                    System.out.println(0);
//                    writeFile(0+"");
                }
                    else{
                    String arr = a.nextLine();
                    System.out.println(sum(arr));
//                    writeFile(sum(arr)+"");
//                    System.out.println(sum2(arr));
                }
            }
    }

    public static int sum(String str){
        if (str.isEmpty())
            return 0;
        String[] nums = str.split(" ");
        int min;
        int temp;
        int sum = 0;
        for (int i = 0;i<nums.length;i++){
            min = Integer.parseInt(nums[i]);
            for (int j=i;j<nums.length;j++) {
                temp = Integer.parseInt(nums[j]);
                if (temp < min) {
                    min = temp;
                }
                sum += min;
                sum = sum%(1000000000-7);
            }
        }
        return sum;
    }
    //暴力方式
    public static int sum2(String str){
        if (str.isEmpty())
            return 0;
        String[] nums = str.split(" ");
        int[] arr =  new int[nums.length];
        for (int i = 0;i<nums.length;i++){
            arr[i] = Integer.parseInt(nums[i]);
        }
        int sum = 0;
        int min;
        int temp;
        for (int i = 0;i<arr.length;i++){
            min = arr[i];
            for (int j=i;j<nums.length;j++) {
                for (int k = i;k<=j;k++){
                    temp = arr[k];
                    min = temp<min?temp:min;
                }
                sum+=min;
                sum = sum%(1000000000-7);
            }
        }
        return sum;
    }
    public static void writeFile(String str) {
        byte bt[] = new byte[8192];
        bt = str.getBytes();
        try {
            FileOutputStream in = new FileOutputStream(filename+".out", true);
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
