package com.example.spring_java_camping.api;

import com.example.spring_java_camping.business.abstracts.ProductService;
import com.example.spring_java_camping.core.results.DataResult;
import com.example.spring_java_camping.core.results.Result;
import com.example.spring_java_camping.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller: Tüm ekranların backendle anlaşabilmesi için API gerekiyor
//Dış dünyamızın sistemimizle iletişim kurduğu yer conroller'dır.
@RestController
@RequestMapping("/api/products") //Eğer bana domain /kodlama.io/api/products böyle bir istek gelirse bu controller karar verecek
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall") //api/products/getall isteği olursa çalışacak olan
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return productService.getByProductNameAndCategory(productName,categoryId);
    }

    @GetMapping("getByProductNameContains")
    DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    DataResult<List<Product>> getAll(int pageNo,int pageSize){
        return productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getAllAsc")
    public DataResult<List<Product>> getAllSorted(){
        return productService.getAllSorted();
    }
}