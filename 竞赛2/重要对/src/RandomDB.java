import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

public class RandomDB {
    static int length =10000;
    static int all = 1000000;
    static String path = "db.txt";

    public static void main(String[] args) throws Exception{
//        keys.add("")
        Writer writer = new FileWriter(path,true);
        writer.write("score");
        writer.write("id ,:name ,:math ,:english ,:science ,:music\n");
        Set<Long> set = new TreeSet<>();
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0;i<length;i++)
            names.add(getRandomString(i%3+6));
        while (set.size()<length)
            set.add(Math.round(Math.random()*all));
        int count = length;
        for (long id:set){
            count--;
            long math = Math.round(Math.random()*100);
            long english = Math.round(Math.random()*100);
            long science = Math.round(Math.random()*100);
            long music = Math.round(Math.random()*100);
            String name = names.get((int)(Math.floor(length*Math.random())));
            if (count==0)
                writer.write(id +" "+name+" "+math+" "+english+" "+science+" "+music);
            else
                writer.write(id +" "+name+" "+math+" "+english+" "+science+" "+music+"\n");
        }
        writer.flush();
        writer.close();
    }
    public static String getRandomString(int length){
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<length; ++i){
            //产生0-61的数字
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }
}
