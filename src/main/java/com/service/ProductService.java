package com.service;

import com.dao.*;
import com.db.HibernateSessionFactory;
import com.model.dto.AllproductDto;
import com.model.dto.StatusDto;
import com.model.dto.TypeDto;
import com.model.entity.ProductEntity;
import com.model.entity.StatusEntity;
import com.model.entity.TypeEntity;
import com.servlet.tool.EncapsulationApi;
import org.hibernate.Transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductService implements IProductService {

    public ArrayList<AllproductDto> QueryAllproduct()throws Exception {
        HibernateSessionFactory.getSession();//可以不写
        QueryDao dao = new QueryDao();//查产品信息表
        ArrayList<AllproductDto> responselist = new ArrayList<AllproductDto>();
        try {
            ArrayList<ProductEntity> list = dao.allproductDtoArrayList();
            datadictionary datadictionary = new datadictionary();//数据字典
            datadictionary.loaddictionary();
            HashMap<String, HashMap<String, String>> hashMap = com.dao.datadictionary.hashMap;

            for (int i = 0; i < list.size(); i++) {
                AllproductDto dto = new AllproductDto();
                dto.setIndex((i + 1));
                dto.setProductkey(list.get(i).getProductkey());
                dto.setProductid(list.get(i).getProductid());
                dto.setProductname(list.get(i).getProductname());
                dto.setTypeid(list.get(i).getType().getTypeid());
                dto.setTypename(list.get(i).getType().getTypename());
                dto.setVendordemain(list.get(i).getVendordemain());
                dto.setManufacturers(list.get(i).getManufacturers());
                dto.setQuantity(list.get(i).getQuantity());
                dto.setPrice(list.get(i).getPrice());
                dto.setStatusid(list.get(i).getStatusid());
                HashMap<String, String> hashMap1 = hashMap.get("StatusEntity");
                dto.setStatusname(hashMap1.get(list.get(i).getStatusid()));

                responselist.add(dto);
            }
            HibernateSessionFactory.closeSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responselist;
    }
    public AllproductDto QueryEditproduct(HttpServletRequest request, HttpServletResponse response)throws Exception{
        takeaxiosparams takeparams = new takeaxiosparams();
        Map<String, Object> params = takeparams.params(request, response);
        System.out.println(params);
        String productid = (String) params.get("productid");
        QueryDao dao=new QueryDao();
        ProductEntity product=new ProductEntity();
        AllproductDto productDto=new AllproductDto();
        try{
            product= dao.queryappointproduct(productid);
            HashMap<String, HashMap<String, String>> hashMap = com.dao.datadictionary.hashMap;
            productDto.setIndex(1);
            productDto.setProductkey(product.getProductkey());
            productDto.setProductid(product.getProductid());
            productDto.setProductname(product.getProductname());
            productDto.setTypeid(product.getType().getTypeid());
            productDto.setTypename(product.getType().getTypename());
            productDto.setVendordemain(product.getVendordemain());
            productDto.setManufacturers(product.getManufacturers());
            productDto.setQuantity(product.getQuantity());
            productDto.setPrice(product.getPrice());
            productDto.setStatusid(product.getStatusid());
            HashMap<String, String> hashMap1 = hashMap.get("StatusEntity");
            productDto.setStatusname(hashMap1.get(product.getStatusid()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return productDto;
    }
    public ArrayList<TypeDto> QueryAlltype()throws Exception{
        HibernateSessionFactory.getSession();//可以不写
        QueryDao dao = new QueryDao();//查产品信息表
        ArrayList<TypeDto> responselist = new ArrayList<TypeDto>();
        try{
            ArrayList<TypeEntity> typelist=dao.querytype();
            for(TypeEntity item: typelist){
                TypeDto typeDto=new TypeDto();
                typeDto.setTypeid(item.getTypeid());
                typeDto.setTypename(item.getTypename());
                responselist.add(typeDto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return responselist;
    }
    public ArrayList<AllproductDto> Queryproduct(HttpServletRequest request, HttpServletResponse response)throws Exception{
        takeaxiosparams takeparams = new takeaxiosparams();
        Map<String, Object> params = takeparams.params(request, response);
        System.out.println(params);
        String productname = (String) params.get("productname");
        String typeid = (String) params.get("typeid");
        Double price1 = Double.valueOf(params.get("price1").toString());
        Double price2 = Double.valueOf(params.get("price2").toString());
        HibernateSessionFactory.getSession();//可以不写
        ArrayList<AllproductDto> querylist=new ArrayList<AllproductDto>();
        try{
            QueryDao dao=new QueryDao();
            ArrayList<ProductEntity> list=dao.queryproductArrayList(productname,typeid,price1,price2);
            HashMap<String, HashMap<String, String>> hashMap = com.dao.datadictionary.hashMap;
            for (int i = 0; i < list.size(); i++) {
                AllproductDto dto = new AllproductDto();
                dto.setIndex((i + 1));
                dto.setProductkey(list.get(i).getProductkey());
                dto.setProductid(list.get(i).getProductid());
                dto.setProductname(list.get(i).getProductname());
                dto.setTypeid(list.get(i).getType().getTypeid());
                dto.setTypename(list.get(i).getType().getTypename());
                dto.setVendordemain(list.get(i).getVendordemain());
                dto.setManufacturers(list.get(i).getManufacturers());
                dto.setQuantity(list.get(i).getQuantity());
                dto.setPrice(list.get(i).getPrice());
                dto.setStatusid(list.get(i).getStatusid());
                HashMap<String, String> hashMap1 = hashMap.get("StatusEntity");
                dto.setStatusname(hashMap1.get(list.get(i).getStatusid()));

                querylist.add(dto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       return querylist;
    }
    public ArrayList<StatusDto> queryallstatus() throws Exception{
        HibernateSessionFactory.getSession();//可以不写
        ArrayList<StatusEntity> statusEntityArrayList=new ArrayList<StatusEntity>();
        ArrayList<StatusDto> statusDtolist=new ArrayList<StatusDto>();
        try{
            QueryDao dao=new QueryDao();
            statusEntityArrayList= dao.querystatus();
            for(StatusEntity item:statusEntityArrayList){
                StatusDto dto=new StatusDto();
                dto.setStatusid(item.getStatusid());
                dto.setStatusname(item.getStatusname());
                statusDtolist.add(dto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return statusDtolist;
    }
    public void updataproduct(HttpServletRequest request, HttpServletResponse response)throws Exception{
        takeaxiosparams takeparams = new takeaxiosparams();
        Map<String, Object> params = takeparams.params(request, response);
        System.out.println(params);
        String productkey= (String) params.get("productkey");
        String productid= (String) params.get("productid");
        String productname= (String) params.get("productname");
        String typeid= (String) params.get("typeid");
        String manufacturers= (String) params.get("manufacturers");
        String vendordemain= (String) params.get("vendordemain");
        String statusid= (String) params.get("statusid");
        int quantity= (int) params.get("quantity");
        String pricestr= params.get("price").toString();
        Double price=Double.parseDouble(pricestr);
        TypeEntity type=new TypeEntity();
        type.setTypeid(typeid);
        ProductEntity product=new ProductEntity(
                productkey,
                productid,
                productname,
                vendordemain,
                manufacturers,
                quantity,
                price,
                statusid,
                type
        );
        HibernateSessionFactory.getSession();//可以不写
        Transaction transaction=HibernateSessionFactory.getSession().beginTransaction();
        ArrayList<AllproductDto> querylist=new ArrayList<AllproductDto>();
        try{
            UpdataDao dao=new UpdataDao();
            dao.updataproduct(product);
            transaction.commit();
            HibernateSessionFactory.closeSession();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void addproduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        takeaxiosparams takeparams = new takeaxiosparams();
        Map<String, Object> params = takeparams.params(request, response);
        System.out.println(params);

        String productkey=new getRandomString().getRandomlengthString(6)+"-"+new getRandomString().getRandomlengthString(6)+"-"+new getRandomString().getRandomlengthString(6);
        String productid=new getRandomString().getRandomlengthString(6)+"-"+new getRandomString().getRandomlengthString(6)+"-"+new getRandomString().getRandomlengthString(6);
        String productname= (String) params.get("productname");
        String manufacturers= (String) params.get("manufacturers");
        String vendordemain= (String) params.get("vendordemain");

        String statusname=(String) params.get("statusname");
        String statusid=(String) params.get("statusid");

        String typename=(String) params.get("typename");
        String typeid=(String) params.get("typeid");

        int quantity=(int) params.get("quantity");
        String pricestr= params.get("price").toString();
        Double price=Double.parseDouble(pricestr);
        TypeEntity type=new TypeEntity();
        type.setTypeid(typeid);
        type.setTypename(typename);
        ProductEntity product=new ProductEntity(
                productkey,
                productid,
                productname,
                vendordemain,
                manufacturers,
                quantity,
                price,
                statusid,
                type
        );
        HibernateSessionFactory.getSession();//可以不写
        Transaction transaction=HibernateSessionFactory.getSession().beginTransaction();
        try{
            System.out.println(productkey+","+productid+","+productname+","+manufacturers+","+vendordemain+","+statusname+","+statusid+","+typename+","+typeid+","+quantity+","+price);
            AddDao dao=new AddDao();
            dao.addproduct(product);
            transaction.commit();
            HibernateSessionFactory.closeSession();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delectproduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        takeaxiosparams takeparams = new takeaxiosparams();
        Map<String, Object> params = takeparams.params(request, response);
        System.out.println(params);
        String productid= (String) params.get("productid");
        HibernateSessionFactory.getSession();
        Transaction transaction=HibernateSessionFactory.getSession().beginTransaction();
        try{
            QueryDao dao=new QueryDao();
            ProductEntity productEntity=dao.queryappointproduct(productid);
            System.out.println(productEntity.getStatusid());
                DelectDao DelectDao=new DelectDao();
                DelectDao.delectproduct(productEntity);
                transaction.commit();
                HibernateSessionFactory.closeSession();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public static void main(String[] args) throws Exception {
        IProductService service = new ProductService();
        ArrayList<TypeDto> product = new ArrayList<>();
        EncapsulationApi encap = new EncapsulationApi();
        try {
            product = service.QueryAlltype();
            System.out.println(encap.ResponseAPI("查询成功",0,product));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
