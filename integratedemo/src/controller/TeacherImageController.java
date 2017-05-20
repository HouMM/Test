package controller;

import java.awt.image.BufferedImage;

import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import utils.SearchClassTable;
import utils.SearchTearchClassTable;

@ResponseBody
@Controller
public class TeacherImageController {
	
	@RequestMapping(value = "/get_teimage", method = RequestMethod.GET)
	public void getImage(HttpServletResponse response) {
		BufferedImage image = SearchTearchClassTable.teacherGetImage();
		response.setContentType("image/png");  
		try {
			OutputStream sos = response.getOutputStream();
			ImageIO.write(image, "png", sos);
			sos.close();
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
}
