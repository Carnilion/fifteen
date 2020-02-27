package com.company;

public class ArchiwumClass {

    //once used functions, now redundant
/*
    public void solve() {

        int columnOfGapTile = -1, rowOfGapTile = -1;

        // set Gap tile
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
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
            if (rowOfGapTile < tab[0].length && lastMove != Move.UP) {
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
            if (columnOfGapTile < tab.length && lastMove != Move.LEFT) {
                System.out.println("Right");
                moveRight();
                lastMove = Move.RIGHT;
                print();
                solve();
            }
        }


    }

    public Node add(Node current, Move move) throws CloneNotSupportedException {
        if (current == null) {
            return new Node(current.puz);
        }

        Puzzle p = current.puz.clone();

        if (move == Move.UP) {
            p.moveUp();
            if (!p.equals(current.puz)) {
                current.up = new Node(p); //addRecursive(current.up, ); //new Node(p);
            }
        }
        if (move == Move.DOWN) {
            p.moveDown();
            if (!p.equals(current.puz)) {
                current.down = new Node(p);
            }
        }
        if (move == Move.LEFT) {
            p.moveLeft();
            if (!p.equals(current.puz)) {
                current.left = new Node(p);
            }
        }
        if (move == Move.RIGHT) {
            p.moveRight();
            if (!p.equals(current.puz)) {
                current.right = new Node(p);
            }
        }


        return current;
    }

    public static void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.up);
            traverseInOrder(node.down);
            traverseInOrder(node.left);
            traverseInOrder(node.right);
            node.puz.print();

        }
    }

    public static Puzzle solution() {

        Puzzle puzzle = new Puzzle();

        // final solution
//        puzzle.getTab()[0][0] = 1;
//        puzzle.getTab()[0][1] = 5;
//        puzzle.getTab()[0][2] = 9;
//        puzzle.getTab()[0][3] = 13;
//        puzzle.getTab()[1][0] = 2;
//        puzzle.getTab()[1][1] = 6;
//        puzzle.getTab()[1][2] = 10;
//        puzzle.getTab()[1][3] = 14;
//        puzzle.getTab()[2][0] = 3;
//        puzzle.getTab()[2][1] = 7;
//        puzzle.getTab()[2][2] = 11;
//        puzzle.getTab()[2][3] = 15;
//        puzzle.getTab()[3][0] = 4;
//        puzzle.getTab()[3][1] = 8;
//        puzzle.getTab()[3][2] = 12;
//        puzzle.getTab()[3][3] = 0;

        // solution after 13 moves
//        puzzle.getTab()[0][0] = 11;
//        puzzle.getTab()[0][1] = 10;
//        puzzle.getTab()[0][2] = 7;
//        puzzle.getTab()[0][3] = 3;
//        puzzle.getTab()[1][0] = 15;
//        puzzle.getTab()[1][1] = 6;
//        puzzle.getTab()[1][2] = 5;
//        puzzle.getTab()[1][3] = 1;
//        puzzle.getTab()[2][0] = 14;
//        puzzle.getTab()[2][1] = 9;
//        puzzle.getTab()[2][2] = 2;
//        puzzle.getTab()[2][3] = 4;
//        puzzle.getTab()[3][0] = 13;
//        puzzle.getTab()[3][1] = 12;
//        puzzle.getTab()[3][2] = 8;
//        puzzle.getTab()[3][3] = 0;

        // close to beginnning
        puzzle.getTab()[0][0] = 15;
        puzzle.getTab()[0][1] = 11;
        puzzle.getTab()[0][2] = 0;
        puzzle.getTab()[0][3] = 7;
        puzzle.getTab()[1][0] = 14;
        puzzle.getTab()[1][1] = 10;
        puzzle.getTab()[1][2] = 6;
        puzzle.getTab()[1][3] = 3;
        puzzle.getTab()[2][0] = 13;
        puzzle.getTab()[2][1] = 9;
        puzzle.getTab()[2][2] = 5;
        puzzle.getTab()[2][3] = 1;
        puzzle.getTab()[3][0] = 12;
        puzzle.getTab()[3][1] = 8;
        puzzle.getTab()[3][2] = 4;
        puzzle.getTab()[3][3] = 2;


        return puzzle;
    }

    //sprawdza czy jest powtorzenie puzzli od wezla w dol po wzystkich jego potomnach (nie w gore)
    public static boolean isNotRepeated(Node node, Puzzle puzz) {

        if (node != null) {
            if (node.puz.equals(puzz)) {
                return false;
            }
            isNotRepeated(node.right, puzz);
            isNotRepeated(node.left, puzz);
            isNotRepeated(node.up, puzz);
            isNotRepeated(node.down, puzz);
        }
        return true;
    }
*/


}
