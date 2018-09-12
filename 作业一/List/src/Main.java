import java.util.Scanner;

public class Main {
    //这个代码是可以过oj的代码，可以看看看怎么输入输出
    public static Node buildLinkList(String[] num){
        Node head = new Node();
        Node index = head;
        for(int i = 0;i<num.length;i++){
            Node node= new Node(Integer.parseInt(num[i]));
            index.setNext(node);
            index = node;
        }
        return head;
    }
    public static void main(String args[]){
            Scanner scanner = new Scanner(System.in);
            String line1;
            String line2;
            while (scanner.hasNext()) {
                // 一次读入一行数据
                line1 = scanner.nextLine();
                line2 = scanner.nextLine();
                String[] c = line1.split(" ");
                String[] d = line2.split(" ");
                Node head = buildLinkList(c);
                Node head1 = buildLinkList(d);
                Node result = new Node();
                Node index = head;
                Node index1 = head1;
                int num;
                int flag = 0;
                int count;
                Node index2 ;
                Node index3 = result;
                //记录当前起点
                while (index.getNext()!=null){
                    index = index.getNext();
                    index2 = index3;
                    index1 = head1;
                    while (index1.getNext()!=null){
                        index1 = index1.getNext();
                        if (index2.getNext()!=null) {
                            count = index.getValue()*index1.getValue()+index2.getNext().getValue();
                            num = (count+flag)%10;
                            index2.getNext().setValue(num);
                        }else{
                            count = index.getValue()*index1.getValue();
                            num = (count+flag)%10;
                            Node node = new Node(num);
                            index2.setNext(node);
                        }
                        index2 = index2.getNext();
                        flag = (count+flag)/10;
                    }
                    if (flag!=0){
                        Node node = new Node(flag);
                        index2.setNext(node);
                        flag = 0;
                    }
                    index3 = index3.getNext();
                }
                index = result;
                String a = new String();
                while (index.getNext()!=null){
                    index = index.getNext();
                    a = index.getValue()+a;
                }
                System.out.println(a);
            }


    }
}
class  Node{
    int value;
    Node next;
    Node(int value){
        this.value = value;
    }
    Node(){}
    public void setNext(Node next){
        this.next = next;
    }
    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
    public Node getNext(){
        return this.next;
    }
}
