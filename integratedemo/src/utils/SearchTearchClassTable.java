package utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class SearchTearchClassTable {
	static String cookie = null;
	
	public static BufferedImage teacherGetImage() {

		URL url = null;
		HttpURLConnection con = null;
		InputStream in = null;
		BufferedImage image = null;
		try {
			url = new URL("http://xg.zdsoft.com.cn/ZNPK/TeacherKBFB.aspx");

			con = (HttpURLConnection) url.openConnection();

			in = con.getInputStream();

		} catch (Exception e) {
			// TODO: handle exception
		}

		cookie = con.getHeaderField("Set-Cookie");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Document doc = Jsoup.parse(sb.toString(), "utf-8");
		Elements src = doc.select("label img[id=\"imgCode\"]");
		String urlImage = "http://xg.zdsoft.com.cn"
				+ src.attr("src").substring(2);
		try {
			URL url1 = new URL(urlImage);
			con = (HttpURLConnection) url1.openConnection();
			con.addRequestProperty("Cookie", cookie);
			con.setRequestProperty("Referer",
					"http://xg.zdsoft.com.cn/ZNPK/KBFB_LessonSel.aspx");
			InputStream in1 = con.getInputStream();
			image = ImageIO.read(in1);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			con.disconnect();

		}
		return image;
	}
	
	public static List<String> teacherGetLessonInfo() {
		String yearItem = "20160";
		URL url = null;
		HttpURLConnection con = null;
		InputStream in = null;

		try {
			url = new URL(
					"http://xg.zdsoft.com.cn/ZNPK/Private/List_JS.aspx?xnxq="
							+ yearItem + "&t=" + "1");
			con = (HttpURLConnection) url.openConnection();
			in = con.getInputStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in, "gb2312"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Document doc = Jsoup.parse(sb.toString(), "utf-8");
		Elements lessons = doc.select("script");
		doc = Jsoup.parse(lessons.html(), "utf-8");
		Elements items = doc.select("select[name=\"Sel_JS\"] option");
		List<String> lessonList = new ArrayList<>();
		for (int i = 1; i < items.size(); i++) {
			String jsonString = "{\"id\":" + "\"" + items.get(i).attr("value")
					+ "\"" +",\"teacherInfo\":" + "\"" + items.get(i).text() + "\"" +"}";
			lessonList.add(jsonString);
		}
		return lessonList;
	}
	
	public static List<List<String>> teacherGetRealClassesInfo(String teacherId, String identifyCode) {
		String yearTeam = "20160";
		URL url = null;
		HttpURLConnection con = null;
		InputStream in = null;

		
		try {
			url = new URL("http://xg.zdsoft.com.cn/ZNPK/TeacherKBFB_rpt.aspx");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.addRequestProperty("Cookie", cookie);
			con.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			con.setRequestProperty("Referer",
					"http://xg.zdsoft.com.cn/ZNPK/TeacherKBFB.aspx");
			con.setRequestProperty(
					"User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.22 Safari/537.36 SE 2.X MetaSr 1.0");
			
			DataOutputStream out = new DataOutputStream(con
	                .getOutputStream());
			String content = "Sel_XNXQ=" + URLEncoder.encode(yearTeam, "UTF-8");
	        content +="&Sel_JS="+URLEncoder.encode(teacherId, "UTF-8");
	        content +="&type="+URLEncoder.encode("1", "UTF-8");
	        content +="&txt_yzm="+URLEncoder.encode(identifyCode, "UTF-8");
	        
	        out.writeBytes(content);
	        out.flush();
	        out.close(); 
	        
	        con.connect();
			in = con.getInputStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in, "GB2312"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Document doc = Jsoup.parse(sb.toString(), "utf-8");
		Elements items = doc.select("tbody table");
		if (items.size() != 0) {
			String classDetail = "{\"teacherClassDetail\":"  + "\"" + items.get(1).text() + "\"" +"}";
			Elements items1 = items.get(2).getElementsByTag("tbody").get(0).getElementsByTag("tr");
			List<List<String>> listJsonStirng = new ArrayList<>();
			List<String> classDetailTitle = new ArrayList<>();
			List<String> classDetailInfo = new ArrayList<>();
			classDetailTitle.add(classDetail);
			for (int i = 1; i < items1.size(); i++) {
				Elements trs = items1.get(i).getElementsByAttributeValue("valign", "top");
				for (int j = 0; j < trs.size(); j++) {
					String classInfo = trs.get(j).text();
					if (classInfo.length() != 0) {
						String jsonString = "{\"id\":" + "\"" +i + "-" + (j + 1) + "\"" +",\"teacherClass\":" + "\"" +classInfo + "\"" +"}";
						classDetailInfo.add(jsonString);
					}
				}
			}
		//	Log.i("**********",classDetailTitle.size()+"");
			listJsonStirng.add(classDetailTitle);
			listJsonStirng.add(classDetailInfo);
			return listJsonStirng;
		}else {
			return null;
		}

		
		
		
 	}	
}
