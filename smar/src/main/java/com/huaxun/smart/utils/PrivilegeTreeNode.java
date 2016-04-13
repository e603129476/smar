package com.huaxun.smart.utils;

/**
 * Created by lhy on 2015-12-11.
 */
public class PrivilegeTreeNode {

    public PrivilegeTreeNode()
    {

    }

    public PrivilegeTreeNode(int id, Integer resourceId, String resourceName, String actionName, Integer actionId, String title, Integer parentId, boolean isLeaf) {
        this.id = id;
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.actionName = actionName;
        this.actionId = actionId;
        this.title = title;
        this.parentId = parentId;
        this.isLeaf = isLeaf;
    }

    private int id;

    public long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    public PrivilegeTreeNode(int id, Integer privilegeId, Integer resourceId, String resourceName, Integer actionId, String actionName, String title, Integer parentId, boolean isLeaf) {
        this.id = id;
        this.privilegeId = privilegeId;
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.actionId = actionId;
        this.actionName = actionName;
        this.title = title;
        this.parentId = parentId;
        this.isLeaf = isLeaf;
    }

    private long privilegeId;
    private Integer resourceId;
    private String resourceName;
    private Integer actionId;
    private String actionName;
    private String title;
    private Integer parentId;
    private boolean isLeaf;//是否叶子节点，叶子节点表明是权限

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
}
