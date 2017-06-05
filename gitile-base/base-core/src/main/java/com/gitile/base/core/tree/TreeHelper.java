package com.gitile.base.core.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 树操作帮助工具
 */
public class TreeHelper {

    private TreeNode root;
    private List<TreeNode> tempNodeList;
    private boolean isValidTree = true;

    public TreeHelper() {
    }

    public TreeHelper(List<TreeNode> treeNodeList) {
    	setTempNodeList(treeNodeList);
        generateTree();
    }

    public static TreeNode getTreeNodeById(TreeNode tree, String id) {
        if (tree == null)
            return null;
        TreeNode treeNode = tree.findTreeNodeById(id);
        return treeNode;
    }

    /** generate a tree from the given treeNode or entity list */
    public void generateTree() {
        HashMap<String, TreeNode> nodeMap = putNodesIntoMap();
        putChildIntoParent(nodeMap);
    }

    /**
     * put all the treeNodes into a hash table by its id as the key
     * 
     * @return hashmap that contains the treenodes
     */
    protected HashMap<String, TreeNode> putNodesIntoMap() {
        HashMap<String, TreeNode> nodeMap = new HashMap<String, TreeNode>();
        Iterator<TreeNode> it = tempNodeList.iterator();
        while (it.hasNext()) {
            TreeNode treeNode = (TreeNode) it.next();
            String keyId = treeNode.getSelfId();
            nodeMap.put(keyId, treeNode);
        }
        return nodeMap;
    }

    /**
     * set the parent nodes point to the child nodes
     * 
     * @param nodeMap a hashmap that contains all the treenodes by its id as the key
     */
    protected void putChildIntoParent(HashMap<String, TreeNode> nodeMap) {
        Iterator<?> it = nodeMap.values().iterator();
        while (it.hasNext()) {
            TreeNode treeNode = (TreeNode) it.next();
            String parentId = treeNode.getParentId();
            String parentKeyId = String.valueOf(parentId);
            if (nodeMap.containsKey(parentKeyId)) {
                TreeNode parentNode = (TreeNode) nodeMap.get(parentKeyId);
                if (parentNode == null) {
                    this.isValidTree = false;
                    return;
                } else {
                    parentNode.addChildNode(treeNode);
                }
            }
        }
    }

    /** add a tree node to the tempNodeList */
    public void addTreeNode(TreeNode treeNode) {
        if (this.tempNodeList == null) {
            this.tempNodeList = new ArrayList<TreeNode>();
        }
        this.tempNodeList.add(treeNode);
    }

    /**
     * insert a tree node to the tree generated already
     * 
     * @return show the insert operation is ok or not
     */
    public boolean insertTreeNode(TreeNode treeNode) {
        boolean insertFlag = root.insertJuniorNode(treeNode);
        return insertFlag;
    }

    public boolean isValidTree() {
        return this.isValidTree;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public List<TreeNode> getTempNodeList() {
        return tempNodeList;
    }

    public void setTempNodeList(List<TreeNode> tempNodeList) {
        this.tempNodeList = tempNodeList;
    }

}
