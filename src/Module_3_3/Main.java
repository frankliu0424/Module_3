package Module_3_3;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Main {
        public static ArrayList<Node> graph;//Graph of the nodes
        private static final Queue<Integer> vQ = new LinkedList<>();//"vQ" represents "visitingQueue"

        public static void main(String[] args) throws FileNotFoundException {
            setupGraph();
            BFS();
        }

        private static void BFS() {
            //If vQ is empty, check if twe haven't started OR if we have finished traversing
            if (vQ.isEmpty()) {
                Node root = graph.get(0); //Assuming the first element in the graph is the root
                if (root.isVisited()) {
                    System.out.println("Finished traversing");
                    return;
                } else {
                    vQ.add(root.getKey());
                }
            }

            Integer currentKey = vQ.poll();
            if (currentKey == null) {
                System.out.println("Current node is null, should never happen");
                return;
            }
            Node currentNode = graph.get(currentKey - 1); //Adjusting for 0-based index
            currentNode.setVisited(true);

            for (Integer cNK : currentNode.getConnectedNodes()) {//"cNK" represents connectedNodeKey
                if (vQ.contains(cNK) || graph.get(cNK - 1).isVisited()) {
                    continue;
                }
                vQ.add(cNK);
            }

            System.out.println("Queue contents: " + vQ);
            BFS();
        }

        private static void setupGraph() throws FileNotFoundException {
            graph = new ArrayList<>();
            Scanner scan = new Scanner(new File("graph.txt"));//Name of the graph file
            while (scan.hasNext()) {
                String line = scan.nextLine();
                parseLine(line);
            }
            scan.close();
        }

        private static void parseLine(String line) {
            String[] keys = line.split(" ");
            int key = Integer.parseInt(keys[0]);
            ArrayList<Integer> cNK = new ArrayList<>();//Again, "cNK" represents connectedNodeKey
            for (int i = 1; i < keys.length; i++) {
                cNK.add(Integer.parseInt(keys[i]));
            }
            graph.add(new Node(key, cNK));
        }
}


