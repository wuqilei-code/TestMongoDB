package com.offcn.TestMong;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BasicBSONObject;
import org.bson.Document;

/**
 * 条件查询
 */
public class SelectBy {
    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("itcastdb");

        MongoCollection<Document> student = db.getCollection("student");
        //创建查询的条件
       BasicDBObject object = new BasicDBObject("name", "沙和尚");

        FindIterable<Document> documents = student.find(object);
       // System.out.println(documents.limit(1));
        for(Document d:documents){
            System.out.println("===========");
            System.out.println(d.getString("name"));
        }


    }

}
