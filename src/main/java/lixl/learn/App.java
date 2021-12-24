package lixl.learn;

import lixl.learn.beans.Pers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    class Page{
        private String msg;
        private String pagenum;

        public Page(){
        }

        public Page(String msg , String pagenum){
            this.msg = msg;
            this.pagenum = pagenum;
        }

        public String getPagenum(){
            return pagenum;
        }

        public String getMsg(){
            return msg;
        }

    }
    List<Page> getChList(){
        List<Page> chList = Arrays.asList(new Page("fight .. ","137"),
                new Page("try to .. ","29"),
                new Page("don your .. ","6"));
        return chList;
    }
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        App a = new App();
        String contains = "";
        List<Page> list = a.getChList();

        list.stream().forEach(l -> System.out.println("If you "+l.getMsg() +"  turn to page " + l.getPagenum()) );
        System.out.println("page:");
        while (sc.hasNext()){
            String s = sc.next();
            System.out.println(s);
            var res = list.stream().filter(p -> p.getPagenum().equals(s)).collect(Collectors.toList());
            if(res.size() == 0){
                contains = "没有这个页面";
            }else{
                contains = res.get(0).getMsg();
            }
            System.out.println("      :"+contains);
            list.stream().forEach(l -> System.out.println("If you "+l.getMsg() +"  turn to page " + l.getPagenum()) );
            System.out.println("page:");
        }
    }
}
