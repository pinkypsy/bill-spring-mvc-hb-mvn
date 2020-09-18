package trials;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

       AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        Int ci = context.getBean("ci", Int.class);

        ci.a();

//        new Ci().a();

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