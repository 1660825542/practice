import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.*;
import java.util.stream.Stream;

public class hdfs {
    private static Configuration conf=new Configuration();
    private  static final  String HADOOP_URL="hdfs://etc01:8020";
    private  static FileSystem fs;

    static {
        FileSystem.setDefaultUri(conf,HADOOP_URL);
        try {
            fs=FileSystem.get(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        System.out.println(fs.getDefaultBlockSize(new Path("/a3/hello.txt")));

        System.out.println(fs.getHomeDirectory());
    }
    @Test
    public  void  mkdir()
    {
        try {
            fs.mkdirs(new Path("t1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void put()
    {
        try {
            fs.copyFromLocalFile(false,true,new Path[]{new Path("D://789.txt"),new Path("D://456.txt")},new Path("/a3"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void get()
    {
        try {
            fs.copyToLocalFile(false,new Path("/a3/hello.txt"),new Path("D://"),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void delete()
    {
        try {
            fs.delete(new Path("/a3/456.txt"),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void read()
    {
        Path path=new Path("/a3/789.txt");
        try {
            FSDataInputStream dataInputStream=fs.open(path);
            InputStreamReader inputStreamReader=new InputStreamReader(dataInputStream,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String s=" ";
            while ((s=bufferedReader.readLine())!=null)
            {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public  void  write()
    {
        Path path=new Path("/a3/789.txt");
        try {
            FSDataOutputStream fsDataOutputStream=fs.append(path);
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fsDataOutputStream,"UTF-8");
            BufferedWriter bufferedReader=new BufferedWriter(outputStreamWriter);

           bufferedReader.write("111222333");

           bufferedReader.flush();
           bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
