package Util;

import java.util.Scanner;

public class InputUtil {

	private static Scanner scanner = new Scanner(System.in);

	// 文字列の入力
	public static String inputString(String message) {

		System.out.print(message);

		return scanner.nextLine();
	}

	// 数字入力
	public static int inputInt(String message) {

		while (true) {

			try {

				System.out.print(message);

				return Integer.parseInt(scanner.nextLine());

			} catch (NumberFormatException e) {

				System.out.println("数字を入力してください。");
			}
		}
	}
}