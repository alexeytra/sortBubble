package com.example.sortBubble.controllers;

import com.example.sortBubble.ArrayBubble;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

@Controller
public class ViewStoredArrayController {
    int[] array;

    @GetMapping("/array")
    public String generateArray(Model model) {
        int a = (int) (1 +  Math.random() * 8 );
        array = new int[a];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ( 1 + Math.random() * 10 );
        }

        Arrays.stream(array).forEach(System.out::print);
        model.addAttribute("array", Arrays.toString(array));
        model.addAttribute("sortedArray","[]");
        return "viewArray";
    }

    @GetMapping("/sort")
    public String sortArray(Model model) {
        ArrayBubble<Integer> arrayBubble = new ArrayBubble<Integer>(Arrays.stream(array).boxed().toArray(Integer[]::new));
        arrayBubble.bubbleSort(Comparator.reverseOrder());
        model.addAttribute("array", Arrays.toString(array));
        model.addAttribute("sortedArray", Arrays.toString(arrayBubble.getArray()));

        return "sortedArray";
    }

}
