import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int Edges;
    static String path = "test3";
 public static void main(String[] args)throws Exception{
//     Scanner scanner= new Scanner(new FileInputStream(new File(path)));
     Scanner scanner = new Scanner(System.in);
     String a = scanner.nextLine();
     String[] b= a.split(" ");
     int len = Integer.parseInt(b[0]);
     map = new int[len][len];
     Edges = Integer.parseInt(b[1]);
     while (scanner.hasNextLine()){
         a= scanner.nextLine();
         b= a.split(" ");
         map[Integer.parseInt(b[0])-1][Integer.parseInt(b[1])-1] = 1;
         map[Integer.parseInt(b[1])-1][Integer.parseInt(b[0])-1] = 1;
     }
     int[] hash = new int[len];
     System.out.print(min(0,hash,0));
 }
    public static int min(int current,int[] hash,int numEdges){
        if (current==hash.length){
            if (numEdges==Edges)
                return 0;
            else
                return hash.length;
        }
        if (hash[current]==1)
            return min(current+1,hash,numEdges);
        if (numEdges==Edges)
            return 0;
        int addEdges = 0;
        int sum1;
        int sum2;
        int[] newhash = new int[hash.length];
        for(int i = 0;i<map.length;i++){
            newhash[i] = hash[i];
            if (hash[i]!=1&map[current][i]==1)
                addEdges++;
        }
        if (addEdges==0)
            return min(current+1,hash,numEdges);
        else {
            hash[current] = 1;
            sum1 =1+ min(current + 1, hash,numEdges+addEdges);
            hash[current] = 0;
            addEdges = 0;
            int count=0;
            for (int i = 0;i<map.length;i++){
                if (newhash[i]==0&&map[current][i]==1){
                    for (int j = 0;j<map.length;j++){
                        if (newhash[j]==0&&map[i][j]==1){
                            addEdges++;
                        }
                    }
                    newhash[i]=1;
                    count++;
                }
            }
            sum2 = count+min(current+1,newhash,numEdges+addEdges);
            return Math.min(sum1,sum2);
        }
    }
}
