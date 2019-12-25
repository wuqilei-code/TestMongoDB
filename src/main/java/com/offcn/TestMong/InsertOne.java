package com.offcn.TestMong;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

//添加文档
public class InsertOne {

    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("itcastdb");
        MongoCollection<Document> student = db.getCollection("student");
        Map map = new HashMap();
        map.put("name", "铁扇公主");
        map.put("sex", "女");
        map.put("age", 35.0);
        map.put("address", "芭蕉洞");
        //创建一个文档
        Document document = new Document(map);
        student.insertOne(document);
    }

}
