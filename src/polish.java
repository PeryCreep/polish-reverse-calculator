import java.util.ArrayList;
import java.util.Scanner;

public class polish {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//Этим будет считывать
        int n = scanner.nextInt();// это читаем n
        ArrayList<String> array = new ArrayList<>(n);//тут бедем хранить все данные
        int result;

        for (int i = 0; i < n; i++) {// заполняем массив
            array.add(scanner.next());
        }
        float time = System.nanoTime();

        while (array.size() != 1) {
            for (int i = 0; i < array.size(); i++) {
                switch (array.get(i)) {
                    case "+" -> {
                        result = Integer.parseInt(array.get(i - 2)) + Integer.parseInt(array.get(i - 1));
                        array.add(i, String.valueOf(result));
                        array.remove(i + 1);
                        array.remove(i - 1);
                        array.remove(i - 2);
                        i -= 2;
                    }
                    case "-" -> {
                        result = Integer.parseInt(array.get(i - 2)) - Integer.parseInt(array.get(i - 1));
                        array.add(i, String.valueOf(result));
                        array.remove(i + 1);
                        array.remove(i - 1);
                        array.remove(i - 2);
                        i -= 2;
                    }
                    case "*" -> {
                        result = Integer.parseInt(array.get(i - 2)) * Integer.parseInt(array.get(i - 1));
                        array.add(i, String.valueOf(result));
                        array.remove(i + 1);
                        array.remove(i - 1);
                        array.remove(i - 2);
                        i -= 2;
                    }
                }
            }
        }

        System.out.println(array.get(0));
        time = (System.nanoTime() - time)/1000000;
        System.out.println(time + "ms");
    }
}
