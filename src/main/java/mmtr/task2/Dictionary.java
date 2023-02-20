package mmtr.task2;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class Dictionary {
    private Map<String, String> fromEnglish = new HashMap();
    private Map<String, String> fromDeutsch = new HashMap();
    static Scanner scanner = new Scanner(System.in);
    private final File fromEnglishFile = new File("From Eng.txt");
    private final File fromDeutschFile = new File("From Deu.txt");
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    public void createFiles() throws IOException {
        if (!fromEnglishFile.exists())
            fromEnglishFile.createNewFile();
        if (!fromDeutschFile.exists())
            fromDeutschFile.createNewFile();
    }

    public void readFiles() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(fromEnglishFile));
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }
        bufferedReader = new BufferedReader(new FileReader(fromDeutschFile));
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }
    }

    public void add() throws IOException {
        BusinessChecks.printChoose();
        int choose = scanner.nextInt();
        if (choose == 1) {
            bufferedWriter = new BufferedWriter(new FileWriter(fromEnglishFile));
            System.out.println("Введите слово из четырех букв на английском языке");
            String key = scanner.next();
            if (key.length() != 4) {
                System.out.println("Ошибка! Вы ввели слово не из четырех букв");
                return;
            }
            System.out.println("Введите перевод слова из пяти букв на русском языке");
            String value = scanner.next();
            if (value.length() != 5) {
                System.out.println("Ошибка! Вы ввели слово не из пяти букв");
                return;
            }
            fromEnglish.put(key, value);
            bufferedWriter.write(String.valueOf(fromEnglish));
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } else if (choose == 2) {
            bufferedWriter = new BufferedWriter(new FileWriter(fromDeutschFile));
            System.out.println("Введите слово из четырех букв на немецком языке");
            String key = scanner.next();
            if (key.length() != 4) {
                System.out.println("Ошибка! Вы ввели слово не из четырех букв");
                return;
            }
            System.out.println("Введите перевод слова из пяти букв на русском языке");
            String value = scanner.next();
            if (value.length() != 5) {
                System.out.println("Ошибка! Вы ввели слово не из пяти букв");
                return;
            }
            fromDeutsch.put(key, value);
            bufferedWriter.write(String.valueOf(fromDeutsch));
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } else {
            System.out.println("Неопознанная команда");
        }
    }

    public void remove() {
        BusinessChecks.printChoose();
        int choose = scanner.nextInt();
        if (choose == 1) {
            System.out.println("Введите слово на английском языке, которое вы хотите удалить");
            String key = scanner.next();
            fromEnglish.remove(key);
            System.out.println("Запись успешно удалена");
        } else if (choose == 2) {
            System.out.println("Введите слово на немецком языке, которое вы хотите удалить");
            String key = scanner.next();
            fromDeutsch.remove(key);
            System.out.println("Запись успешно удалена");
        } else {
            System.out.println("Неопознанная команда");
        }
    }

    public void get() {
        BusinessChecks.printChoose();
        int choose = scanner.nextInt();
        if (choose == 1) {
            System.out.println("Введите слово на английском языке, которое вы хотите найти");
            String key = scanner.next();
            System.out.println(fromEnglish.get(key));
        } else if (choose == 2) {
            System.out.println("Введите слово на немецком языке, которое вы хотите найти");
            String key = scanner.next();
            System.out.println(fromDeutsch.get(key));
        } else {
            System.out.println("Неопознанная команда");
        }
    }

}
