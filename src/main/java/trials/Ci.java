package trials;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Component
public class Ci  extends Bi{
//    @Value("#{systemProperties['mongodb.port'] ?: 27017}")
@Value("${coldWaterTariff}")
    private int test;

@Override
   public void a(){
        System.out.println(test);
        System.out.println("hi");
//    System.out.println(electricityTariffBorder);
    }

//    public void setTest(String test) {
//        this.test = test;
//    }
//
//    public String getTest(){
//        return test;
//    }
}
