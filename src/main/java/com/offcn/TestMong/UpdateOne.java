package com.offcn.TestMong;


import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

//修改一个文档
public class UpdateOne {
    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("itcastdb");
        MongoCollection<Document> student = database.getCollection("student");
        BasicDBObject object = new BasicDBObject("name", "哪吒");
        BasicDBObject object1 = new BasicDBObject("$set", new BasicDBObject("address", "钱塘关"));
        UpdateResult one = student.updateOne(object, object1);
        System.out.println(one);


    }
}
