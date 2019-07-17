package com.lhb.sh.service.product;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lhb.sh.model.Product;
import com.lhb.sh.mapper.ProductMapper;
@Service
public class ProductService{

    @Resource
    private ProductMapper productMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    
    public int insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    
    public Product selectByPrimaryKey(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }

}
