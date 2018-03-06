/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.Item;
import java.util.ArrayList;

/**
 *
 * @author zinanwang
 */
public class ItemDAO {
    
    public ArrayList<Item> getBookItems(){
        
        ArrayList<Item> bookList = new ArrayList<Item>();
        
        Item b1 = new Item();
        b1.setName("Java Servlet Programming");
        b1.setPrice((float) 29.95);
        b1.setType("book");
        
        Item b2 = new Item();
        b2.setName("Oracle Database Programming");
        b2.setPrice((float) 48.95);
        b2.setType("book");
        
        Item b3 = new Item();
        b3.setName("System Analysis and Design with UML");
        b3.setPrice((float) 14.95);
        b3.setType("book");
        
        Item b4 = new Item();
        b4.setName("Object Oritented Software Engineering");
        b4.setPrice((float) 35.99);
        b4.setType("book");
        
        Item b5 = new Item();
        b5.setName("Java Web Services");
        b5.setPrice((float) 27.99);
        b5.setType("book");
        
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);
        bookList.add(b5);
        
        return bookList;
        
    }
    
    public ArrayList<Item> getMusicItems(){
        
        ArrayList<Item> musicList = new ArrayList<Item>();
    
        Item m1 = new Item();
        m1.setName("I am Going to tell your a serect by Madonna");
        m1.setPrice((float) 26.99);
        m1.setType("music");
        
        Item m2 = new Item();
        m2.setName("Baby One More Time by Bntney Spears");
        m2.setPrice((float) 10.95);
        m2.setType("music");
        
        Item m3 = new Item();
        m3.setName("Justified by Justin Timberlake");
        m3.setPrice((float) 9.97);
        m3.setType("music");
        
        Item m4 = new Item();
        m4.setName("Loose by Nelly Furtado");
        m4.setPrice((float) 13.98);
        m4.setType("music");
        
        Item m5 = new Item();
        m5.setName("Gold Digger by Kanye West");
        m5.setPrice((float) 13.98);
        m5.setType("music");
        
        musicList.add(m1);
        musicList.add(m2);
        musicList.add(m3);
        musicList.add(m4);
        musicList.add(m5);
        
        return musicList;
    
    }
    
    public ArrayList<Item> getComputerItems(){
        
        ArrayList<Item> computerList = new ArrayList<Item>();
        Item c1 = new Item();
        c1.setName("Apple Macbooks Pro with 13.3* Display");
        c1.setPrice((float) 1299.99);
        
        Item c2 = new Item();
        c2.setName("Arus Laptop with Centrino 2 Black");
        c2.setPrice((float) 949.95);
        
        Item c3 = new Item();
        c3.setName("HP Pavmos Laptop with Centrino 2 DV7");
        c3.setPrice((float) 1199.99);
        
        Item c4 = new Item();
        c4.setName("Toshiba Satellite Laptop with Cenrino 2 -Copper");
        c4.setPrice((float) 899.99);
        
        Item c5 = new Item();
        c5.setName("Sony VAIO Laptop with Core 2 Duo Cosmopolitan Pink");
        c5.setPrice((float) 779.99);
        
        computerList.add(c1);
        computerList.add(c2);
        computerList.add(c3);
        computerList.add(c4);
        computerList.add(c5);
        
        return computerList;
    }
    
}
