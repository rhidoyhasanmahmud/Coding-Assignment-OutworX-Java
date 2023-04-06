

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.print(fibonacci(i) + " ");
        }

    }

    public static int fibonacci(int num) {
        if (num <= 1) {
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

}

