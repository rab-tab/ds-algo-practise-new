package trees.views;

import trees.Node;

public class Pair<T, T1> {
    Node node;
    Integer dist;

    public Pair(Node node, Integer dist) {
        this.node = node;
        this.dist = dist;
    }
}
