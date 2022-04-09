package com.dao;

import com.model.entity.ProductEntity;
import com.model.entity.StatusEntity;
import com.model.entity.TypeEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class QueryDao extends BaseHibernateDAO{
    public QueryDao() {
    }
    public ArrayList<ProductEntity> allproductDtoArrayList() {
        ArrayList<ProductEntity> productlist = new ArrayList<ProductEntity>();
        ArrayList<ProductEntity> List = null;
        try {
            //1.创建CriteriaBuilder对象
            //注意导入的包是import javax.persistence.criteria.CriteriaQuery;
            CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
            //2.获取CriteriaQuery对象
            CriteriaQuery<ProductEntity> createQuery = criteriaBuilder.createQuery(ProductEntity.class);
            //3.指定根条件
            createQuery.from(ProductEntity.class);
            //4执行查询
            List = (ArrayList<ProductEntity>) getSession().createQuery(createQuery).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List;
    }
    public ArrayList<TypeEntity> querytype() {
        ArrayList<TypeEntity> Typelist = new ArrayList<TypeEntity>();
        try {
            //1.创建CriteriaBuilder对象
            //注意导入的包是import javax.persistence.criteria.CriteriaQuery;
            CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
            //2.获取CriteriaQuery对象
            CriteriaQuery<TypeEntity> createQuery = criteriaBuilder.createQuery(TypeEntity.class);
            //3.指定根条件
            createQuery.from(TypeEntity.class);
            //4执行查询
            List<TypeEntity> type = getSession().createQuery(createQuery).getResultList();
            for (TypeEntity item : type) {
                TypeEntity typeEntity = new TypeEntity();
                typeEntity.setTypeid(item.getTypeid());
                typeEntity.setTypename(item.getTypename());
                Typelist.add(typeEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Typelist;
    }
    public ArrayList<StatusEntity> querystatus() {
        ArrayList<StatusEntity> statuslist = new ArrayList<StatusEntity>();
        try {
            //1.创建CriteriaBuilder对象
            //注意导入的包是import javax.persistence.criteria.CriteriaQuery;
            CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
            //2.获取CriteriaQuery对象
            CriteriaQuery<StatusEntity> createQuery = criteriaBuilder.createQuery(StatusEntity.class);
            //3.指定根条件
            createQuery.from(StatusEntity.class);
            //4执行查询
            List<StatusEntity> type = getSession().createQuery(createQuery).getResultList();
            for (StatusEntity item : type) {
                StatusEntity statusEntity = new StatusEntity();
                statusEntity.setStatuskey(item.getStatuskey());
                statusEntity.setStatusid(item.getStatusid());
                statusEntity.setStatusname(item.getStatusname());
                statuslist.add(statusEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statuslist;
    }
    public ArrayList<ProductEntity> queryproductArrayList(String productname,String typeid,double price1,double price2){
        ArrayList<ProductEntity> productlist = new ArrayList<ProductEntity>();
        try {
            //1.创建CriteriaBuilder对象
            //注意导入的包是import javax.persistence.criteria.CriteriaQuery;
            CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
            //2.获取CriteriaQuery对象
            CriteriaQuery<ProductEntity> createQuery = criteriaBuilder.createQuery(ProductEntity.class);
            //3.指定根条件
//            createQuery.from(ProductEntity.class);
            //2. 指定根条件
            Root<ProductEntity> root = createQuery.from(ProductEntity.class);
            //3. 创建查询条件
            if (productname.length() > 0) {
                Predicate prodname = criteriaBuilder.equal(root.get("productname"), productname);
                //4. 将查询条件设置到where方法中
                createQuery.where(criteriaBuilder.and(prodname));
            }
            TypeEntity type = new TypeEntity();
            if (typeid.length() > 0) {
                type.setTypeid(typeid);
                type.setTypename(null);
            }
            Predicate querytype = criteriaBuilder.equal(root.get("type"), type);
            //4. 将查询条件设置到where方法中
            createQuery.where(criteriaBuilder.and(querytype));
            if (price2 >= 0) {
                Predicate pricemin = criteriaBuilder.ge(root.get("price"), price1);
                Predicate pricemax = criteriaBuilder.le(root.get("price"), price2);
                //4. 将查询条件设置到where方法中
                createQuery.where(criteriaBuilder.and(pricemin, pricemax));
            }
            //5. 通过session执行查询
            List<ProductEntity> List = getSession().createQuery(createQuery).getResultList();
            for (ProductEntity item : List) {
                ProductEntity product = new ProductEntity();
                product.setProductkey(item.getProductkey());
                product.setProductid(item.getProductid());
                product.setProductname(item.getProductname());
                product.setVendordemain(item.getVendordemain());
                product.setManufacturers(item.getManufacturers());
                product.setPrice(item.getPrice());
                product.setQuantity(item.getQuantity());
                product.setStatusid(item.getStatusid());
                product.setType(item.getType());
                productlist.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productlist;
    }
    public ProductEntity queryappointproduct(String productid){
        ArrayList<ProductEntity> productlist=new ArrayList<>();
        try {
            //1.创建CriteriaBuilder对象
            //注意导入的包是import javax.persistence.criteria.CriteriaQuery;
            CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
            //2.获取CriteriaQuery对象
            CriteriaQuery<ProductEntity> createQuery = criteriaBuilder.createQuery(ProductEntity.class);
            //3.指定根条件
//            createQuery.from(ProductEntity.class);
            //2. 指定根条件
            Root<ProductEntity> root = createQuery.from(ProductEntity.class);
            //3. 创建查询条件
            Predicate prodname = criteriaBuilder.equal(root.get("productid"), productid);
            //4. 将查询条件设置到where方法中
            createQuery.where(criteriaBuilder.and(prodname));
            //5. 通过session执行查询
            List<ProductEntity> List = getSession().createQuery(createQuery).getResultList();
            for (ProductEntity item : List) {
                ProductEntity product = new ProductEntity();
                product.setProductkey(item.getProductkey());
                product.setProductid(item.getProductid());
                product.setProductname(item.getProductname());
                product.setVendordemain(item.getVendordemain());
                product.setManufacturers(item.getManufacturers());
                product.setPrice(item.getPrice());
                product.setQuantity(item.getQuantity());
                product.setStatusid(item.getStatusid());
                product.setType(item.getType());
                productlist.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productlist.get(0);
    }
    public static void main(String[] args) {
        QueryDao dao=new QueryDao();

    }
}
