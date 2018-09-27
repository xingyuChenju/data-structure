import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }
    public static void main(String args[]){
//        String s = "()(()())";
//        String s = "()(()())(((()())))(())()(()())";
//        String s = "()(())";
//        String s = "()(()())((((()))))()(()(())())";
        String s = "(()(()))";
        System.out.print(scoreOfParentheses("()(()())((((()))))()(()(())())"));
//        writeFile(s.length()+"\n"+s+"\n","samplein");
//        writeFile(scoreOfParentheses(s)+"\n","sampleout");
    }
    public static void writeFile(String str,String filename) {
        byte bt[] = new byte[8192];
        bt = str.getBytes();
        try {
            FileOutputStream in = new FileOutputStream(filename+".txt", true);
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



