
import java.util.*;

public class Main {
//    class Node{
//        int value;
//        Node next;
//        Node(int value){this.value = value;}
//        Node(){this.value = 0;}
//
//        public Node getNext() {
//            return next;
//        }
//        public int getValue() {
//            return value;
//        }
//        public void setNext(Node next) {
//            this.next = next;
//        }
//        public void setValue(int value) {
//            this.value = value;
//        }
//    }
//

//时间开销大,可以看出使用自带的linklist效率比较低，可以对一个链表操作来减少创建链表的开销改进
//    public static int bag(LinkedList<Integer> array, int s){
//        int num = 0;
//        if (array.isEmpty())
//            return num;
//        if(array.getFirst()<=s){
//            num+=1;
//            LinkedList<Integer> subArray1 = new LinkedList<>();
//            LinkedList<Integer> subArray2 = new LinkedList<>();
//            subArray1.addAll(array);
//            subArray2.addAll(array);
//            subArray1.remove(0);
//            subArray2.remove(0);
//            num+=bag(subArray1,s-array.getFirst());
//            num+=bag(subArray2,s);
//        }
//        else {
//            array.remove(0);
//            num+=bag(array,s);
//        }
//        return num;
//    }

// 使用数组开销变小了，代码更加简洁
    public static int bag(int[] a, int s,int index){
        int num = 0;
        if (index == a.length)
            return num;
        if(a[index]<=s){
            num+=1;
            num+=bag(a,s-a[index],index+1);
        }
        num+=bag(a,s,index+1);
        return num;
    }

    public static void main(String[] args){
        int[] goods = {1 ,2 ,30 ,19,2,1,5,1,2,545,14};
        int size = 20;
        System.out.print(bag(goods,size,0));
//        LinkedList<Integer> nums = new LinkedList<Integer>();
//        for (int i = 0;i<goods.length;i++)
//            nums.add(goods[i]);
//        System.out.println(bag(nums,size));
//
     }
}
