package entity;

/**
 * 商品实体类
 */
public class Goods {

    //商品类别id
    private Integer goodsId;

    //商品名称
    private String goodsName;

    //商品价格
    private Double goodsPrice;

    //商品类型id
    private Integer goodsTypeId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public Goods() {
    }

    public Goods(Integer goodsId, String goodsName, Double goodsPrice, Integer goodsTypeId) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsTypeId = goodsTypeId;
    }
    public Goods( String goodsName, Double goodsPrice, Integer goodsTypeId) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsTypeId = goodsTypeId;
    }
}
