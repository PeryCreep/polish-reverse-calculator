import java.util.ArrayList;
import java.util.Scanner;

public class polish {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//Этим будет считывать
        int n = scanner.nextInt();// это читаем n
        ArrayList<String> array = new ArrayList<>(n);//тут бедем хранить все данные

        for (int i = 0; i< n; i++){// заполняем массив
            array.add(scanner.next());
        }


    }
}
