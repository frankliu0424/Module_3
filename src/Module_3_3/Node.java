package Module_3_3;

import java.util.ArrayList;
import java.util.List;

/**
* Represents a node in a graph with a unique key, a list of connected nodes, and a visited status.
*/
public class Node {
    private int key;
    //List of keys representing nodes connected to this node
    private List<Integer> connectedNodes;
    //Check if the node has been visited
    private boolean visited;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
    public List<Integer> getConnectedNodes() {
            return connectedNodes;
    }
    public void setConnectedNodes(List<Integer> connectedNodes) {
        this.connectedNodes = connectedNodes;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Constructs a new Node with a specified key and list of connected nodes.
     * @param key The unique key of the node
     * @param connectedNodes The list of keys representing nodes connected to the node
     */
    public Node(int key, ArrayList<Integer> connectedNodes){
        this.key = key;
        this.connectedNodes = connectedNodes;
    }

    @Override
    public int hashCode() {
        return key;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Module_3_3.Node){
            Module_3_3.Node other = (Module_3_3.Node)obj;
            return this.key == other.key;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Node: " + key;
    }
}



