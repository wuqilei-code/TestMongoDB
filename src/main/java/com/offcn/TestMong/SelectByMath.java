package com.offcn.TestMong;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import sun.net.www.content.audio.basic;

import java.util.Arrays;

//大于 小于 多条件拼接
public class SelectByMath {

    public static void main(String[] args) {

        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("itcastdb");
        MongoCollection<Document> student = db.getCollection("student");
        //查询年龄小于20岁的
      /*  FindIterable<Document> documents = student.find(new BasicDBObject("age", new BasicDBObject("$lt", 20)));
        for( Document doc: documents){//遍历集合中的文档输出数据
            System.out.println("name:"+ doc.getString("name") );
            System.out.println("sex:"+ doc.getString("sex") );
            System.out.println("age:"+ doc.getDouble("age") );//默认为浮点型
            System.out.println("address:"+ doc.getString("address") );
            System.out.println("--------------------------");
        }*/
      //查询年龄大于等于20 小于30岁的，  多条件拼接
        BasicDBObject object = new BasicDBObject("age", new BasicDBObject("$lt", 30));
        BasicDBObject object1 = new BasicDBObject("age", new BasicDBObject("$gte", 20));
        BasicDBObject and = new BasicDBObject("$and", Arrays.asList(object, object1));
        FindIterable<Document> documents = student.find(and);
        for( Document doc: documents){//遍历集合中的文档输出数据
            System.out.println("name:"+ doc.getString("name") );
            System.out.println("sex:"+ doc.getString("sex") );
            System.out.println("age:"+ doc.getDouble("age") );//默认为浮点型
            System.out.println("address:"+ doc.getString("address") );
            System.out.println("--------------------------");
        }


    }
}
