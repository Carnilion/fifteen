package com.company;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {


        Puzzle puzzle = new Puzzle();

        puzzle.getTab()[0][0] = 15;
        puzzle.getTab()[0][1] = 11;
        puzzle.getTab()[0][2] = 7;
        puzzle.getTab()[0][3] = 3;
        puzzle.getTab()[1][0] = 14;
        puzzle.getTab()[1][1] = 10;
        puzzle.getTab()[1][2] = 6;
        puzzle.getTab()[1][3] = 1;
        puzzle.getTab()[2][0] = 13;
        puzzle.getTab()[2][1] = 9;
        puzzle.getTab()[2][2] = 5;
        puzzle.getTab()[2][3] = 2;
        puzzle.getTab()[3][0] = 12;
        puzzle.getTab()[3][1] = 8;
        puzzle.getTab()[3][2] = 4;
        puzzle.getTab()[3][3] = 0;


        Node node = new Node(puzzle);



        node.add(node);
        node.add(node);

        Node.traverseInOrder(node);


    }



}
