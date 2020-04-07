package test;

import entity.Goods;
import service.GoodsService;
import service.impl.GoodsServiceImpl;
import util.JDBCConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

    public static void main(String[] args) {
        GoodsService goodsService = new GoodsServiceImpl();
        Goods goods = new Goods(14,null,3.00,null);
        System.out.println(goodsService.updateGoods(goods));

    }
}
