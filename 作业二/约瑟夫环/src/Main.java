public class Main {
    public static void clockwise(DlinkedList list, int n){
        while (!list.isempty()){
            for (int i = 0; i<n-1;i++){
                list.setHead(list.getHead().getAfter());
            }
            if(list.getlength() == 1){
                System.out.print(list.getHead().vlaue+"\n");
            }else {
                System.out.print(list.getHead().vlaue+" ");
            }
            list.setHead(list.getHead().getAfter());
            list.removeNode(list.getHead().getPrior());
        }
    }

    public static void anticlockwise(DlinkedList list, int n){
        while (!list.isempty()){
            for (int i = 0; i<n-1;i++){
                list.setHead(list.getHead().getPrior());
            }
            if(list.getlength() == 1){
                System.out.print(list.getHead().vlaue+"\n");
            }else {
                System.out.print(list.getHead().vlaue+" ");
            }
            list.setHead(list.getHead().getPrior());
            list.removeNode(list.getHead().getAfter());
        }
    }

    public static void main(String[] args){
        DlinkedList list = new DlinkedList(5,2);
        clockwise(list,3);
        DlinkedList list1 = new DlinkedList(5,2);
        anticlockwise(list1,3);
    }

}
class DlinkedList{
    Node head;
    int m;
    public DlinkedList(int m, int k){
        this.head =buildList(m,k);
        this.m = m;
    }
    public Node getHead() {
        return head;
    }
    public boolean isempty(){
        return this.m==0;
    }
    public int getlength(){
        return this.m;
    }
    public void setHead(Node head) {
        this.head = head;
    }

    public void removeNode(Node node){
        node.getPrior().setAfter(node.getAfter());
        node.getAfter().setPrior(node.getPrior());
        m = m-1;
    }
    public Node buildList(int m, int k){
        Node first = new Node(1);
        Node prior = first;
        Node head =first;
        for(int i = 1; i<m;i++){
            Node node = new Node(i + 1);
            if(k==i)
                head = node;
            if (i==m-1){
                node.setPrior(prior);
                prior.setAfter(node);
                node.setAfter(first);
                first.setPrior(node);
            }else {
                node.setPrior(prior);
                prior.setAfter(node);
                prior = node;
            }
        }
        return head;
    }

}
class Node{
    Node prior;
    Node after;
    int vlaue;
    public Node(int value){this.vlaue = value;}
    public int getVlaue() {
        return vlaue;
    }

    public Node getAfter() {
        return after;
    }

    public Node getPrior() {
        return prior;
    }

    public void setAfter(Node after) {
        this.after = after;
    }

    public void setPrior(Node prior) {
        this.prior = prior;
    }

    public void setVlaue(int vlaue) {
        this.vlaue = vlaue;
    }
}
