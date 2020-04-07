package servlet;

import entity.Goods;
import net.sf.json.JSONObject;
import service.GoodsService;
import service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateGoodsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("连接上了");
        req.setCharacterEncoding("UTF-8");
        Integer goodsId = Integer.valueOf(req.getParameter("goodsId"));
        String goodsName = req.getParameter("goodsName");
        Double goodsPrice;
        if(!req.getParameter("goodsPrice").equals("")) {
            goodsPrice = Double.valueOf(req.getParameter("goodsPrice"));
        }else{
            goodsPrice = null;
        }
        Integer goodsTypeId = Integer.valueOf(req.getParameter("goodsTypeId"));
        //初始化
        GoodsService goodsService = new GoodsServiceImpl();
        int r = goodsService.updateGoods(new Goods(goodsId,goodsName,goodsPrice,goodsTypeId));
        JSONObject jsonObject = new JSONObject();
        resp.setContentType("text/json; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if(r == 1) {
            resp.sendRedirect("./index.html");
        }else {
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().print("<html><body><script type='text/javascript'>alert('修改失败！');</script></body></html>");
        }
    }
}
