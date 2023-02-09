
import java.util.*;
import static service.WordsCounterService.*;
public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printHello();
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            topOfWords();
                            break;
                        case 2:
                            total();
                            break;
                        case 0:
                            break label;
                        default:
                            System.out.println("unknown menu item!");
                    }
                } else {
                    scanner.next();
                    System.out.println("Select a menu item from the list!");
                }
            }
        }
    }
}