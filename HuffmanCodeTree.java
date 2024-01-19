package student;
//Reese Saladin

import provided.BinarySequence;

public class HuffmanCodeTree {
    /**
     * A HuffmanNode that stores this HuffmanCodeTree's root node.
     */
    private HuffmanNode root;

    /**
     * A constructor that creates a HuffmanCodeTree with provided Node as root.
     * @param root
     */
    public HuffmanCodeTree(HuffmanNode root) {
        this.root = root;
    }

    /**
     * A constructor that creates a HuffmanCodeTree using all elements in codeBook.
     * @param codeBook - a HuffmanCodeBook that HuffmanCodeTree uses the data of to make tree.
     */
    public HuffmanCodeTree(HuffmanCodeBook codeBook) {
        root = new HuffmanNode(null, null);
        int index = codeBook.getIndex();
        for (int i = 0; i < index; i++) {
            this.put(codeBook.getVals(i), codeBook.getChar(i));
        }
    }

    /**
     * Determines if the given HuffmanCodeTree, including root and all descendants, is valid.
     * @return - boolean true if HuffmanCodeTree is valid, false otherwise.
     */
    public boolean isValid() {
        return root.isValidTree();
    }

    /**
     * Modifies the binary tree structure so that the node accessed via BinarySequence traversal
     * stores the corresponding char.
     * @param seq - the BinarySequence to be traversed, and the corresponding BinarySequence of char letter.
     * @param letter - char that corresponds to given BinarySequence seq, and what the Node's data will hold.
     */
    public void put(BinarySequence seq, char letter) {
        HuffmanNode currNode = root;
        for (int i = 0; i < seq.size(); i++) {
            if (seq.get(i)) {
                if (currNode.getOne() == null) {
                    currNode.setOne(new HuffmanNode(null, null));
                }
                currNode = currNode.getOne();
            } else {
                if (currNode.getZero() == null) {
                    currNode.setZero(new HuffmanNode(null, null));
                }
                currNode = currNode.getZero();
            }
        }
        currNode.setData(letter);
    }

    /**
     * Decodes a BinarySequence into its corresponding string.
     * @param s - BinarySequence to be decoded into corresponding string.
     * @return - a String that represents the BinarySequence decoded.
     */
    public String decode(BinarySequence s) {
        StringBuilder str = new StringBuilder();
        HuffmanNode node = root;
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i)) {
                node = node.getOne();
            } else {
                node = node.getZero();
            }
            if (node.isLeaf()) {
                str.append(node.getData());
                node = root;
            }
        }
        return str.toString();
    }
}
