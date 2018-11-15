package server;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Model {
	
	private String location;
	private ArrayList<String> data;
	
	public Model(String location, ArrayList<String> data) {

		this.location = location;
		this.data = data;
		
	}
	
	public boolean writeJson() {
//		
//        JSONObject obj = new JSONObject();
//
//        JSONArray list = new JSONArray();
//        list.add("msg 1");
//        list.add("msg 2");
//        list.add("msg 3");
//
//        obj.put("messages", list);
//
//        try (FileWriter file = new FileWriter("f:\\test.json")) {
//
//            file.write(obj.toJSONString());
//            file.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.print(obj);
//
		return false;
	}
	
	
}
