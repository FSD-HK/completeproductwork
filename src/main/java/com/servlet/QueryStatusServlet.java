package com.servlet;

import com.model.dto.StatusDto;
import com.service.IProductService;
import com.service.ProductService;
import com.servlet.tool.EncapsulationApi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "QueryStatusServlet", value = "/QueryStatusServlet")
public class QueryStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        IProductService service=new ProductService();
        ArrayList<StatusDto> statusDtos=new ArrayList<StatusDto>();
        PrintWriter out=response.getWriter();
        EncapsulationApi encap=new EncapsulationApi();
        try{
            statusDtos=service.queryallstatus();
            System.out.println(encap.ResponseAPI("查询成功",0,statusDtos));
            out.print(encap.ResponseAPI("查询成功",0,statusDtos));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
