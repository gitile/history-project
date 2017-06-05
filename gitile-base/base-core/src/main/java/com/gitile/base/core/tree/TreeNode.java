package com.gitile.base.core.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树结构
 *
 */
public class TreeNode implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String parentId;  
    private String selfId;  
    protected Object obj;  
    protected TreeNode parentNode;  
    protected List<TreeNode> childList;  
  
	public TreeNode() {  
        initChildList();  
    }  
  
    public TreeNode(TreeNode parentNode) {  
        this.getParentNode();  
        initChildList();  
    }  
  
    public boolean isLeaf() {  
        if (childList == null) {  
            return true;  
        } else {  
            if (childList.isEmpty()) {  
                return true;  
            } else {  
                return false;  
            }  
        }  
    }  
  
    /* 插入一个child节点到当前节点中 */  
    public void addChildNode(TreeNode treeNode) {  
        initChildList();  
        childList.add(treeNode);  
    }  
  
    public void initChildList() {  
        if (childList == null)  
            childList = new ArrayList<TreeNode>();  
    }  
  
    public boolean isValidTree() {  
        return true;  
    }  
  
    /* 返回当前节点的父辈节点集合 */  
    public List<TreeNode> getElders() {  
        List<TreeNode> elderList = new ArrayList<TreeNode>();  
        TreeNode parentNode = this.getParentNode();  
        if (parentNode == null) {  
            return elderList;  
        } else {  
            elderList.add(parentNode);  
            elderList.addAll(parentNode.getElders());  
            return elderList;  
        }  
    }  
  
    /* 返回当前节点的晚辈集合 */  
    public List<TreeNode> getJuniors() {  
        List<TreeNode> juniorList = new ArrayList<TreeNode>();  
        List<TreeNode> childList = this.getChildList();  
        if (childList == null) {  
            return juniorList;  
        } else {  
            int childNumber = childList.size();  
            for (int i = 0; i < childNumber; i++) {  
                TreeNode junior = childList.get(i);  
                juniorList.add(junior);  
                juniorList.addAll(junior.getJuniors());  
            }  
            return juniorList;  
        }  
    }  
  
    /* 返回当前节点的孩子集合 */  
    public List<TreeNode> getChildList() {  
        return childList;  
    }  
  
    /* 删除节点和它下面的晚辈 */  
    public void deleteNode() {  
        TreeNode parentNode = this.getParentNode();  
        String id = this.getSelfId();  
        if (parentNode != null) {  
            parentNode.deleteChildNode(id);  
        }  
    }  
  
    /* 删除当前节点的某个子节点 */  
    public void deleteChildNode(String childId) {  
        List<TreeNode> childList = this.getChildList();  
        int childNumber = childList.size();  
        for (int i = 0; i < childNumber; i++) {  
            TreeNode child = childList.get(i);  
            if (child.getSelfId().equals(childId)) {  
                childList.remove(i);  
                return;  
            }  
        }  
    }  
  
    /* 动态的插入一个新的节点到当前树中 */  
    public boolean insertJuniorNode(TreeNode treeNode) {  
        String juniorParentId = treeNode.getParentId();  
        if (this.parentId == juniorParentId) {  
            addChildNode(treeNode);  
            return true;  
        } else {  
            List<TreeNode> childList = this.getChildList();  
            int childNumber = childList.size();  
            boolean insertFlag;  
  
            for (int i = 0; i < childNumber; i++) {  
                TreeNode childNode = childList.get(i);  
                insertFlag = childNode.insertJuniorNode(treeNode);  
                if (insertFlag == true)  
                    return true;  
            }  
            return false;  
        }  
    }  
  
    /* 找到一颗树中某个节点 */  
    public TreeNode findTreeNodeById(String id) {  
        if (this.selfId.equals(id))  
            return this;  
        if (childList.isEmpty() || childList == null) {  
            return null;  
        } else {  
            int childNumber = childList.size();  
            for (int i = 0; i < childNumber; i++) {  
                TreeNode child = childList.get(i);  
                TreeNode resultNode = child.findTreeNodeById(id);  
                if (resultNode != null) {  
                    return resultNode;  
                }  
            }  
            return null;  
        }  
    }  
  
    /* 遍历一棵树，层次遍历 */  
    public void traverse() {  
        if (selfId==null)  
            return;
        System.out.println(this.selfId);
        if (childList == null || childList.isEmpty())  
            return;  
        int childNumber = childList.size();  
        for (int i = 0; i < childNumber; i++) {  
            TreeNode child = childList.get(i);  
            child.traverse();  
        }  
    }

    public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getSelfId() {
		return selfId;
	}

	public void setSelfId(String selfId) {
		this.selfId = selfId;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public TreeNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(TreeNode parentNode) {
		this.parentNode = parentNode;
	}

	public void setChildList(List<TreeNode> childList) {
		this.childList = childList;
	}

}
