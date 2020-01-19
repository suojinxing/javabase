package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    // 去掉重复的元素，并筛选出价格大于100。转化成集合
    @Test
    public void test1(){
        List<Integer> priceList = new ArrayList<>(10);
        priceList.add(100);
        priceList.add(101);
        priceList.add(99);
        priceList.add(150);
        priceList.add(163);
        priceList.add(66);
        priceList.add(60);
        priceList.add(103);
        priceList.add(22);
        priceList.add(101);
        priceList.add(55);

        List<Integer> resultList = priceList.stream().distinct().filter(price -> {
            return price > 100;
        }).collect(Collectors.toList());

        System.out.println(resultList);
    }
}
