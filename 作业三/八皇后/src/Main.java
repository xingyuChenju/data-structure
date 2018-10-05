
public class Main {
    public static int[] results = new int[8];
    public static void eightQueue(int start,int level){
        results[level] = start;
        for (int i =0;i<results.length;i++){
            if (isOk(i+1,level+1)){
                results[level+1] =i+1;
                if (level+2==results.length){
                 for (int j = 0;j<results.length;j++){
                     System.out.print(results[j]);
                 }
                 System.out.println();
                }
                 else{
                        eightQueue(i+1, level + 1);
                    }
                }
            }
        }

    public static boolean isOk(int position,int level){
        for (int i =0;i<level;i++){
            if (results[i]==position|Math.abs(position-results[i])==Math.abs(level-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        eightQueue(1,0);
    }

}
