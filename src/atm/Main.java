package atm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int balance = readInt(sc, "초기 잔액을 입력하세요: ");

        while (true) {
            System.out.println("\n======================");
            System.out.println("현재 잔액: " + balance + "원");
            System.out.println("1. 입금");
            System.out.println("2. 출금");
            System.out.println("0. 종료");
            System.out.println("======================");

            int menu = readInt(sc, "메뉴 번호를 입력하세요: ");

            // 종료 조건 1) menu == 0
            if (menu == 0) {
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }

            if (menu == 1) {
                // 입금
                int money = readPositiveInt(sc, "입금할 금액을 입력하세요: ");
                balance += money;
                System.out.println("입금 완료! 현재 잔액: " + balance + "원");

            } else if (menu == 2) {
                // 출금
                int money = readPositiveInt(sc, "출금할 금액을 입력하세요: ");

                // 예외 조건: 잔액 부족
                if (money > balance) {
                    System.out.println("잔액이 부족합니다.");
                } else {
                    balance -= money;
                    System.out.println("출금 완료! 현재 잔액: " + balance + "원");
                }

            } else {
                // 잘못된 메뉴
                System.out.println("잘못된 입력입니다.");
            }

            // 종료 조건 2) balance == 0
            if (balance == 0) {
                System.out.println("잔액이 0원이 되어 프로그램을 종료합니다.");
                break;
            }
        }

        sc.close();
    }

    // 정수 입력 받기 (예외 처리 포함)
    private static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력하세요.");
                sc.nextLine(); // 잘못 입력된 토큰 제거
            }
        }
    }

    // 1 이상 양의 정수 입력 받기
    private static int readPositiveInt(Scanner sc, String message) {
        while (true) {
            int value = readInt(sc, message);
            if (value > 0) return value;
            System.out.println("1 이상의 금액을 입력하세요.");
        }
    }
}
