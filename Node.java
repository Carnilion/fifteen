package com.company;

public class Node {

    Move move;
    Puzzle puz;

    Node left;
    Node right;
    Node up;
    Node down;

    Node(Puzzle puz) {
        this.puz = puz;
        left = null;
        right = null;
        up = null;
        down = null;
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

    public static void add(Node root) throws CloneNotSupportedException {
        if (root != null) {
            add(root.up);
            add(root.down);
            add(root.left);
            add(root.right);
            Puzzle puzzleLeft = root.puz.clone();
            Puzzle puzzleRight = root.puz.clone();
            Puzzle puzzleUp = root.puz.clone();
            Puzzle puzzleDown = root.puz.clone();
            puzzleLeft.moveLeft();
            puzzleRight.moveRight();
            puzzleDown.moveDown();
            puzzleUp.moveUp();
            if (root.left == null && !puzzleLeft.equals(root.puz) && isNotRepeated(root, puzzleLeft)) { //nie dziala bo sprawdzamy powtorzenia tylko od miejsca wystapienia, nie od korzenia, czyli sprawdzamy z synami
                root.left = new Node(puzzleLeft);
            }
            if (root.right == null && !puzzleRight.equals(root.puz) && isNotRepeated(root, puzzleRight)) {
                root.right = new Node(puzzleRight);
            }
            if (root.up == null && !puzzleUp.equals(root.puz) && isNotRepeated(root, puzzleUp)) {
                root.up = new Node(puzzleUp);
            }
            if (root.down == null && !puzzleDown.equals(root.puz) && isNotRepeated(root, puzzleDown)) {
                root.down = new Node(puzzleDown);
            }

        }
    }

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
}
