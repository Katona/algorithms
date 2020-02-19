package minimaltree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import tree.Node;

public class MinimalTreeTest {

    @Test
    public void testMinimalTreeBasic() {
        MinimalTree minimalTree = new MinimalTree();
        Node root = minimalTree.create(new int[] {1, 2, 3});
        assertEquals(2, root.value);
        assertEquals(1, root.left.value);
        assertEquals(3, root.right.value);
    }

    @Test
    public void testMinimalTreeComplex() {
        MinimalTree minimalTree = new MinimalTree();
        Node root = minimalTree.create(new int[] {1, 2, 3, 4});
        assertEquals(3, root.value);
        assertEquals(2, root.left.value);
        assertEquals(1, root.left.left.value);
        assertNull(root.left.right);
        assertEquals(4, root.right.value);
        assertNull(root.right.left);
        assertNull(root.right.right); 
    }
}