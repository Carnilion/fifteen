public class FindSolution {

    /**
     * At the input we give the initial configuration, the final configuration and the node which contains the initial configuration.
     * At the output we get references to the final configuration if the program finds it in the process of adding more nodes
     *
     * @param puzzle
     * @param finishSolution
     * @param node
     * @return
     * @throws CloneNotSupportedException
     */
    public static Node viewSolution(Puzzle puzzle, Puzzle finishSolution, Node node) throws CloneNotSupportedException {
        Node solutionWhichFind = null;
        if (puzzle.isSolvable()) {
            boolean run = true;
            while (run) {
                Node.nodeList.removeAll(Node.temporaryNode);
                for (Node n : Node.nodeList) {
                    // decide if program should print every configuration
                    // n.puz.print();
                    if (finishSolution.equals(n.puz)) {
                        run = false;
                        solutionWhichFind = n;
                    }
                }
                if (run) {
                    Node.temporaryNode.addAll(Node.nodeList);
                    node.add(node);
                }
            }
        }
        return solutionWhichFind;
    }

}
