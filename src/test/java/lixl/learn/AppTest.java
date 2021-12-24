package lixl.learn;

import lixl.func.VoidFunc1;
import lixl.func.impl.VoidFunc1impl;
import lixl.learn.beans.Pers;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppTest implements Comparable<Pers>
{
    public int compareTo(Pers p ){
        return 0;
    }
    /**
     * 公共数据初始化
     */
    static List<Pers> getList(){
        List<Pers> perss = Arrays.asList(new Pers("stan", "男", 12)
                , new Pers("kyle", "男", 23)
                , new Pers("ele", "女", 17)
                , new Pers("tris", "女", 20)
                , new Pers("cartman", "男", 19));
        return perss;
    }

    static List<Pers> getList( Pers s){
        List<Pers> perss = Arrays.asList(new Pers("stan", "男", 12)
                , new Pers("kyle", "男", 13)
                , new Pers("ele", "女", 17)
                , new Pers("tris", "女", 20)
                , new Pers("cartman", "男", 9));
        return perss.stream().filter( p -> p.getName().contains(s.getName())).collect(Collectors.toList());
    }
    static List<Pers> getList(Supplier<Pers> su){
        List<Pers> perss = Arrays.asList(new Pers("stan", "男", 12)
                , new Pers("kyle", "男", 13)
                , new Pers("ele", "女", 17)
                , new Pers("tris", "女", 20)
                , new Pers("li", "男", 42)
                , new Pers("wang", "女", 78)
                , new Pers("zhao", "女", 14)
                , new Pers("qian", "女", 35)
                , new Pers("sun", "男", 29)
                , new Pers("liu", "男", 31)
                , new Pers("cartman", "男", 9));
        Optional<String> op = Optional.of(Optional.ofNullable(su.get().getName()).orElse(""));
        return perss.stream().filter((p) -> p.getName().contains(op.get())).collect(Collectors.toList());
    }


    /**
     * ----------------------=========================测试=========================---------------------
     */

    /**
     *      ------labmda API
     */

    @Test
    public void test1() {
//        Collections.sort(persList ,(p1 , p2) -> p1.getName().compareTo(p2.getName()) );
        List<Pers> x = getList();
        var y = getList();
        //sort方法进行集合排序，
        y.sort(Comparator.comparing( p -> p.getAge()));
        x.sort(Comparator.comparing( p -> p.getAge()));//此处使用labmda表达式，若是新声明变量，必须带泛型
        x.forEach(System.out::println );
        y.forEach(System.out::println );
        //扩展1： 集合和数组排序 ， comparable接口和comparator接口


    }


    //扩展2: MAP主要实现 HashMap ， TreeMap ， HashTable , LinkedHashMap
    @Test
    public void testMap(){

    }



    @Test
    public void test2(){
        String str = "123abc四大是";
        initPer(Pers::new);
    }

    @Test
    public void test3(){
        //用户创建
        this.create( p -> System.out.println(p.getName()+"用户，创建" ) , () -> getList1(new Pers("e") , p ->  getList(p)  ) );
        //显示用户多大年龄
//        this.create( (p) -> System.out.println(p.getName()+"用户年龄为"+p.getAge()) , () -> getList());
    }

    public void create( Consumer<Pers> con , Supplier<List<Pers>> s){
        for(Pers p : s.get()){
            con.accept(p);
        }
    }

    List<Pers> getList1(Pers per , Function<Pers,List<Pers>> func) {
        List<Pers> applys = func.apply(per);
        return applys;
    }

    Pers initPer(Supplier<Pers> s){
        return s.get();
    }

    /**
     * 获取流
     */
    @Test
    public void Stream1(){
//        Stream stream = Stream.of(getList(Pers::new));
        Stream stream = Stream.of(getList(Pers::new));
        Stream stream1 = Stream.of(getList(new Pers()));
        stream.forEach(System.out::println);
    }

}
