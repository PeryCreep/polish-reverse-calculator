import java.util.ArrayList;
import java.util.Scanner;

public class polish {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//Этим будет считывать
        int n = scanner.nextInt();// это читаем n
        ArrayList<String> array = new ArrayList<>(n);//тут бедем хранить все данные
        String firstcmd = "";
        boolean findFirstCmd = false;
        int result;
        

        for (int i = 0; i < n; i++) {// заполняем массив
            array.add(scanner.next());
        }
        long time = System.nanoTime();

        while (array.size() > 2) {
            for (int i = 0; i < array.size(); i++) {
                count++;
                switch (array.get(i)) {
                    case "+" -> {
                        if (!findFirstCmd) {//если это первая найденная операция
                            firstcmd = "+";
                            findFirstCmd = true;
                        }
                        result = Integer.parseInt(array.get(i - 1)) + Integer.parseInt(array.get(i - 2));
                        array.add(i, String.valueOf(result));
                        array.remove(i + 1);
                        array.remove(i - 1);
                        array.remove(i - 2);
                    }
                    case "-" -> {
                        if (!findFirstCmd) {
                            firstcmd = "-";
                            findFirstCmd = true;
                        }
                        result = Integer.parseInt(array.get(i - 1)) - Integer.parseInt(array.get(i - 2));
                        array.add(i, String.valueOf(result));
                        array.remove(i + 1);
                        array.remove(i - 1);
                        array.remove(i - 2);
                    }
                    case "*" -> {
                        if (!findFirstCmd) {
                            firstcmd = "*";
                            findFirstCmd = true;
                        }
                        result = Integer.parseInt(array.get(i - 1)) * Integer.parseInt(array.get(i - 2));
                        array.add(i, String.valueOf(result));
                        array.remove(i + 1);
                        array.remove(i - 1);
                        array.remove(i - 2);
                    }
                }
            }
        }
        if (array.size() == 2) {//если осталось всего 2 элемента значит мы должны сделать первую найденную операцию
            switch (firstcmd) {
                case "+" -> {
                    result = Integer.parseInt(array.get(0)) + Integer.parseInt(array.get(1));
                    array.add(0, String.valueOf(result));
                }
                case "-" -> {
                    result = Integer.parseInt(array.get(0)) - Integer.parseInt(array.get(1));
                    array.add(0, String.valueOf(result));
                }
                case "*" -> {
                    result = Integer.parseInt(array.get(0)) * Integer.parseInt(array.get(1));
                    array.add(0, String.valueOf(result));
                }
            }
        }

        System.out.println(array.get(0));
        time = (System.nanoTime() - time) / 1000000;
        System.out.println(time + "ms");

    }
}
