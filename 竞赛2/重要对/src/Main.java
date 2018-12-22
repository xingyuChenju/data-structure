import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args)throws Exception{
//        Scanner scanner = new Scanner(new FileInputStream(new File("test7.in")));
        Scanner scanner= new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
//        while (scanner.hasNextLine()){
//            String a = scanner.nextLine();
//            String[] strs = a.split(" ");
            long[] arrs = new long[len];
            for (int i = 0;i<len;i++)
                arrs[i] = scanner.nextLong();
//                arrs[i] = Long.parseLong(strs[i]);
            System.out.println(pair(arrs));
//        }
    }

    public static long pair(long[] arrs){
        long count =0;
        Tree tree = new Tree();
        for (int i = arrs.length-1;i>=0;i--) {
           count+=tree.sum(arrs[i]);
           tree.insert(arrs[i]);
        }
        return count;
    }
}
class Tree{
    Node head;
    long count =0;
    class Node{
        long value;
        long left = 0;
        long right = 0;
        Node(long num){
            this.value = num;
        }
        Node lchild;
        Node rchild;
    }
    public void insert(long num){
        count = count+1;
        if(head==null)
            head = new Node(num);
        else {
            insert(num,head);
        }
    }
    private void insert(long num,Node root){
        if (num>=root.value){
            root.right+=1;
            if (root.rchild==null){
                Node node = new Node(num);
                root.rchild = node;
            }else {
                insert(num,root.rchild);
            }
        }else {
            root.left += 1;
            if (root.lchild == null) {
                Node node = new Node(num);
                root.lchild = node;
            } else {
                insert(num, root.lchild);
            }
        }
    }
//    private void firstOrder(long num,Node root){
//        if (root.lchild != null)
//            firstOrder(num,root.lchild);
//        if (root.value*2<num)
//            count++;
//        else
//            return;
//        if (root.rchild != null)
//            firstOrder(num,root.rchild);
//    }
    private void visit(long num,Node root){
        if (root == null)
            return;
        if (root.value*2<num) {
            count += root.left + 1;
            visit(num,root.rchild);
        }else {
            visit(num,root.lchild);
        }
//        else
//            return;
//        if (root.rchild != null)
//            firstOrder(num,root.rchild);
    }
    public long sum(long num){
        this.count =0;
//        if (this.head!=null)
            visit(num,head);
//        firstOrder(num,this.head);
        return this.count;
    }
}
