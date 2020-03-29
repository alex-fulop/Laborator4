package com.company;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[10];
        int nr_elem;

        nr_elem = array.length;
        for (int i = 0; i < nr_elem; i++) {
            Random random = new Random();
            array[i] = random.nextInt(100);
        }

        int[] default_array = array;

        System.out.println("Ce optiune doresti?");
        System.out.format("- C – iniţializează tabloul de sortat cu valori generate aleator\n" +
                "- V - vizualizează tablou\n" +
                "- R - reiniţializează tabloul: pentru aducerea tabloului la forma iniţială dupa ce acesta a fost sortat, în vederea aplicării unei alte sortări\n" +
                "- I - sortare prin inserţie\n" +
                "- B - sortare prin inserţie binară\n" +
                "- S - sort.are prin selecţie\n" +
                "- T - sortare prin interschimbare\n" +
                "- H - sortare prin metoda Shakersort\n" +
                "- X - părăsirea programului\n");
        Scanner scanner = new Scanner(System.in);
        char optiune = scanner.next().charAt(0);
        boolean iesire = false;
        while(!iesire) {
            long start, end;
            double time;
            switch (optiune) {
                case 'C':
                    for (int i = 0; i < nr_elem; i++) {
                        Random random = new Random();
                        array[i] = random.nextInt(100);
                    }

                    System.out.println("Matrice a fost initializata.");
                    break;
                case 'V':
                    System.out.println("Matricea este : ");
                    for (int i = 0; i < nr_elem; i++) {
                        System.out.println("array[" + i + "]= " + array[i]);
                    }
                    break;
                case 'R':
                    array = default_array;
                    System.out.println("Matricea a fosy reinitializata");
                    break;
                case 'I':
                    start = System.nanoTime();
                    Sort.insertion_sort(array);
                    end = System.nanoTime();
                    time = (end-start)/1000000000.0;
                    System.out.format("A fost efectuata sortarea prin insertie. Timpul consumat: %.20f secunde\n", time);
                    break;
                case 'B':
                    start = System.nanoTime();
                    Sort.binary_insertion_sort(array);
                    end = System.nanoTime();
                    time = (end-start)/1000000000.0;
                    System.out.format("A fost efectuata sortarea prin insertie binara. Timpul consumat: %.20f secunde\n", time);
                    break;
                case 'S':
                    start = System.nanoTime();
                    Sort.selection_sort(array);
                    end = System.nanoTime();
                    time = (end-start)/1000000000.0;
                    System.out.format("A fost efectuata sortarea prin selectie. Timpul consumat: %.20f secunde\n", time);
                    break;
                case 'T':
                    start = System.nanoTime();
                    Sort.interchange_sort(array);
                    end = System.nanoTime();
                    time = (end-start)/1000000000.0;
                    System.out.format("A fost efectuata sortarea prin interschimbare. Timpul consumat: %.20f secunde\n", time);
                    break;
                case 'H':
                    start = System.nanoTime();
                    Sort.shaker_sort(array);
                    end = System.nanoTime();
                    time = (end-start)/1000000000.0;
                    System.out.format("A fost efectuata sortarea prin metoda Shakesort. Timpul consumat: %20f secunde\n", time);
                    break;
                case 'X':
                    System.out.println("Parasirea programului.");
                    iesire = true;
                    break;
                default:
                    System.out.println("Comanda nerecunoscuta");
                    break;
            }
            if(optiune != 'X') {
                System.out.println("Ce optiune doresti?");
                optiune = scanner.next().charAt(0);
            }
        }
    }
}
