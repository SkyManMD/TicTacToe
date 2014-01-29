package com.site.filed;

public class Field {
    private final int FIELD_SIZE;
    private static final char DEFAULT_VALUE = ' ';
    private static final char PLAYER_1_SYMBOL = 'X';
    private static final char PLAYER_2_SYMBOL = 'O';
    private char SYMBOL_FOR_VERIFY_WIN;
    private char[][] field;
    private int numberOfSymbols;

    public Field(int size) {  //in constructor putem initializa variabilile de tip final; se recomanda ca memoria pentru array sa fie alocata in constructor;
        FIELD_SIZE = size;
        field = new char[FIELD_SIZE][FIELD_SIZE];
    }

    public void eraseField() {
        for (int i=0; i<FIELD_SIZE; i++){
            for (int j=0; j<FIELD_SIZE; j++) {
                field[i][j] = DEFAULT_VALUE;
            }
        }
    }

    public void showField() {
        System.out.println();
        for (int i=0; i<FIELD_SIZE; i++){
            for (int j=0; j<FIELD_SIZE; j++) {
                System.out.print("[" + field[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setCellValue(int i, int j, int player) {
        if(i > FIELD_SIZE || i < 0 || j > FIELD_SIZE || j < 0) {
            System.out.println("Incorect position. Play the next player!");
            return;
        }

        if(field[i][j] != DEFAULT_VALUE) {
            System.out.println("This cell is not empty. Play the next player!");
            return;
        }


        if(player == 1) {
            field[i][j] = PLAYER_1_SYMBOL;
        } else {
            field[i][j] = PLAYER_2_SYMBOL;
        }
    }

    public boolean verifyWinner(int player) {
        if(player == 1) {
            SYMBOL_FOR_VERIFY_WIN = PLAYER_1_SYMBOL;
        } else {
            SYMBOL_FOR_VERIFY_WIN = PLAYER_2_SYMBOL;
        }

        //verificare cistigator pe fiecare rind;
        for (int i = 0; i < FIELD_SIZE; i++) {
            numberOfSymbols=0;
            for(int j = 0; j < FIELD_SIZE; j++) {
                if(field[i][j] == SYMBOL_FOR_VERIFY_WIN) {
                    numberOfSymbols++;
                }
            }
            if(numberOfSymbols == FIELD_SIZE) {
                showField();
                System.out.println("PLAYER " + player + " WIN [on row " + i + "]");
                return false;
            }
        }
        //verificare cistigator pe fiecare colana;
        for (int j = 0; j < FIELD_SIZE; j++) {
            numberOfSymbols=0;
            for(int i = 0; i < FIELD_SIZE; i++) {
                if(field[i][j] == SYMBOL_FOR_VERIFY_WIN) {
                    numberOfSymbols++;
                }
            }
            if(numberOfSymbols == FIELD_SIZE) {
                showField();
                System.out.println("PLAYER " + player + " WIN [on column " + j + "]");
                return false;
            }
        }

        //verificare cistigaor pe diagonala principala;
        numberOfSymbols = 0;
        for (int i=0; i < FIELD_SIZE; i++) {
            if(field[i][i] == SYMBOL_FOR_VERIFY_WIN) {
                numberOfSymbols++;
            }
        }
        if(numberOfSymbols == FIELD_SIZE) {
            showField();
            System.out.println("PLAYER " + player + " WIN [on main diagonal]");
            return false;
        }

        //verificare cistigator pe diagonala secundara;
        numberOfSymbols = 0;
        for(int i = 0; i < FIELD_SIZE; i++) {
            if(field[i][(FIELD_SIZE-1)-i] == SYMBOL_FOR_VERIFY_WIN) {
                numberOfSymbols++;
            }
        }

        if(numberOfSymbols == FIELD_SIZE) {
            showField();
            System.out.println("PLAYER " + player + " WIN [on secondary diagonal]");
            return false;
        }

        return verifyEquality();
    }

    public boolean verifyEquality() {
        numberOfSymbols = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            for(int j = 0; j < FIELD_SIZE; j++) {
                if(field[i][j] == ' ') {
                    numberOfSymbols++;
                }
            }
        }
        if(numberOfSymbols == 0) {
            showField();
            System.out.println("EQALITY!");
            return false;
        } else {
            return true;
        }
    }

}
