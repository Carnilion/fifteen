package com.company;

import java.util.Arrays;

public class Puzzle implements Cloneable {

    public static final int SIZE_OF_MATRIX = 4;
    int[][] tab = new int[SIZE_OF_MATRIX][SIZE_OF_MATRIX];
    public int[][] getTab() {
        return tab;
    }

    public void setTab(int[][] tab) {
        this.tab = tab;
    }


    /**
     * the function checks the solvability of a given configuration
     * @return
     */
    public boolean isSolvable(){
        int countInversions = 0;
        int[] tiles = new int[SIZE_OF_MATRIX * SIZE_OF_MATRIX];

        int pozitonInTheTile = 0;
        for (int i=0;i<SIZE_OF_MATRIX;i++){
            for (int j=0;j<SIZE_OF_MATRIX;j++){
                tiles[pozitonInTheTile] = tab[j][i];
                pozitonInTheTile++;
            }
        }

        for (int i = 0; i < SIZE_OF_MATRIX * SIZE_OF_MATRIX-1; i++) {
            for (int j = 0; j < i; j++) {
                if (tiles[j] > tiles[i])
                    countInversions++;
            }
        }
        return countInversions % 2 == 0;
    }

    /**
     * each movement function changes the configuration by a given movement
     */
    public void moveUp() {

        int k = -1, l = -1;

        for (int i = 0; i < SIZE_OF_MATRIX; i++) {
            for (int j = 0; j < SIZE_OF_MATRIX; j++) {
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

        for (int i = 0; i < SIZE_OF_MATRIX; i++) {
            for (int j = 0; j < SIZE_OF_MATRIX; j++) {
                if (this.tab[i][j] == 0) {
                    k = i;
                    l = j;
                }
            }
        }

        if (l < SIZE_OF_MATRIX - 1) {
            swap(k, l + 1, k, l);
        }
    }
    public void moveLeft() {

        int k = -1, l = -1;

        for (int i = 0; i < SIZE_OF_MATRIX;  i++) {
            for (int j = 0; j < SIZE_OF_MATRIX; j++) {
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

        for (int i = 0; i < SIZE_OF_MATRIX; i++) {
            for (int j = 0; j < SIZE_OF_MATRIX; j++) {
                if (this.tab[i][j] == 0) {
                    k = i;
                    l = j;
                }
            }
        }

        if (k < SIZE_OF_MATRIX - 1) {
            swap(k + 1, l, k, l);
        }
    }

    @Override
    public Puzzle clone() throws CloneNotSupportedException {
        Puzzle puzzle = (Puzzle) super.clone();
        int[][] newCloneMatrix = new int[SIZE_OF_MATRIX][SIZE_OF_MATRIX];

        for (int i = 0; i < SIZE_OF_MATRIX; i++) {
            for (int j = 0; j < SIZE_OF_MATRIX; j++) {
                newCloneMatrix[i][j] = tab.clone()[i][j];
            }
        }

        puzzle.setTab(newCloneMatrix);
        return puzzle;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //       Puzzle puzzle = (Puzzle) o;

        boolean lastAttempt = true;
        for (int i = 0; i < SIZE_OF_MATRIX; i++) {
            for (int j = 0; j < SIZE_OF_MATRIX; j++) {
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
    public void swap(int columnOfTheFirstTile, int rowOfTheFirstTile, int columnOfTheSecondTile, int rowOfTheSecondTile) {
        int temporaryValue = this.tab[columnOfTheFirstTile][rowOfTheFirstTile];
        this.tab[columnOfTheFirstTile][rowOfTheFirstTile] = this.tab[columnOfTheSecondTile][rowOfTheSecondTile];
        this.tab[columnOfTheSecondTile][rowOfTheSecondTile] = temporaryValue;
    }
    public void print() {
        for (int i = 0; i < SIZE_OF_MATRIX; i++) {
            for (int j = 0; j < SIZE_OF_MATRIX; j++) {
                System.out.print(this.tab[j][i] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

}