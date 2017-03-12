package Task02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Тест дерева
 */
public class MyLittleTreeTest {
    private MyLittleTree testedInstance = new MyLittleTree();

    @Before
    public void initTree() {
        MyLittleTree.Node top = testedInstance.getTop();

        testedInstance.addNode(top);
        testedInstance.addNode(top);

        testedInstance.addNode(testedInstance.getNodeById(2));
        testedInstance.addNode(testedInstance.getNodeById(2));

        testedInstance.addNode(testedInstance.getNodeById(3));
        testedInstance.addNode(testedInstance.getNodeById(3));
    }

    @Test
    public void testGetNodeById() {
        assertTrue(testedInstance.getNodeById(2).getId() == 2);
    }

    @Test(expected = NullPointerException.class)
    public void testGetNonExistentNodeReturnNull() {
        testedInstance.getNodeById(10).getId();
    }

    @Test
    public void testAddNode() {
        MyLittleTree.Node secondNode = testedInstance.getNodeById(2);
        int childrenCount = secondNode.getChildren().size();
        testedInstance.addNode(secondNode);
        assertTrue(secondNode.getChildren().size() == ++childrenCount);
    }

    @Test
    public void testRemoveNode() {
        assertTrue(testedInstance.getNodeById(3) != null);
        testedInstance.removeNodeById(3);
        assertTrue(testedInstance.getNodeById(3) == null);
    }
}
