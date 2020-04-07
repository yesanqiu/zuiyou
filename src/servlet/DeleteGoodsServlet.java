package servlet;

import entity.Goods;
import net.sf.json.JSONObject;
import service.GoodsService;
import service.impl.GoodsServiceImpl;
import util.MyJsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteGoodsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("连接上了");
        req.setCharacterEncoding("UTF-8");
        Integer goodsId = Integer.valueOf(req.getParameter("goodsId"));
        //初始化
        GoodsService goodsService = new GoodsServiceImpl();
        int r = goodsService.removeGoods(goodsId);
        JSONObject jsonObject = new JSONObject();
        resp.setContentType("text/json; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if(r == 1) {
            resp.sendRedirect("./index.html");
        }else {
            resp.getWriter().print(jsonObject.fromObject(new MyJsonObject(500, "失败", null)));
        }
    }
}
