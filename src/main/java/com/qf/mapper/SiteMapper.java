package com.qf.mapper;

import java.util.List;

import com.qf.pojo.Site;

public interface SiteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Site record);

    int insertSelective(Site record);

    Site selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Site record);

    int updateByPrimaryKey(Site record);
    
    List<Site> selectProvince();
    
    List<Site> selectCityByPro(String province);
    
    List<Site> selectCountyByCity(String city);
}