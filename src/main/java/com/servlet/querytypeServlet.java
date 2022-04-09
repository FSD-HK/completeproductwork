package com.servlet;

import com.model.dto.AllproductDto;
import com.model.dto.TypeDto;
import com.service.IProductService;
import com.service.ProductService;
import com.servlet.tool.EncapsulationApi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "querytypeServlet", value = "/querytypeServlet")
public class querytypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");//编码方式，在请求转发forward前不做任何输出和输出语句命名
        request.setCharacterEncoding("utf-8");
        IProductService service = new ProductService();
        ArrayList<AllproductDto> product = new ArrayList<>();
        EncapsulationApi encap = new EncapsulationApi();
        PrintWriter out=response.getWriter();
        try {
            product = service.Queryproduct(request, response);
            System.out.println(encap.ResponseAPI("查询成功",0,product));
            out.print(encap.ResponseAPI("查询成功",0,product));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
