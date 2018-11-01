public class Main {

    class tree {
        Node root;

        public void build(int left, int right) {
            root = new Node(left, right);
            build(root);
        } /*
         * 内部接口
         * 建立一棵线段树
         * */

        public void build(Node root) {
            int left = root.left;
            int right = root.right; //root节点为叶子节点
            if (right - left == 1) {
                return;
            } else if (right - left > 1) {
                int mid = (left + right) >> 1;////将左右区间平分
                Node leftNode = new Node(left, mid);
                Node rightNode = new Node(mid, right);
                root.leftChild = leftNode;
                root.rightChild = rightNode; //        递归的创建左右子树 build(leftNode); build(rightNode); } }

            }
        }
    }
}
class Node{
    int left;
    int right;
    Node leftChild;
    Node rightChild;
    int label;
    Node(int left,int right){
        this.left = left;
        this.right = right;
    }
}
