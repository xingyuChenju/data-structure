import java.util.*;

public class Main {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int a, b;
        String line1;
        String line2;
        String  index;
        while (scanner.hasNext()) {
            index = scanner.nextLine();
//            a = index.charAt(0)-'0';
//            b = index.charAt(2)-'0';
            line1 = scanner.nextLine();
            line2 = scanner.nextLine();
            String[] c = line1.split(" ");
            String[] d = line2.split(" ");
            a = c.length;
            b = d.length;
            int[] temp = new int[a+b];
            for (int i=0;i<a;i++){
                temp[i]=Integer.parseInt(c[i]);
            }
            for (int j=0;j<b;j++){
                temp[a+j]=Integer.parseInt(d[j]);
            }
            for(int p=0;p<a+b;p++){
                for(int q=p+1;q<a+b;q++){
                    if(temp[p]>temp[q]){
                        int z= temp[p];
                        temp[p]=temp[q];
                        temp[q]=z;
                    }

                }
            }
            System.out.print(temp[1]);
            for (int i=1;i<a+b;i++) {
                System.out.print(" "+temp[i]);
            }
            if (scanner.hasNext())
            System.out.println();
        }
    }
}
