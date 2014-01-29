package com.site;

import com.site.filed.Field;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x;
        int y;
        int player = 2;

        Field field = new Field(3);
        Scanner sc = new Scanner(System.in);
        field.eraseField();

        do {
            field.showField();

            if(player == 1) {
                player = 2;
            } else {
                player = 1;
            }

            System.out.println("~~~~ PLAYER " + player + " ~~~~");
            System.out.println("Pozition on x > ");
            x = sc.nextInt();
            System.out.println("Pozition on y > ");
            y = sc.nextInt();

            field.setCellValue(x,y,player);
        } while(field.verifyWinner(player));
    }
}
