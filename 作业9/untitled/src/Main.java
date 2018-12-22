import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

public class Main {
    public static String path = "data\\";
    public static String outpath = "output\\";
    public static Writer writer;
    public static void main(String[] args)throws Exception{
        File file = new File(path);
        File[] files = file.listFiles();
        Scanner scanner;
        for (File inputfile:files) {
            String outputname = outpath+inputfile.getName().replace("in","out");
            writer = new FileWriter(outputname,true);
            scanner = new Scanner(new FileInputStream(inputfile));
            while (scanner.hasNextLine()) {
                SearchTree tree = new SearchTree();
                scanner.nextLine();
                String[] b = scanner.nextLine().split(" ");
                for (int i = 0; i < b.length; i++)
                    tree.insertNode(Integer.parseInt(b[i]));
                tree.firstOrder();
                System.out.println();
                writer.write("\n");
                tree.midOrder();
            }
            writer.close();
        }
    }
}
//class SearchTree{
//    private Node head;
//    private boolean flag;
//    SearchTree(){
//        this.flag = true;
//    }
//    private class Node{
//        int value;
//        Node leftchild;
//        Node rightchild;
//        Node(int value){
//            this.value = value;
//        }
//    }
//    public void insertNode(int value){
//        Node node = new Node(value);
//        if (head ==null)
//            head = node;
//        else{
//            insertNode(node,head);
//        }
//    }
//    private void insertNode(Node node,Node pre){
//        if(node.value<pre.value){
//            if (pre.leftchild == null)
//                pre.leftchild = node;
//            else
//                insertNode(node,pre.leftchild);
//        }
//        else{
//            if (pre.rightchild == null)
//                pre.rightchild = node;
//            else
//                insertNode(node,pre.rightchild);
//        }
//    }
//
//    public void firstOrder()throws Exception{
//        firstOrder(head);
//        flag = true;
//    }
//    public void midOrder()throws Exception{
//        midOrder(head);
//        flag = true;
//    }
//
//
//    private void firstOrder(Node node)throws Exception{
//        if (node==null)
//            return;
//        else {
//            if (flag) {
//                flag = false;
//                System.out.print(node.value);
//                Main.writer.write(""+node.value);
//            } else {
//                System.out.print(" " + node.value);
//                Main.writer.write(" " + node.value);
//            }
//            firstOrder(node.leftchild);
//            firstOrder(node.rightchild);
//        }
//    }
//    private void midOrder(Node node)throws Exception{
//        if (node==null)
//            return;
//        else{
//            midOrder(node.leftchild);
//            if (flag) {
//                flag = false;
//                System.out.print(node.value);
//                Main.writer.write(""+node.value);
//            } else {
//                System.out.print(" " + node.value);
//                Main.writer.write(" " + node.value);
//            }
//            midOrder(node.rightchild);
//        }
//    }
//}