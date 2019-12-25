package com.offcn.TestMong;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

//连接并差查询表中的所有数据
public class ConnectionMong {


    public static void main(String[] args) {

        //创建mongdo客户端
        MongoClient client = new MongoClient();
        //获取数据库
        MongoDatabase testdb = client.getDatabase("itcastdb");
        //获取集合
        MongoCollection<Document> student = testdb.getCollection("student");
        FindIterable<Document> documents = student.find();
        System.out.println("123456789");
        for( Document doc: documents){//遍历集合中的文档输出数据
            System.out.println("name:"+ doc.getString("name") );
            System.out.println("sex:"+ doc.getString("sex") );
            System.out.println("age:"+ doc.getDouble("age") );//默认为浮点型
            System.out.println("address:"+ doc.getString("address") );
            System.out.println("--------------------------");
        }
    }
}
