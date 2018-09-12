import java.io.*;

public class ListMul {
    public static String path = "data\\";
    public static String inputname = "testsample.txt";
    public static String outputname = "final.txt";
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
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
            /* 读入TXT文件 */
            File outputfile = new File(path+outputname);
            if(!outputfile.exists()){
                outputfile.createNewFile();
            }
            FileWriter fw = new FileWriter(outputfile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            File inputfile = new File(path+inputname); // 要读取以上路径的input.txt文件
            InputStreamReader reader = new InputStreamReader(new FileInputStream(inputfile)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line1;
            String line2;
            //网友推荐更加简洁的写法
            while ((line1 = br.readLine()) != null) {
                // 一次读入一行数据
                line2 = br.readLine();
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
                bw.write(a+"\n");
            }
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class  Node{
    Node(int value){
        this.value = value;
    }
    Node(){
    }
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
    int value;
    Node next;
}
