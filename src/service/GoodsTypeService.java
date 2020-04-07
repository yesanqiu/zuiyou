package service;

import entity.GoodsType;

import java.util.List;

/**
 * 商品类型服务接口
 */
public interface GoodsTypeService {


    /**
     * 获得所有商品类型
     * @return
     */
    List<GoodsType> getAllGoodsType();

    /**
     * 通过id获得商品
     * @param id
     * @return
     */
    GoodsType getGoodsTypeById(Integer id);

}
