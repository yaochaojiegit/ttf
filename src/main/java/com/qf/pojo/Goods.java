package com.qf.pojo;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Goods {
    private Integer id;

    private String name;//名称

    private Date pubdate;//入库时间

    private String picture;//图片地址

    private Integer price;//价格
    
    private Integer star;//评星

    private Integer typeid;//种类id
    
    private String type;//种类

    private String intro;//备注
    
    private Integer status;//商品状态  0 删除  1.上架

    private String gdate;//时间

    private Integer number;//数目


    public Goods( String name, Integer typeid, int price, int star, String gdate,
			String picture,String intro) {
		super();
		this.name = name;
		this.gdate = gdate;
		this.picture=picture;
		this.price = price;
		this.star =  star;
		this.intro = intro;
		this.typeid = typeid;
	}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGdate() {
		return gdate;
	}

	public void setGdate(String gdate) {
		this.gdate = gdate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Goods() {
		super();
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
    private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Date getPubdate() {

        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.gdate=format.format(pubdate);
        this.pubdate = pubdate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

 

    public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", pubdate=" + pubdate + ", picture=" + picture + ", price="
				+ price + ", star=" + star + ", typeid=" + typeid + ", type=" + type + ", intro=" + intro + ", status="
				+ status + ", gdate=" + gdate + "]";
	}


}