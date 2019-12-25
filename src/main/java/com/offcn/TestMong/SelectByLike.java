package com.offcn.TestMong;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.regex.Pattern;

//模糊查询
public class SelectByLike {

    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("itcastdb");
        MongoCollection<Document> student = db.getCollection("student");
        //添加模糊查询条件，这个格式相当于sql的like+“%洞%”
        Pattern compile = Pattern.compile("^.*洞.*$");
        //创建条件拼接对象
        BasicDBObject address = new BasicDBObject("address", compile);
        FindIterable<Document> documents = student.find(address);
        for( Document doc: documents){//遍历集合中的文档输出数据
            System.out.println("name:"+ doc.getString("name") );
            System.out.println("sex:"+ doc.getString("sex") );
            System.out.println("age:"+ doc.getDouble("age") );//默认为浮点型
            System.out.println("address:"+ doc.getString("address") );
            System.out.println("--------------------------");
        }




    }



}
