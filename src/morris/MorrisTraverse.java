package morris;

import java.util.ArrayList;
import java.util.List;

/**
 * Some methods traversing binary tree with Morris algorithm.
 */
public class MorrisTraverse {

    /**
     * A traditional method to traverse binary tree using Morris algorithm.
     *
     * <p>
     *     The Algorithm of Morris:
     *     <ul>
     *         <li>1. When current does not have left subtree, move current toward right. </li>
     *         <li>2. When current has left subtree, find the most right node under this head of
     *              left subtree, and than check whether:
     *             <ul>
     *                 <li>1) The right pointer points to null, let most right node point to
     *                      current, and move current node toward left. </li>
     *                 <li>2) The right pointer position to current, let most right node point
     *                      to null again, and move current node toward right. </li>
     *             </ul>
     *         </li>
     *     </ul>
     * </p>
     *
     * <p>
     *     It could also concluded that:
     *     <ul>
     *         <li>In 1) condition, this is the first time to move to the node
     *              which has left subtree</li>
     *         <li>In 2) condition, this is the second time to move to the node
     *              which has left subtree</li>
     *     </ul>
     * </p>
     *
     * @param head head of a binary tree
     * @return a list contains the elements traversing the binary tree
     */
    public static List<Integer> morrisTraverse(BinaryNode head) {
        List<Integer> morrisList = new ArrayList<>();

        // there is nothing in binary tree
        if (head == null) {
            return morrisList;
        }

        // a current node to traverse binary tree
        BinaryNode current = head;
        // a node represents the most right node of left subtree of current node
        BinaryNode moseRight;

        while (current != null) {
            // the head node of left subtree of current node
            moseRight = current.left;

            if (moseRight != null) {
                /*
                 there is a left node of current node, find the most right node
                 of this left sub tree.
                 e.g: when current is 1, the most right node should be 5;
                      when current is 2, the most right node should be 4;
                      when current is 3, the most right node should be 6;
                           1
                         /   \
                        2     3
                       / \   / \
                      4   5 6   7
                */
                while (moseRight.right != null && moseRight.right != current) {
                    moseRight = moseRight.right;
                }
                if (moseRight.right == null) {
                    // there is a left node on left hand side of current node
                    // and this is the first time get this node
                    moseRight.right = current;
                    morrisList.add(current.value);
                    current = current.left;
                } else {
                    // there is a left node on left hand side of current node
                    // and this is second time get this node.
                    moseRight.right = null;
                    morrisList.add(current.value);
                    current = current.right;
                }
            } else {
                // there is no left node on left hand side of current node
                morrisList.add(current.value);
                current = current.right;
            }
        }
        return morrisList;
    }

    /**
     * Traverse a binary tree with pre-order using morris algorithm
     *
     * <p>
     *     Principle:
     *     <ul>
     *         <li>The pre-order is that node in binary tree is traversed with following order:
     *         root-node -> left-node -> right-node</li>
     *         <li>
     *             Thus, we just need to add current node into arraylist when these occurred:
     *             <ul>
     *                 <li>Current node does not have left subtree</li>
     *                 <li>Current node has left subtree and current is the first time to point</li>
     *             </ul>
     *         </li>
     *     </ul>
     * </p>
     *
     * @param head head of a binary tree
     * @return a list contains the elements traversing the binary tree under pre-order
     */
    public static List<Integer> morrisPreOrder(BinaryNode head) {
        List<Integer> morrisList = new ArrayList<>();

        // there is nothing in binary tree
        if (head == null) {
            return morrisList;
        }

        // a current node to traverse binary tree
        BinaryNode current = head;
        // a node represents the most right node of left subtree of current node
        BinaryNode moseRight;

        while (current != null) {
            // the head node of left subtree of current node
            moseRight = current.left;

            if (moseRight != null) {
                /*
                 there is a left node of current node, find the most right node
                 of this left sub tree.
                 e.g: when current is 1, the most right node should be 5;
                      when current is 2, the most right node should be 4;
                      when current is 3, the most right node should be 6;
                           1
                         /   \
                        2     3
                       / \   / \
                      4   5 6   7
                */
                while (moseRight.right != null && moseRight.right != current) {
                    moseRight = moseRight.right;
                }
                if (moseRight.right == null) {
                    // there is a left node on left hand side of current node
                    // and this is the first time get this node
                    moseRight.right = current;
                    morrisList.add(current.value);
                    current = current.left;
                } else {
                    // there is a left node on left hand side of current node
                    // and this is second time get this node.
                    moseRight.right = null;
                    current = current.right;
                }
            } else {
                // there is no left node on left hand side of current node
                morrisList.add(current.value);
                current = current.right;
            }
        }
        return morrisList;
    }


    /**
     * Traverse a binary tree with in-order using morris algorithm
     *
     * <p>
     *     Principle:
     *     <ul>
     *         <li>The pre-order is that node in binary tree is traversed with following order:
     *         left-node -> root-node -> right-node</li>
     *         <li>
     *             Thus, we just need to add current node into arraylist when these occurred:
     *             <ul>
     *                 <li>Current node does not have left subtree</li>
     *                 <li>Current node has left subtree and current is the second time to point</li>
     *             </ul>
     *         </li>
     *     </ul>
     * </p>
     *
     * @param head head of a binary tree
     * @return a list contains the elements traversing the binary tree under pre-order
     */
    public static List<Integer> morrisInOrder(BinaryNode head) {
        List<Integer> morrisList = new ArrayList<>();

        // there is nothing in binary tree
        if (head == null) {
            return morrisList;
        }

        // a current node to traverse binary tree
        BinaryNode current = head;
        // a node represents the most right node of left subtree of current node
        BinaryNode moseRight;

        while (current != null) {
            // the head node of left subtree of current node
            moseRight = current.left;

            if (moseRight != null) {
                /*
                 there is a left node of current node, find the most right node
                 of this left sub tree.
                 e.g: when current is 1, the most right node should be 5;
                      when current is 2, the most right node should be 4;
                      when current is 3, the most right node should be 6;
                           1
                         /   \
                        2     3
                       / \   / \
                      4   5 6   7
                */
                while (moseRight.right != null && moseRight.right != current) {
                    moseRight = moseRight.right;
                }
                if (moseRight.right == null) {
                    // there is a left node on left hand side of current node
                    // and this is the first time get this node
                    moseRight.right = current;
                    current = current.left;
                } else {
                    // there is a left node on left hand side of current node
                    // and this is second time get this node.
                    moseRight.right = null;
                    morrisList.add(current.value);
                    current = current.right;
                }
            } else {
                // there is no left node on left hand side of current node
                morrisList.add(current.value);
                current = current.right;
            }
        }
        return morrisList;
    }


    /**
     * main function
     * @param args something input
     */
    public static void main(String[] args) {
        BinaryNode n1 = new BinaryNode(1);
        BinaryNode n2 = new BinaryNode(2);
        BinaryNode n3 = new BinaryNode(3);
        BinaryNode n4 = new BinaryNode(4);
        BinaryNode n5 = new BinaryNode(5);
        BinaryNode n6 = new BinaryNode(6);
        BinaryNode n7 = new BinaryNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(morrisTraverse(n1));
        System.out.println("pre-order of binary tree: " + morrisPreOrder(n1));
        System.out.println("in-order of binary tree: " + morrisInOrder(n1));
    }
}
