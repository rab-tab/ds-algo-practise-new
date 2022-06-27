package trees;

public class NodeLevel {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        System.out.println("level of data 5 is  " + getLevel(root, 1, 5));
        System.out.println("level of data 4 is  " + getLevel(root, 1, 4 ));

    }

    public static int getLevel(Node node, int level, int data) {

        if (node == null) return 0;
        if (node.data == data) return level;
        int downLevel = getLevel(node.left, level + 1, data);
        if (downLevel != 0)
            return downLevel;
        downLevel = getLevel(node.right, level + 1, data);
        return downLevel;


    }


}
