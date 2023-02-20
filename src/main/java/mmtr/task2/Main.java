package mmtr.task2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        Scanner scanner = new Scanner(System.in);

        Dictionary dictionary = context.getBean("dictionary", Dictionary.class);

        dictionary.createFiles();
        while (true) {
            BusinessChecks.printMenu();

            int command = scanner.nextInt();

            if (command == 1) {
                dictionary.readFiles();
            } else if (command == 2) {
                dictionary.add();
            } else if (command == 3) {
                dictionary.remove();
            } else if (command == 4) {
                dictionary.get();
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Неопознанная команда");
            }
        }
    }

}
