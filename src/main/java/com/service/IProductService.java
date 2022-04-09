package com.service;

import com.model.dto.AllproductDto;
import com.model.dto.StatusDto;
import com.model.dto.TypeDto;
import com.model.entity.StatusEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public interface IProductService {

    ArrayList<AllproductDto> QueryAllproduct()throws Exception;
    ArrayList<TypeDto> QueryAlltype()throws Exception;
    ArrayList<AllproductDto> Queryproduct(HttpServletRequest request, HttpServletResponse response)throws Exception;
    ArrayList<StatusDto> queryallstatus() throws Exception;
    AllproductDto QueryEditproduct(HttpServletRequest request, HttpServletResponse response)throws Exception;
    void updataproduct(HttpServletRequest request, HttpServletResponse response)throws Exception;
    void addproduct(HttpServletRequest request, HttpServletResponse response) throws IOException;
    void delectproduct(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
