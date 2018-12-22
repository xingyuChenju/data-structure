import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
public class RandomStr {
    static int len =1300;
    static String path = "test\\";
    static String inName = "test3.in";
    public static void main(String[] args)throws Exception{
        File file = new File(path);
        if (!file.exists()&&!file.isDirectory())
            file.mkdirs();
        Writer writer = new FileWriter(path+inName,true);
        writer.write(len+"\n");
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<len;i++)
            str.append(Character.toString((char) ((int) 'a' + Math.floor(Math.random()*26))));
        writer.write(str.toString());
        writer.flush();
        writer.close();
    }
}
