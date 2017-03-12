package Task02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  Класс описывает дерево
 */
public class MyLittleTree {

    private Node top;
    private long idCounter = 0;

    public MyLittleTree() {
        idCounter++;
        top = new Node(idCounter);
    }

    /**
     * Добавить узел к другому узлу
     * @param parent узел к которому добавляем потомка
     * */
    public void addNode(Node parent) {
        if (parent == null) {
            throw new NullPointerException("Add node to null-parent");
        }

        idCounter++;
        parent.getChildren().add(new Node(idCounter));
    }

    private void printNode(Node node) {
        System.out.print(node.getId());

        if (node.getChildren().size() > 0) {
            System.out.print(" ( ");
        }

        Iterator<Node> iter = node.getChildren().iterator();
        while (iter.hasNext()) {
            Node child = iter.next();
            printNode(child);

            if (iter.hasNext()) {
                System.out.print(", ");
            }
        }


        if (node.getChildren().size() > 0) {
            System.out.print(" )");
        }

    }

    /**
     * Вывод дерева в консоль
     * */
    public void printTree() {
        printNode(top);
    }

    /**
     * Удаляет узел с указанным id
     * @return Узел который удалили или null если узел не найден
     * */
    public Node removeNodeById(long id) {
        if (top.getId() == id) {
            throw new IllegalArgumentException("Can't remove top node!");
        }

        return removeNode(top, id);

    }

    private Node removeNode(Node parent, long id) {
        if (parent == null) {
            throw new IllegalArgumentException();
        }

        Iterator<Node> iterator = parent.getChildren().iterator();

        while (iterator.hasNext()) {
            Node nextNode = iterator.next();

            if (nextNode.getId() == id) {
                iterator.remove();
                return nextNode;
            } else {
                Node found = removeNode(nextNode, id);
                if (found != null) {
                    return found;
                }
            }
        }

        return null;
    }

    public Node getTop() {
        return top;
    }

    private Node getNode(Node start, long id) {
        if (start == null) {
            throw new IllegalArgumentException("Null start node");
        }

        if (start.getId() == id) {
            return start;
        } else {
            for (Node node : start.getChildren()) {
                Node found = getNode(node, id);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    /**
     * Получить узел по id
     **/
    public Node getNodeById(long id) {
        return getNode(top, id);
    }


    /**
     *  Класс описывающий узел дерева
     * */
    public static class Node {
        private long id;
        private List<Node> children;

        public Node(long id) {
            this.id = id;
            children = new ArrayList<>();
        }

        public List<Node> getChildren() {
            return children;
        }

        public long getId() {
            return id;
        }
    }


    public static void main(String[] args) {
        MyLittleTree tree = new MyLittleTree();
        Node top = tree.getTop();

        tree.addNode(top);
        tree.addNode(top);

        tree.addNode(tree.getNodeById(2));
        tree.addNode(tree.getNodeById(2));

        tree.addNode(tree.getNodeById(3));
        tree.addNode(tree.getNodeById(3));

        tree.printTree();

        tree.removeNodeById(10);
        System.out.println("\nRemove node 10");
        tree.printTree();

    }
}
