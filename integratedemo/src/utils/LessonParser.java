package utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import pojo.Lesson;

public class LessonParser {
	
	 public static List<Lesson> parseLesson(String json) {
		 List<Lesson> lessons = new ArrayList<Lesson>();
		 try {
			 JSONArray jsa = new JSONArray("[" + json + "]");
			 for (int i = 0; i < jsa.length(); i++) {
				 JSONObject jso = jsa.getJSONObject(i);
				 Lesson les = new Lesson(jso.getString("id"), jso.getString("lessonInfo"));
				 lessons.add(les);
			 }
		 } catch (JSONException e) {
			 e.printStackTrace();
		 }
		 
		 return lessons;
	 }

}
