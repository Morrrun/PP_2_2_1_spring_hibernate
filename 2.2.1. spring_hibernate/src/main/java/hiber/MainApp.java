package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        User userOne = new User("Mikhail", "Alexsandrov", "mifon@mail.ru");
        User userTwo = new User("Sergei", "Ostafiev", "serj@mail.ru");
        User userThree = new User("Nikolay", "Smirnov", "kolyan@mail.ru");

        Car carOne = new Car("Lada Priora", 33010);
        Car carTwo = new Car("UAZ Patriot", 440998);
        Car carThree = new Car("Lada Baklajan", 33020);


        userOne.setUserCar(carOne);
        userTwo.setUserCar(carTwo);
        userThree.setUserCar(carThree);

        userService.add(userOne);
        userService.add(userTwo);
        userService.add(userThree);

        User userTest;

        //Проверяем по первой машине
        userTest = userService.getUserOnCar("UAZ Patriot", 440998);

        System.out.println("------------------------------------------");
        System.out.println("Id = " + userTest.getId());
        System.out.println("First Name = " + userTest.getFirstName());
        System.out.println("Last Name = " + userTest.getLastName());
        System.out.println("Email = " + userTest.getEmail());
        System.out.println(userTest.getUserCar());
        System.out.println("------------------------------------------");

        //Проверяем по второй машине
        userTest = userService.getUserOnCar("Lada Priora", 33010);

        System.out.println("------------------------------------------");
        System.out.println("Id = " + userTest.getId());
        System.out.println("First Name = " + userTest.getFirstName());
        System.out.println("Last Name = " + userTest.getLastName());
        System.out.println("Email = " + userTest.getEmail());
        System.out.println(userTest.getUserCar());
        System.out.println("------------------------------------------");

        //Проверяем по третьей машине
        userTest = userService.getUserOnCar("Lada Baklajan", 33020);

        System.out.println("------------------------------------------");
        System.out.println("Id = " + userTest.getId());
        System.out.println("First Name = " + userTest.getFirstName());
        System.out.println("Last Name = " + userTest.getLastName());
        System.out.println("Email = " + userTest.getEmail());
        System.out.println(userTest.getUserCar());
        System.out.println("------------------------------------------");

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getUserCar());
         System.out.println();
      }

        context.close();
    }
}
