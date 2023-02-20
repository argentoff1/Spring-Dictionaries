package mmtr.task2;

public class BusinessChecks {
    static void printChoose() {
        System.out.println("С каким словарем вы хотите работать?" +
                "\n1 - С английского на русский" +
                "\n2 - С немецкого на русский");
    }

    static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Просмотреть содержимое обоих словарей");
        System.out.println("2 - Добавить запись в один из словарей");
        System.out.println("3 - Удалить запись в одном из словарей");
        System.out.println("4 - Найти запись по ключу");
        System.out.println("0 - Выход");
    }
}
