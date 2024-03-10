package com.ignateva.myshop;


import com.ignateva.myshop.entity.Product;

import java.util.ArrayList;

public class Main {
    public static void ShowProducts(ArrayList<Product> products)
    {

        for (Product product: products)
        {
            System.out.println ("*******************");
            System.out.println ("Id: "+product.getId());
            System.out.println ("Title: "+product.getTitle());
            System.out.println ("Price: "+product.getPrice());
            System.out.println ("Description: "+product.getDescription());
        }
    }


    public static void main (String[] args){

     ProductService service= new ProductService();

        ArrayList<Product> products= service.getAll();
       ShowProducts(products);

    }

}
