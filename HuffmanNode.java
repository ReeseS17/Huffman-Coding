package student;
//Reese Saladin

public class HuffmanNode {
    /**
     * The zero child of this HuffmanNode.
     */
    private HuffmanNode zero;
    /**
     * the one child of this HuffmanNode.
     */
    private HuffmanNode one;
    /**
     * this node's data.
     */
    private Character data;

    /**
     * A constructor that makes a non-leaf node, with two children and null data.
     * @param zero - the HuffmanNode zero child of this node.
     * @param one - the HuffmanNode one child of this node.
     */
    public HuffmanNode(HuffmanNode zero, HuffmanNode one) {
        this.zero = zero;
        this.one = one;
        data = null;
    }

    /**
     * A constructor that makes a leaf node, with null children and given data.
     * @param data - a char to be stored as this node's data.
     */
    public HuffmanNode(char data) {
        this.data = data;
        this.zero = null;
        this.one = null;
    }

    /**
     * Gets the zero child of this node.
     * @return - a HuffmanNode representing this node's zero child.
     */
    public HuffmanNode getZero() {
        return zero;
    }

    /**
     * Sets the zero child of this node.
     * @param zero - a HuffmanNode that this node's zero child will be set to.
     */
    public void setZero(HuffmanNode zero) {
        this.zero = zero;
    }

    /**
     * Gets the one child of this node.
     * @return - a HuffmanNode representing this node's one child.
     */
    public HuffmanNode getOne() {
        return one;
    }

    /**
     * Sets the one child of this node.
     * @param one - a HuffmanNode that this node's one child will be set to.
     */
    public void setOne(HuffmanNode one) {
        this.one = one;
    }

    /**
     * Gets this node's data.
     * @return - a Character that is this node's data.
     */
    public Character getData() {
        return data;
    }

    /**
     * Sets this node's data.
     * @param data - a char that this node's data will be set to.
     */
    public void setData(char data) {
        this.data = data;
    }

    /**
     * Determines if this node is a leaf.
     * @return - boolean true if this node is a leaf, and has no children. False otherwise.
     */
    public boolean isLeaf() {
        return data != null && one == null && zero == null;
    }

    /**
     * Determines if this node is a valid node for HuffmanCodeTree.
     * @return - boolean true of this node is a leaf with no children, or an internal node with children and no data.
     * Boolean false otherwise.
     */
    public boolean isValidNode() {
        if (isLeaf()) {
            return true;
        } else {
            return data == null && one != null && zero != null;
        }
    }

    /**
     * Determines if this node, and all descendants, are valid nodes.
     * @return - boolean true if this and all descendant nodes are valid, false otherwise.
     */
    public boolean isValidTree() {
        if (isValidNode()) {
            if (isLeaf()) {
                return true;
            } else {
                return zero.isValidTree() && one.isValidTree();
            }
        }
        return false;
    }

}
