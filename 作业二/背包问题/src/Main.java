
import java.util.*;

public class Main {

    public static int bag(LinkedList<Integer> array, int s){
        int num = 0;
        if (array.isEmpty())
            return num;
        if(array.getFirst()<=s){
            num+=1;
            LinkedList<Integer> subArray1 = new LinkedList<>();
            LinkedList<Integer> subArray2 = new LinkedList<>();
            subArray1.addAll(array);
            subArray2.addAll(array);
            subArray1.remove(0);
            subArray2.remove(0);
            num+=bag(subArray1,s-array.getFirst());
            num+=bag(subArray2,s);
        }
        else {
            array.remove(0);
            num+=bag(array,s);
        }
        return num;
    }

    public static void main(String[] args){
        int[] goods = {1 ,2 ,19 ,30};
        int size = 20;
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for (int i = 0;i<goods.length;i++)
            nums.add(goods[i]);
        System.out.println(bag(nums,size));
     }
}
