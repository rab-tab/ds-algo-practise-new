package trees.views;

import trees.Node;

public class Pair<T, T1> {
    public Node node;
    public Integer dist;

    public Pair(Node node, Integer dist) {
        this.node = node;
        this.dist = dist;
    }
}
