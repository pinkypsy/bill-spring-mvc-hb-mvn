package trials;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

       AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        Int ci = context.getBean("ci", Int.class);


        BigDecimal bigDecimal = new BigDecimal("583");

        BigDecimal bigDecimal2 = new BigDecimal("96");

        System.out.println(bigDecimal.divide(bigDecimal2, 4));

        Double aDouble = 13.5;

        System.out.println(Math.floor(aDouble * 100));



//        ci.a();
//        List<Integer> ab = Arrays.asList(1,2,3,4,5,6);
//        System.out.println(ab);
//        Ci.rev(ab);
//        System.out.println(ab);

//        new Ci().a();






        System.out.println(sumN(3));
    }

    public static int sumN(int n) {
        int result = 0;
        for(int i = 0; i <= n; i++) {
//            System.out.print(i + " ");
            //Write code under this line
            System.out.println(result += i);
//            System.out.println(result += i);
//            result = result + i;
        }
        return result;


    }


}

//        Class.forName("com.mysql.cj.jdbc.Driver");
//            String user = "root";
//            String password = "root";
//            String URL =
//                    "jdbc:mysql://localhost:3306/utility_service_bill?useSSL=false&serverTimezone=GMT&allowPublicKeyRetrieval=true";
//
//            try(Connection connection = DriverManager.getConnection(URL,user,password);
//                Statement statement = connection.createStatement()){
//
////                statement.execute(
////                        "select * from bill_counted");
//
////                while (resultSet.next()) {
////                    System.out.println(resultSet.getString("electricity"));
////                }
//
//            }

//        Integer i = null;
//
//        i.hashCode();