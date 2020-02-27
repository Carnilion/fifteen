package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, IOException {


        Puzzle puzzle = new Puzzle();

        // we set the initial configuration
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
        Node solutionWhichFind;
        Puzzle finishSolution = Node.shufflePuzzle(node.puz);

        solutionWhichFind = FindSolution.viewSolution(puzzle, finishSolution, node);

        // optional, to see what is happening in the console
        {
            System.out.println("initial configuration: ");
            puzzle.print();
            if (puzzle.isSolvable()) {
                System.out.println("solution: ");
                solutionWhichFind.puz.print();
            }
            System.out.println();
        }

        WriteToFile.saveToFile(puzzle, solutionWhichFind);

        // optional, to see what is happening in the console
        {
            System.out.println("list of moves: ");
            for (Move move : Node.listOfMoves) {
                System.out.println(move);
            }
        }
    }
}