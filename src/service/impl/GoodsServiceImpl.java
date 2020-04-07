package service.impl;

import entity.Goods;
import entity.GoodsType;
import service.GoodsService;
import util.JDBCConnector;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * 商品服务实现类
 */
public class GoodsServiceImpl implements GoodsService {

    private JDBCConnector connector;

    /**
     * 获得所有商品
     * @return
     */
    @Override
    public List<Goods> getAllGoods() {
        //声明商品list
        List<Goods> goods = new ArrayList<>();
        //要执行的sql
        String sql = "select * from  goods";

        //初始化连接类
        connector = new JDBCConnector();
        //连接数据库
        connector.connect();

        //执行查询
        try {
            ResultSet resultSet = connector.getConnection().prepareStatement(sql).executeQuery();
            while (resultSet.next()){
                goods.add(new Goods(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //释放数据库连接
        connector.close();
        return goods;
    }

    @Override
    public int addGoods(Goods goods) {

        //要执行的sql
        String sql = "insert into goods(goods_name,goods_price,goods_type_id)values(?,?,?)";

        //初始化连接类
        connector = new JDBCConnector();
        //连接数据库
        connector.connect();

        int rs = 0;

        try {
            PreparedStatement ps = connector.getConnection().prepareStatement(sql);
            ps.setObject(1,goods.getGoodsName());
            ps.setObject(2,goods.getGoodsPrice());
            ps.setObject(3,goods.getGoodsTypeId());
            rs = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //释放数据库连接
        connector.close();
        return rs;
    }

    @Override
    public int removeGoods(int goodsId) {

        //要执行的sql
        String sql = "delete from goods where goods_id = ?";

        //初始化连接类
        connector = new JDBCConnector();
        //连接数据库
        connector.connect();

        int rs = 0;

        try {
            PreparedStatement ps = connector.getConnection().prepareStatement(sql);
            ps.setObject(1,goodsId);
            rs = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //释放数据库连接
        connector.close();
        return rs;
    }

    @Override
    public int updateGoods(Goods goods) {
        //要执行的sql
        List<String> methods = new ArrayList<>();
        String sql = "update goods set";
        //判断要修改的元素来拼接sql
        if(goods.getGoodsName()!= null){
            if(sql.substring(sql.length() -1).equals("t")){
                sql += " goods_name = ?";
            }else{
                sql += ",goods_name = ?";
            }
            methods.add("getGoodsName");
        }
        if(goods.getGoodsPrice() != null){
            if(sql.substring(sql.length() -1).equals("t")){
                sql += " goods_price = ?";
            }else{
                sql += ",goods_price = ?";
            }
            methods.add("getGoodsPrice");
        }
        if(goods.getGoodsTypeId() != null){
            if(sql.substring(sql.length() -1).equals("t")){
                sql += " goods_type_id = ?";
            }else{
                sql += ",goods_type_id = ?";
            }
            methods.add("getGoodsTypeId");
        }
        //若不用修改直接返回
        if( goods.getGoodsName()== null && goods.getGoodsPrice() == null && goods.getGoodsTypeId() == null){
            return 0;
        }
        sql += " where goods_id = ?";
        System.out.println("sql :" + sql);
        //初始化连接类
        connector = new JDBCConnector();
        //连接数据库
        connector.connect();

        int rs = 0;
        try {
            PreparedStatement ps = connector.getConnection().prepareStatement(sql);
            Class<?> clazz = Class.forName("entity.Goods");
            int i = 1;
            for(String method:methods){
                Method m = clazz.getMethod(method);
                ps.setObject(i,m.invoke(goods));
                i++;
            }
            ps.setObject(i,goods.getGoodsId());
            rs = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //释放数据库连接
        connector.close();
        return rs;
    }
}
