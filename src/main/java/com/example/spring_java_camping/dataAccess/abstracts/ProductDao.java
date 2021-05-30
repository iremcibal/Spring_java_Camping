package com.example.spring_java_camping.dataAccess.abstracts;


import com.example.spring_java_camping.entities.concretes.Product;
import com.example.spring_java_camping.entities.concretes.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//jpa repository: "verdiğiniz veri tipi için primary key alanında ne olduğunu bana ver ki
//sorguları ona göre hazırlayım"
public interface ProductDao extends JpaRepository<Product,Integer> {


    Product getByProductName(String productName);
    //getby'ı gördüğü anda tabloya bakıyor ve tablodaki kolona göre bize veriyor.

    Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
    //get ve and'i görüp ikisini veriyor tablodan

    List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
    // farklı şekilde OR ile de yapabiliriz

    List<Product> getByCategoryIn(List<Integer> categories);
    //select * from products where category_id in(1,2,3,4)

    List<Product> getByProductNameContains(String productName);
    //Contains??

    List<Product> getByProductNameStartsWith(String productName);
    //Şununla başlayan isimleri getir gibi

    @Query("FROM Product where productName=:productName and category.categoryId=:categoryId") //Veritabanı
    // :/? parametre demek
    List<Product> getByNameAndCategory(String productName,int categoryId);
    //select * from products where product_name=bişey and categoryId=bişey


    @Query("select new com.example.spring_java_camping.entities.concretes.dtos.ProductWithCategoryDto" +
            "(p.id,p.productName,c.categoryName) " +
            "from Category c inner join c.products p")
    //Bunları bir araya getir
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
    //Kategorilerle ilişkilendirilmiş productlardan çek
    //select p.productId,p.productName,c.categoryName from Category c inner join Product p
    //on c.categoryId = p.categoryId




}
