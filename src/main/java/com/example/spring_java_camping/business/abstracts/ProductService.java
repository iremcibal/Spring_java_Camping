package com.example.spring_java_camping.business.abstracts;

import com.example.spring_java_camping.core.results.DataResult;
import com.example.spring_java_camping.core.results.Result;
import com.example.spring_java_camping.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAllSorted(); //Sıralama şeklini belirlediğimiz kısım
    DataResult<List<Product>> getAll(int pageNo,int pageSize); //Sayfalama tekniğini kullanıyoruz
    Result add(Product product);
    DataResult<Product> getByProductName(String productName);
    DataResult<Product> getByProductNameAndCategory(String productName,int categoryId);
    DataResult<List<Product>> getByProductNameOrCategory(String productName,int categoryId);
    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);
    DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);
}
