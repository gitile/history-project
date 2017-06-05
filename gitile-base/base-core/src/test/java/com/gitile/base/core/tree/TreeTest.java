package com.gitile.base.core.tree;

public class TreeTest {

	public static void main(String[] args) {
		
		TreeHelper help = new TreeHelper();
		TreeNode root = new TreeNode();
		root.setSelfId("A001");
		root.setParentId("");
		help.addTreeNode(root);
		
		TreeNode node1 = new TreeNode();
		node1.setSelfId("A001B001");
		node1.setParentId("A001");
		help.addTreeNode(node1);
		
		TreeNode node2 = new TreeNode();
		node2.setSelfId("A001B002");
		node2.setParentId("A001");
		help.addTreeNode(node2);
		
		TreeNode node3 = new TreeNode();
		node3.setSelfId("A001B001C001");
		node3.setParentId("A001B001");
		help.addTreeNode(node3);
		
		help.generateTree();
		root.traverse();
	}

}
