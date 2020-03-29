package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Cate planete doresti sa introduci?");
        Scanner scanner = new Scanner(System.in);
        int nr = scanner.nextInt();
        Planeta[] planete = new Planeta[nr];
        for (int i = 0; i < nr; i++) {
            planete[i] = new Planeta();
            System.out.format("Introdu numele planetei %d : \n", i+1);
            scanner.nextLine();
            planete[i].nume = scanner.nextLine();
            System.out.format("Introdu coordonatele planetei %d : \n", i+1);
            System.out.println("X : ");
            planete[i].X = scanner.nextInt();
            System.out.println("Y : ");
            planete[i].Y = scanner.nextInt();
            System.out.println("Z : ");
            planete[i].Z = scanner.nextInt();
            planete[i].media = (float)(planete[i].X + planete[i].Y + planete[i].Z) / 3;
        }

        //Bubble Sort
        boolean ok = true;
        do{
            ok = false;
            for (int i = 0; i < nr-1; i++) {
                if(planete[i].media > planete[i + 1].media) {
                    Planeta temp = planete[i];
                    planete[i] = planete[i + 1];
                    planete[i + 1] = temp;
                    ok = true;
                }
            }
        }while(ok);

        Planeta closestPlanetA = new Planeta();
        Planeta closestPlanetB = new Planeta();
        Planeta furthestPlanetA = planete[0];
        Planeta furthestPlanetB = planete[nr-1];
        float min_distance = 99999;
        for (int i = 0; i < nr-1; i++) {
            if(min_distance > planete[i + 1].media - planete[i].media) {
                closestPlanetA = planete[i];
                closestPlanetB = planete[i + 1];
            }
        }

        System.out.format("Cele mai apropiate doua planete sunt %s si %s, iar cele mai indepartate doua planete sunt %s si %s", closestPlanetA.nume, closestPlanetB.nume, furthestPlanetA.nume, furthestPlanetB.nume);
    }
}
