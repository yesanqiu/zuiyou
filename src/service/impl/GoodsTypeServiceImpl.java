package service.impl;

import entity.GoodsType;
import service.GoodsTypeService;
import util.JDBCConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {

    private JDBCConnector connector;

    /**
     * 获得所有商品类型
     * @return
     */
    @Override
    public List<GoodsType> getAllGoodsType() {

        List<GoodsType> goodsTypes = new ArrayList<>();

        //要执行的sql
        String sql = "select * from  goods_type";

        //初始化连接类
        connector = new JDBCConnector();
        //连接数据库
        connector.connect();

        //执行查询
        try {
            ResultSet resultSet = connector.getConnection().prepareStatement(sql).executeQuery();
            while (resultSet.next()){
                goodsTypes.add(new GoodsType(resultSet.getInt(1),resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //释放数据库连接
        connector.close();
        return goodsTypes;
    }

    @Override
    public GoodsType getGoodsTypeById(Integer id) {

        GoodsType goodsType = new GoodsType();
        //要执行的sql
        String sql = "select * from  goods_type where goods_type_id = ?";

        //初始化连接类
        connector = new JDBCConnector();
        //连接数据库
        connector.connect();

        //执行查询
        try {
            PreparedStatement ps = connector.getConnection().prepareStatement(sql);
            ps.setObject(1,id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                goodsType = new GoodsType(resultSet.getInt(1),resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //释放数据库连接
        connector.close();
        return goodsType;
    }
}
