package lixl.threadLearn;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ThreadTest1 implements Runnable{
    private String fileName;
    private String url;


    public ThreadTest1() {
//        this("默认","https://ucenter.51cto.com/images/noavatar_middle.gif");
        this.fileName = "默认";
        this.url = "https://ucenter.51cto.com/images/noavatar_middle.gif";
    }

//    public ThreadTest1 (String fileName , String url){
//        this.fileName = fileName;
//        this.url = url;
//    }

    public void run(){
        GetFile pget = new PerGetFile();
        pget.get();
    }

    @Test
    public void test1() {
        ThreadTest1 thread1 = new ThreadTest1();
        new Thread(thread1).start();
    }

}

interface GetFile{
    void get();
}

class PerGetFile implements GetFile{

    @Override
    public void get() {
        try {
            FileUtils.copyURLToFile(new URL("https://img-blog.csdnimg.cn/20190426100401737.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxODg0OTc2,size_16,color_FFFFFF,t_70")
                , new File("工作图"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class allGetFile implements GetFile {

    @Override
    public void get() {

    }
}