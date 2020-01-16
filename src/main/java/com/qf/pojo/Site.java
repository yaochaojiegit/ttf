package com.qf.pojo;

public class Site {
    private Integer id;

    private String province;

    private String city;

    private String county;

    public Site() {
		super();
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

	@Override
	public String toString() {
		return "Site [id=" + id + ", province=" + province + ", city=" + city + ", county=" + county + "]";
	}
    
}