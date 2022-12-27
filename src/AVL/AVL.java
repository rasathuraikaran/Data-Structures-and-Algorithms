package AVL;

import java.net.SocketOption;

public class AVL {


    Node root;

    class Node {
        int key;
        Node left, right;
        int height;

        public Node(int val) {
            key = val;
            left = right = null;
            height = 1;


        }
    }

    public AVL(int val) {
        root = new Node(val);

    }

    public AVL() {
        root = null;
    }

    public void insert(int val) {


      root=  insert(root, val);

    }

    public int max(int a, int b) {
        if (a > b) return a;
        else return b;
    }

    public int getHeight(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    private int getBalancedFactor(Node node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }


    private Node rightRotate(Node z) {
        Node y = z.left;
        Node t3 = y.right;


        y.right = z;
        z.left = t3;
        z.height = 1 + max(getHeight(z.left), getHeight(z.right));
        y.height = 1 + max(getHeight(y.left), getHeight(y.right));

        return y;


    }




    /* Given a non-empty binary search tree, return the
    node with minimum key value found in that tree.
    Note that the entire tree does not need to be
    searched. */
    Node minValueNode(Node node)
    {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }

    private Node leftRotate(Node z){
        Node y=z.right;
        Node t3=y.left;

        y.left=z;
        z.right=t3;
        z.height = 1 + max(getHeight(z.left), getHeight(z.right));
        y.height = 1 + max(getHeight(y.left), getHeight(y.right));

        return y;


    }

    public void  inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.println(root.key+" height is "+ root.height);
            inOrder(root.right);
        }
    }
    public Node insert(Node node, int val) {
        if (node == null) {

            return new Node(val);

        }

        if (val < node.key) {


            node.left = insert(node.left, val);
        } else if (val > node.key) {
            node.right = insert(node.right, val);

        } else {
            return node;

        }
        node.height = 1 + max(getHeight(node.left), getHeight(node.right));
        int balanceFactor = getBalancedFactor(node);
        //LL case
        if (balanceFactor > 1 && val < node.left.key) {
            return rightRotate(node);


        }
        //LR case
        if (balanceFactor > 1 && val > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);


        }
        //RR case
        if (balanceFactor < -1 && val > node.right.key) {
            return leftRotate(node);

        }
        //RR case
        if (balanceFactor < -1 && val < node.right.key) {
            node.right = rightRotate(node.right);

        }
        return node;


    }
   public  Node deleteNode(Node root, int key)
    {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.key)
            root.left = deleteNode(root.left, key);

            // If the key to be deleted is greater than the
            // root's key, then it lies in right subtree
        else if (key > root.key)
            root.right = deleteNode(root.right, key);

            // if key is same as root's key, then this is the node
            // to be deleted
        else
        {

            // node with only one child or no child
            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else // One child case
                    root = temp; // Copy the contents of
                // the non-empty child
            }
            else
            {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = max(getHeight(root.left), getHeight(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balancedFactor = getBalancedFactor(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balancedFactor > 1 && getBalancedFactor(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balancedFactor > 1 &&getBalancedFactor(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balancedFactor < -1 && getBalancedFactor(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balancedFactor < -1 && getBalancedFactor(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;

        }
        if(current==null) {
            System.out.println("Failed...Value "+key+" Not found");
            return  current;
        };

        if(current.key==key) System.out.println("Sucess!...Value "+current.key+" is on the AVL treee");
       // System.out.println(current.key);

        return current;
    }

    public static void main(String args[]) {

        AVL avl = new AVL(50);
        avl.insert(20);
        avl.insert(60);
        avl.insert(10);
        avl.insert(30);
        avl.insert(40);
        avl.inOrder(avl.root);


        avl.root= avl.deleteNode(avl.root,20);
        System.out.println();
        System.out.println("deletion the value 20  is in the AVL treee");
        avl.inOrder(avl.root);
        //System.out.println(root.key);
        System.out.println("Searching the value 50 is in the AVL treee");
      Node searchExample1= avl.find(50);
        System.out.println();

        System.out.println("Searching the deleted  value 20  is in the AVL treee or not ");
        Node searchExample2= avl.find(20);

    }

}
