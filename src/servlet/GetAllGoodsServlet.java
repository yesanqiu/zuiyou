package servlet;

import entity.Goods;
import entity.GoodsDTO;
import net.sf.json.JSONObject;
import service.GoodsService;
import service.GoodsTypeService;
import service.impl.GoodsServiceImpl;
import service.impl.GoodsTypeServiceImpl;
import util.MyJsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getAllGoods")
public class GetAllGoodsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("连接上了");
        //初始化
        GoodsService goodsService = new GoodsServiceImpl();
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        List<GoodsDTO> goodsDTOS = new ArrayList<>();
        for (Goods g:goodsService.getAllGoods()){
            goodsDTOS.add(new GoodsDTO(g.getGoodsId(),g.getGoodsName(),g.getGoodsPrice(),goodsTypeService.getGoodsTypeById(g.getGoodsTypeId()).getGoodsTypeName()));
        }
        JSONObject jsonObject = new JSONObject();
        resp.setContentType("text/json; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(jsonObject.fromObject(new MyJsonObject(200,"成功",goodsDTOS)));
    }
}
