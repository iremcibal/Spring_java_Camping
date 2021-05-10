package com.example.spring_java_camping.business.concretes;

import com.example.spring_java_camping.business.abstracts.ProductService;
import com.example.spring_java_camping.core.results.DataResult;
import com.example.spring_java_camping.core.results.Result;
import com.example.spring_java_camping.core.results.SuccessDataResult;
import com.example.spring_java_camping.dataAccess.abstracts.ProductDao;
import com.example.spring_java_camping.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Business görevini görececk????
public class ProductManager implements ProductService {
    private ProductDao productDao;

    @Autowired /*annotation'ı eklenmiş property ile eşleşen
    bir class ya da interface arar. bağlantı kurduğunda
    (wired) ise otomatik olarak bağımlılığı enjekte eder.*/
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(productDao.findAll(),"Data Listelendi.");
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC,"productName");
        return new SuccessDataResult<List<Product>>(productDao.findAll(sort),"Başarılı");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Product>>(productDao.findAll(pageable).getContent());
    }

    @Override
    public Result add(Product product) {
        productDao.save(product);
        return new Result(true,"Yeni pozisyon eklendi");
    }


    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Data Listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
        //business control
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId)
                ,"Data Listelendi");

    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId)
                ,"Data Listelendi");

    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories)
                ,"Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName)
                ,"Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName)
                ,"Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId)
                ,"Data Listelendi");
    }
}
