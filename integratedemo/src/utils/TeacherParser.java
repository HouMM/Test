package utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import pojo.Teacher;;

public class TeacherParser {
	
	 public static List<Teacher> parseTeacher(String json) {
		 List<Teacher> teachers = new ArrayList<Teacher>();
		 try {
			 JSONArray jsa = new JSONArray("[" + json + "]");
			 for (int i = 0; i < jsa.length(); i++) {
				 JSONObject jso = jsa.getJSONObject(i);
				 Teacher les = new Teacher(jso.getString("id"), jso.getString("teacherInfo"));
				 teachers.add(les);
			 }
		 } catch (JSONException e) {
			 e.printStackTrace();
		 }
		 
		 return teachers;
	 }

}
