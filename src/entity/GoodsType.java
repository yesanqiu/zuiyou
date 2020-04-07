package entity;

/**
 * 商品类别实体类
 */
public class GoodsType {
    //
    //商品类别id
    private Integer goodsTypeId;

    //商品类别名称
    private String goodsTypeName;

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }

    public GoodsType() {
    }

    public GoodsType(Integer goodsTypeId, String goodsTypeName) {
        this.goodsTypeId = goodsTypeId;
        this.goodsTypeName = goodsTypeName;
    }
}
