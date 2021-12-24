package lixl.learn;

import lixl.learn.beans.Pers;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.function.Function;

public class Trys {

    @Test
    public void testNull(){
        Pers x = new Pers();
        x.setName(null);
        Optional<Pers> op = Optional.of(x);
        System.out.println("".equals(null));
//        System.out.println(x.equals(null));
        System.out.println(op.get().getName().equals(""));
    }

    @Test
    public void testDo(){
        CharSequence c = "";
        Function<String , String> f = x -> x;
        var x = 0;
        for(int i = 0 ; i < 100000000; i++){
            x += i;
        }
        System.out.println(x);
    }


}
