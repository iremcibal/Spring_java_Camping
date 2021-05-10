package com.example.spring_java_camping.entities.concretes;


import lombok.Data;
import javax.persistence.*;

@Data //-> lombok yardımıyla getter-setter gelmiş olur
@Entity /*"Product bir entity'dir"--Çıplak class kalmasın dediğimiz classlarımızı
bu yöntemle katmanını belirtmiş oluyoruz */
//Annotation: Aslında bir classın çalışma anında veya derleme anında bilgi toplama için yapılan bir yapı
@Table(name="products") //DB'de hangi tabloya denk geldiğini söylüyor.
public class Product {
    @Id //Tablodaki id alanının ne olduğunu söylememiz gerekiyor
    @GeneratedValue //id'nin otomatik-manuel artacağını belirtiyoruz.(otomatik)
    @Column(name="product_id")//Products tablosunda hangi sütuna işaret ettiği
    private int id;

   /* @Column(name="category_id")
    private int categoryId;*/

    @Column(name="product_name")
    private String productName;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private short unitsInStock;

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    public Product(){

    }
    public Product(int id, String productName, double unitPrice, short unitsInStock, String quantityPerUnit) {
        this.id = id;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.quantityPerUnit = quantityPerUnit;
    }

    @ManyToOne() //???????????
    @JoinColumn(name = "category_id")
    private Category category;
    //Category tablosunun kolonlarını eklediğimiz için yukarıdan sildik.


}
