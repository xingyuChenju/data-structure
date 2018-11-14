import java.io.*;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Math.max;

public class Main {
//    public static String path = "test5";

    public static void main(String[] args)throws Exception{
//        File file = new File(path+".txt");
    Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(new FileInputStream(file));
        while(scanner.hasNextLine()){
//            System.out.println(scanner.nextLine());
            scanner.nextLine();
            String values = scanner.nextLine();
//            System.out.println(values.length());
            Node head = buildTree(values);
            deepth(head);
            System.out.print(maxLength(head));
//            writeFile(maxLength(head)+"",path+".out");
    }
//                String values = "1234@@@@@";
//        String values = "1@235@@@4@6@@";
//        String values = "124@@5@@36@@7@8@@";
//        String values = "XABD@@@CE@@F@@@";
//        String values = "1234@@@@@";
//        int a = values.length();
//        writeFile(a+"\n"+values,path+".in");
//        Node head = buildTree(values);
//        deepth(head);
//        writeFile(maxLength(head)+"",path+".out");
    }
    public static int maxLength(Node node){
        if (node.leftchild==null){
            if(node.rightchild==null){
                return 0;
            }
            else{
                return max(node.rightchild.deep+1,maxLength(node.rightchild));
            }
        }else {
            if (node.rightchild==null){
                return max(node.leftchild.deep+1,maxLength(node.leftchild));
            }else{
                return max(node.rightchild.deep+node.leftchild.deep+2,max(maxLength(node.rightchild),maxLength(node.leftchild)));
            }

        }
    }
    public static int deepth(Node node){
        if (node.leftchild==null){
            if (node.rightchild == null){
                node.deep = 0;
            }
            else {
                node.deep = deepth(node.rightchild)+1;
            }
        }else {
            if (node.rightchild == null){
                node.deep = deepth(node.leftchild)+1;
            }
            else {
                node.deep = max(deepth(node.rightchild),deepth(node.leftchild))+1;
            }
        }
        return node.deep;
    }
    public static Node buildTree(String values){
        Stack<Node> stack = new Stack<>();
        Node head  = new Node(values.charAt(0));
        stack.push(head);
        for (int i = 1;i<values.length()-1;i++){
            if (values.charAt(i)!='@') {
                Node node = new Node(values.charAt(i));
                if (stack.peek().leftchild==null)
                    stack.peek().leftchild = node;
                else {
                    stack.peek().rightchild=node;
                    stack.pop();
                }
                stack.push(node);
            }else {
                i++;
                if (values.charAt(i)!='@'){
                    Node node = new Node(values.charAt(i));
                    stack.peek().rightchild =node;
                    stack.pop();
                    stack.push(node);
                }else {
                    stack.pop();
                }
            }
        }
        return head;
    }
    public static void writeFile(String str,String filename) {
        byte bt[] = new byte[8192];
        bt = str.getBytes();
        try {
            FileOutputStream in = new FileOutputStream(filename, true);
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
class Node{
    char vlaue;
    // 用来记录有没有
    int deep;
    Node leftchild;
    Node rightchild;
    Node(char value){
        this.vlaue =value;
    }

}