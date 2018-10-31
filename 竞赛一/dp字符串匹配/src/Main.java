import java.util.Scanner;

public class Main {
    int a[][]
    public static void main(String[] args){
        Scanner a = new Scanner(System.in);
        while (a.hasNext()){
            System.out.print(maxLen(a.nextLine(),a.nextLine()));
        }
//        String a = "abcdefgh";
//        String b = "ghabdh";
//        System.out.print(maxLen(a,b));
    }
    public static int maxLen(String a,String b){
        if (a.length()==0||b.length()==0)
            return 0;
        if(a.charAt(a.length()-1)==b.charAt(b.length()-1))
            return Math.max(Math.max(maxLen(a.substring(0,a.length()-1),b.substring(0,b.length()-1))+1,
                    maxLen(a.substring(0,a.length()-1),b)),
                    maxLen(a,b.substring(0,b.length()-1)));
        else
            return Math.max(maxLen(a.substring(0,a.length()-1),b),maxLen(a,b.substring(0,b.length()-1)));
    }
}
