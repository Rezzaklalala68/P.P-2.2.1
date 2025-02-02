package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Anton", "Lastname1", "user1@mail.ru").setCar(new Car("BMW", 1311231)));
      userService.add(new User("Max", "Lastname2", "user2@mail.ru").setCar(new Car("Mazda", 4413223)));
      userService.add(new User("Nikita", "Lastname3", "user3@mail.ru").setCar(new Car("Opel", 143243525)));
      userService.add(new User("Sam", "Lastname4", "user4@mail.ru").setCar(new Car("Jeep", 13255323)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }
      Optional<User> userOp = userService.findUserByCar("Audi", 1111);

      userOp.ifPresent(System.out::println);

      context.close();
   }
}
