
public class Demo {
    static String a = "1 2 3 6 5";
    static String b = "2 3 4 4";
//    private String a = "1 2 3 6 5";
//    private String b = "2 3 4 4";

    /* 这个题目要求用链表做
    * */
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
        String[] c = a.split(" ");
        String[] d = b.split(" ");
        Node head = buildLinkList(c);
        Node head1 = buildLinkList(d);
        Node result = new Node();
        Node index = head;
        Node index1 = head1;
        int num = 0;
        int flag = 0;
        int count =0;
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
        while (index.getNext()!=null){
            index = index.getNext();
            System.out.print(index.getValue());
        }
    }
}
//    public static void main(String args[]){
//        String[] c = a.split(" ");
//        String[] d = b.split(" ");
//        Node head = buildLinkList(c);
//        Node head1 = buildLinkList(d);
//        Node result = new Node();
//        Node index = head;
//        Node index1 = head1;
//        int num = 0;
//        int flag = 0;
//        int count =0;
//        Node index2 ;
//        Node index3 = result;
//        //记录当前起点
//        while (index.getNext()!=null){
//            index = index.getNext();
//            index2 = index3;
//            index1 = head1;
//            while (index1.getNext()!=null){
//                index1 = index1.getNext();
//                if (index2.getNext()!=null) {
//                    count = index.getValue()*index1.getValue()+index2.getNext().getValue();
//                    num = (count+flag)%10;
//                    index2.getNext().setValue(num);
//                }else{
//                    count = index.getValue()*index1.getValue();
//                    num = (count+flag)%10;
//                    Node node = new Node(num);
//                    index2.setNext(node);
//                }
//               index2 = index2.getNext();
//                flag = (count+flag)/10;
//            }
//            if (flag!=0){
//                Node node = new Node(flag);
//                index2.setNext(node);
//                flag = 0;
//            }
//            index3 = index3.getNext();
//        }
//        index = result;
//        while (index.getNext()!=null){
//            index = index.getNext();
//            System.out.print(index.getValue());
//        }
//    }
//}


