package com.qf.pojo;

public class GoodsType {
    private Integer id;

    private String name;

    private Integer level;

    private Integer parent;
    
    private Integer status;
    
    private Integer isparent;

    public GoodsType() {
		super();
	}

	public Integer getIsparent() {
		return isparent;
	}

	public void setIsparent(Integer isparent) {
		this.isparent = isparent;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", name=" + name + ", level=" + level + ", parent=" + parent + ", status="
				+ status + ", isparent=" + isparent + "]";
	}


	
}