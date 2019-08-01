package com.lhb.sh.service.product;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lhb.sh.mapper.SkuMapper;
import com.lhb.sh.model.Sku;
@Service
public class SkuService{

    @Resource
    private SkuMapper skuMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return skuMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Sku record) {
        return skuMapper.insert(record);
    }

    
    public int insertSelective(Sku record) {
        return skuMapper.insertSelective(record);
    }

    
    public Sku selectByPrimaryKey(Integer id) {
        return skuMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Sku record) {
        return skuMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Sku record) {
        return skuMapper.updateByPrimaryKey(record);
    }

}
