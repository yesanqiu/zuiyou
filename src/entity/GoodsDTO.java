package entity;


public class GoodsDTO {

    //商品类别id
    private Integer goodsId;

    //商品名称
    private String goodsName;

    //商品价格
    private Double goodsPrice;

    //商品类型
    private String goodsTypeName;

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

    public GoodsDTO(Integer goodsId, String goodsName, Double goodsPrice, String goodsTypeName) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsTypeName = goodsTypeName;
    }

    public GoodsDTO() {
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }
}
