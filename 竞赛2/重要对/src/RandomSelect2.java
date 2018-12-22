import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomSelect2 {
    static String path = "select2.txt";
    static String ipath = "db.txt";
    static ArrayList<Integer> idlist = new ArrayList<>();
    static ArrayList<String> keys = new ArrayList<>();
    static ArrayList<String> labels = new ArrayList<>();
    static ArrayList<String> namelist = new ArrayList<>();
//    static Set<Integer> set = new HashSet<>();
    static String[] klabel = new String[2];
    static Writer writer;
    static StringBuilder str = new StringBuilder();
    public static void main(String[] args)throws Exception{
        labels.add(">");
        labels.add("<");
        labels.add("=");
        labels.add("!=");
        labels.add(">=");
        labels.add("<=");
        klabel[0] = "ASC";
        klabel[1] = "DESC";
        writer = new FileWriter(path,true);
        Scanner scanner = new Scanner(new FileInputStream(new File(ipath)));
        scanner.nextLine();
        String record = scanner.nextLine();
        String[] key =  record.split(" ,:");
        for (int i =2;i<key.length;i++)
            keys.add(key[i]);
//        Set<Integer> set = new TreeSet<>();
        while (scanner.hasNextLine()) {
            record = scanner.nextLine();
            key = record.split(" ");
            idlist.add(Integer.parseInt(key[0]));
            namelist.add(key[1]);
        }

        for (int i = 0;i<500;i++){
            randomCommand();
        }
        writer.flush();
        writer.close();
    }
    static void query(){
        int a = (int)(Math.random()*6);
        str.delete(0,str.length());
        switch (a) {
            case 0:
                int id = idlist.get((int) Math.floor(Math.random() * idlist.size()));
                str.append("QUERY " + id);
                break;
            case 1:
                String name = namelist.get((int)(namelist.size()*Math.random()));
                str.append("QUERY name = " + name);
                break;
            case 2:
                String key = keys.get((int)(Math.random()*keys.size()));
                String label = labels.get((int)(Math.random()*labels.size()));
                str.append("QUERY "+key+" "+label+" "+Math.round(Math.random()*100));
                break;
            case 3:
                String key1 = keys.get((int)(Math.random()*keys.size()));
                int k = (int)(Math.random()*idlist.size());
                str.append("QUERY "+key1+" : "+k+" "+klabel[(int)(Math.random()*2)]);
                break;
            case 4:
                String key2 = keys.get((int)(Math.random()*keys.size()));
                int k2 = (int)(Math.random()*idlist.size());
                int id1 = (int)(Math.round(Math.random()*100));
                int id2 = (int)(Math.round(Math.random()*100));
                if (id1>=id2){
                    int temp = id1;
                    id1 = id2;
                    id2 = temp;
                }
                str.append("QUERY "+id1+" "+id2+" "+ key2+" : "+k2+" "+klabel[(int)(Math.random()*2)]);
                break;
            case 5:
                int id3= (int)(Math.round(Math.random()*100));
                int id4 = (int)(Math.round(Math.random()*100));
                if (id3>=id4){
                    int temp = id3;
                    id3 = id4;
                    id4 = temp;
                }
                String key3 = keys.get((int)(Math.random()*keys.size()));
                String labe2 = labels.get((int)(Math.random()*labels.size()));
                str.append("QUERY "+id3+" "+id4+" "+key3+" "+labe2+" "+Math.round(Math.random()*100));
                break;
        }
    }
    static void set(){
        int a = (int)(Math.random()*4);
        str.delete(0,str.length());
        switch (a) {
            case 0:
                int id = idlist.get((int) Math.floor(Math.random() * idlist.size()));
                String key = keys.get((int) Math.floor(keys.size() * Math.random()));
                int vlaue = (int) Math.round(100 * Math.random());
                str.append("SET " + id + " " + key + " " + vlaue);
                break;
            case 1:
                int id1 = idlist.get((int) Math.floor(Math.random() * idlist.size()));
                String key1 = keys.get((int) Math.floor(keys.size() * Math.random()));
                int vlaue1 = (int) Math.round(200 * Math.random()) - 100;
                str.append("ADD " + id1 + " " + key1 + " " + vlaue1);
                break;
            case 2:
//                int id2 = idlist.get((int) Math.floor(Math.random() * idlist.size()));
                String key2 = keys.get((int) Math.floor(keys.size() * Math.random()));
                int vlaue2 = (int) Math.round(100 * Math.random());
                int id5= (int)(Math.round(Math.random()*100));
                int id6 = (int)(Math.round(Math.random()*100));
                if (id5>=id6){
                    int temp = id5;
                    id5 = id6;
                    id6 = temp;
                }
                str.append("SET " + id5 + " "+ id6 + " " + key2 + " " + vlaue2);
                break;
            case 3:
//                int id3 = idlist.get((int) Math.floor(Math.random() * idlist.size()));
                String key3 = keys.get((int) Math.floor(keys.size() * Math.random()));
                int vlaue3 = (int) Math.round(200 * Math.random()) -100;
                int id3= (int)(Math.round(Math.random()*100));
                int id4 = (int)(Math.round(Math.random()*100));
                if (id3>=id4){
                    int temp = id3;
                    id3 = id4;
                    id4 = temp;
                }
                str.append("ADD " + id3 + " " + id4 + " "+ key3 + " " + vlaue3);
                break;
        }
    }
    static void delete(){
        str.delete(0,str.length());
        int id = idlist.get((int)Math.floor(Math.random()*idlist.size()));
        for (int i=0;i<idlist.size();i++) {
          if (id==idlist.get(i))
            idlist.remove(i);
        }
        str.append("DELETE "+id);
    }
    static void insert(){
        str.delete(0,str.length());
        long id = Math.round(Math.random()* RandomDB.all);
        String name = RandomDB.getRandomString((int)Math.random()*3+6);
        long math = Math.round(Math.random()*100);
        long english = Math.round(Math.random()*100);
        long science = Math.round(Math.random()*100);
        long music = Math.round(Math.random()*100);
        if (!idlist.contains(id))
            idlist.add((int)id);
        str.append("INSERT ("+id+", "+name+", "+math+", "+english+", "+science+", "+music+")");
    }
    static void randomCommand(){
        int a = (int)Math.floor(Math.random()*4);
        switch (a){
            case 0:
                insert();
                break;
            case 1:
                delete();
                break;
            case 2:
                set();
                break;
            case 3:
                query();
                break;
        }
        try {
            writer.write(str.toString() + "\n");
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
