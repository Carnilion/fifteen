package com.company;

import java.util.Arrays;

public class Puzzle implements  Cloneable{

    int[][] tab = new int[4][4];

    public int[][] getTab() {
        return tab;
    }

    public void setTab(int[][] tab) {
        this.tab = tab;
    }

    public static Puzzle solution() {

        Puzzle p = new Puzzle();
        p.getTab()[0][0] = 15;
        p.getTab()[0][1] = 11;
        p.getTab()[0][2] = 7;
        p.getTab()[0][3] = 3;
        p.getTab()[1][0] = 14;
        p.getTab()[1][1] = 10;
        p.getTab()[1][2] = 0;
        p.getTab()[1][3] = 1;
        p.getTab()[2][0] = 9;
        p.getTab()[2][1] = 6;
        p.getTab()[2][2] = 5;
        p.getTab()[2][3] = 2;
        p.getTab()[3][0] = 13;
        p.getTab()[3][1] = 12;
        p.getTab()[3][2] = 8;
        p.getTab()[3][3] = 4;

        return p;
    }

    public void moveUp() {

        int k = -1, l = -1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.tab[i][j] == 0) {
                    k = i;
                    l = j;
                }
            }
        }

        if (l > 0) {
            swap(k, l - 1, k, l);
        }
    }

    public void moveDown() {

        int k = -1, l = -1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.tab[i][j] == 0) {
                    k = i;
                    l = j;
                }
            }
        }

        if (l < 3) {
            swap(k, l + 1, k, l);
        }
    }

    public void moveLeft() {

        int k = -1, l = -1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.tab[i][j] == 0) {
                    k = i;
                    l = j;
                }
            }
        }

        if (k > 0) {
            swap(k - 1, l, k, l);
        }
    }

    public void moveRight() {

        int k = -1, l = -1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.tab[i][j] == 0) {
                    k = i;
                    l = j;
                }
            }
        }

        if (k < 3) {
            swap(k + 1, l, k, l);
        }
    }


    Move lastMove = Move.EMPTY;

    public void solve() {

        int columnOfGapTile = -1, rowOfGapTile = -1;

        // set Gap tile
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.tab[i][j] == 0) {
                    columnOfGapTile = i;
                    rowOfGapTile = j;
                }
            }
        }

        //Up
        if (!this.equals(Puzzle.solution())) {
            if (rowOfGapTile > 0 && lastMove != Move.DOWN) {
                System.out.println("Up");
                moveUp();
                lastMove = Move.UP;
                print();
                solve();
            }
        }

        //Down
        if (!this.equals(Puzzle.solution())) {
            if (rowOfGapTile < 3 && lastMove != Move.UP) {
                System.out.println("Down");
                moveDown();
                lastMove = Move.DOWN;
                print();
                solve();
            }
        }

        //Left
        if (!this.equals(Puzzle.solution())) {
            if (columnOfGapTile > 0 && lastMove != Move.RIGHT) {
                System.out.println("Left");
                moveLeft();
                lastMove = Move.LEFT;
                print();
                solve();
            }
        }

        //Right
        if (!this.equals(Puzzle.solution())) {
            if (columnOfGapTile < 3 && lastMove != Move.LEFT) {
                System.out.println("Right");
                moveRight();
                lastMove = Move.RIGHT;
                print();
                solve();
            }
        }


    }

    @Override
    public Puzzle clone() throws CloneNotSupportedException{
        Puzzle puzzle = (Puzzle) super.clone();
        int[][] t = new int[4][4];

        for(int  i = 0 ; i < 4; i++){
            for(int j = 0 ; j<4 ; j++){
                t[i][j] = tab.clone()[i][j];
            }
        }

        puzzle.setTab(t);
        return puzzle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //       Puzzle puzzle = (Puzzle) o;

        boolean lastAttempt = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.getTab()[i][j] != ((Puzzle) o).getTab()[i][j]) {
                    lastAttempt = false;
                }
            }
        }
        return lastAttempt;
        //return Arrays.equals(tab, puzzle.tab);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(tab);
    }

    private void swap(int columnOfTheFirstTile, int rowOfTheFirstTile, int columnOfTheSecondTile, int rowOfTheSecondTile) {
        int o = this.tab[columnOfTheFirstTile][rowOfTheFirstTile];
        this.tab[columnOfTheFirstTile][rowOfTheFirstTile] = this.tab[columnOfTheSecondTile][rowOfTheSecondTile];
        this.tab[columnOfTheSecondTile][rowOfTheSecondTile] = o;
    }

    public void print() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(this.tab[j][i] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

}
