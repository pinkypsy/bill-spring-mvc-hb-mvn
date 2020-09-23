package trials;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class Ci  extends Bi {
    //    @Value("#{systemProperties['mongodb.port'] ?: 27017}")
//    @Value("55")
    @Value("${coldWaterTariff}")
    private double test;

    @Override
    public void a() {
        System.out.println(test);
        System.out.println("hi");
//    System.out.println(electricityTariffBorder);
    }

    public static <T> void rev(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i - 1));
            System.out.print(list.get(i));
            System.out.println(list);
        }
    }
    public void setTest(double test) {
        this.test = test;
    }

    public double getTest(){
        return test;
    }
}
