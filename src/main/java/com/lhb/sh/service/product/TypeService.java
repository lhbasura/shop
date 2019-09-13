package com.lhb.sh.service.product;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lhb.sh.model.entity.Type;
import com.lhb.sh.mapper.TypeMapper;
@Service
public class TypeService{

    @Resource
    private TypeMapper typeMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Type record) {
        return typeMapper.insert(record);
    }

    
    public int insertSelective(Type record) {
        return typeMapper.insertSelective(record);
    }

    
    public Type selectByPrimaryKey(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Type record) {
        return typeMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Type record) {
        return typeMapper.updateByPrimaryKey(record);
    }

}
