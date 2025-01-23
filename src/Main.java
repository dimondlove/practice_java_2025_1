import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        String choice, line;
        FileProcessor fileProcessor;

        while (true) {
            System.out.println("\nВыберите команду:");
            System.out.println("1. Преобразовать все литеры файла в верхний регистр");
            System.out.println("2. Найти файлы по словам");
            System.out.println("3. Выход из программы");
            System.out.print("Ваш выбор -> ");
            choice = in.next();
            in.nextLine();

            switch (choice) {
                case "1":
                    //Пример ввода: input1.txt input2.txt output.txt
                    System.out.println("Введите как минимум один входной файл и один выходной файл через пробел");
                    line = in.nextLine();
                    fileProcessor = new UpperCaseFileProcessor(line);
                    fileProcessor.processFiles();
                    in.close();
                    return;
                case "2":
                    //Пример ввода: words.txt input1.txt input2.txt output.txt
                    System.out.println("Введите один файл со словами, как минимум один входной файл и один выходной файл через пробел");
                    line = in.nextLine();
                    fileProcessor = new WordSearchFileProcessor(line);
                    fileProcessor.processFiles();
                    in.close();
                    return;
                case "3":
                    in.close();
                    return;
                default:
                    System.out.println("Такой команды не существует");
                    break;
            }
        }

    }
}