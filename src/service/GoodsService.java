package service;

import entity.Goods;

import java.util.List;

/**
 * 商品服务接口
 */
public interface GoodsService {

    /**
     * 获得所有商品
     * @return
     */
    List<Goods> getAllGoods();

    /**
     * 添加商品
     * @param goods
     * @return
     */
    int addGoods(Goods goods);

    /**
     * 移除商品
     * @param goodsId
     * @return
     */
    int removeGoods(int goodsId);


    /**
     * 修改商品
     * @param goods
     * @return
     */
    int updateGoods(Goods goods);
}
