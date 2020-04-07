package servlet;

import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import org.apache.commons.beanutils.ConvertUtils;
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

@WebServlet(value = "/getAllGoodsType")
public class GetAllGoodsTypeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("连接上了");
        //初始化
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        JSONObject jsonObject = new JSONObject();
        resp.setContentType("text/json; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(jsonObject.fromObject(new MyJsonObject(200,"成功",goodsTypeService.getAllGoodsType())));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
