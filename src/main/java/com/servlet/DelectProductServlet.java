package com.servlet;

import com.model.dto.AllproductDto;
import com.service.IProductService;
import com.service.ProductService;
import com.servlet.tool.EncapsulationApi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "DelectProductServlet", value = "/DelectProductServlet")
public class DelectProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");//编码方式，在请求转发forward前不做任何输出和输出语句命名
        request.setCharacterEncoding("utf-8");
        IProductService Service=new ProductService();
        ArrayList<AllproductDto> product=new ArrayList<>();
        PrintWriter out=response.getWriter();
        EncapsulationApi encap=new EncapsulationApi();
        try{
            Service.delectproduct(request, response);
            product=Service.QueryAllproduct();
            System.out.println(encap.ResponseAPI("删除操作成功",0,product));
            out.println(encap.ResponseAPI("删除操作成功",0,product));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
