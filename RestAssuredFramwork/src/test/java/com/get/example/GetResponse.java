package com.get.example;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetResponse {

    @Test
    public void getmethod() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/jason");
        request.get("http://localhost:3000/post");
        JSONObject json=new JSONObject();
        request.body(json.toJSONString());
        request.post("url here");
        Response response=request.get("http://localhost:3000/post");
        int code=response.getStatusCode();
        Assert.assertEquals(code,200);
    }

    @Test
    public void requestpost() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/jason");
        JSONObject json=new JSONObject();
        json.put("id","25");
        json.put("title","books");
        request.body(json.toJSONString());
        request.post("url here");
      Response response=request.post("http://localhost:3000/post");
      int code=response.getStatusCode();
        Assert.assertEquals(code,201);
    }

    @Test
    public void putrequest()
    {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/jason");
        JSONObject json=new JSONObject();
        json.put("id","25");
        json.put("title","Science");
        request.body(json.toJSONString());
        request.post("url here");
        Response response=request.put("http://localhost:3000/post");
        int code=response.getStatusCode();
        Assert.assertEquals(code,200);
    }

    @Test
    public void deleterequest()
    {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/jason");
        request.delete("/posts/3"); //specify the path to delete item
        Response response=request.delete("http://localhost:3000/post");
        JSONObject json=new JSONObject();
        request.body(json.toJSONString());
        int code=response.getStatusCode();
        Assert.assertEquals(code,200);
    }



}
