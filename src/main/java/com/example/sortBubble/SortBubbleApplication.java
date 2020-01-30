package com.example.sortBubble;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.Scanner;

@SpringBootApplication
public class SortBubbleApplication {


	public static void main(String[] args) {
		System.out.print("Ввод массива >> ");
		Scanner sc = new Scanner(System.in);
		String scString = sc.nextLine();
		String[] scStrings = scString.split("\\s+");
		Integer[] array = new Integer[scStrings.length];


		try {
			for (int i = 0; i < scStrings.length; i++)
				array[i] = Integer.parseInt(scStrings[i]);
		}catch (NumberFormatException e) {
			System.out.println("[ERROR] Только числа");
		}

		ArrayBubble<Integer> arrayBubble = new ArrayBubble(array);

		arrayBubble.printArray();
		arrayBubble.bubbleSort(Comparator.reverseOrder());
		arrayBubble.printArray();

		arrayBubble.storeIntoDB();


		SpringApplication.run(SortBubbleApplication.class, args);
	}

}
