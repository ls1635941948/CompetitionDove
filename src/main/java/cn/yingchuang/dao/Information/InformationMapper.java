package cn.yingchuang.dao.Information;

import cn.yingchuang.entity.Information;

import java.util.List;

/**
 * Created by Max on 3-18-2018-018.
 */
public interface InformationMapper {

    //添加一条
    public int addInformation(Information information);

    //修改一条
    public int updateInformationById(Information information);

    //查询一条by身份证号
    public Information queryInformationByIdNumber(String idNumber);

    //查询多条
    public List<Information> queryAllInformation(List<Information> infoList);

}