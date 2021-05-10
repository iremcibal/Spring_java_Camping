package com.example.spring_java_camping.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})//Sadece map ettiğimiz kadarını getir
public class Category {
    @Id
    @Column(name = "category_id")
    private int categoryId;


    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category") //Ana tablodan(kategori) diğer tabloya(products) bağlantı
    private List<Product> products;

}
