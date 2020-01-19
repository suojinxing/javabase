package lambda;

import java.util.ArrayList;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        List a = new ArrayList(10);
        for(int i = 0; i< 10;i++){
            a.add(""+i);
        }
        a.forEach(aa->{
            System.out.println(aa);
        });
    }
}
