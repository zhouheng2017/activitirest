package com.example.activiti.identity.entity;

/**
 * 资源对象
 * @author: Henry Yan
 */
public class AiaResource {

    private String id;
    /**
     * 资源名称
     */
    private String resourceName;
    /**
     * 父资源id
     */
    private Long parentId;
    /**
     * 对资源的描述
     */
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
