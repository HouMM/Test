package controller;

import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.result.Outputs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;

import pojo.User;
import utils.SearchClassTable;

@ResponseBody
@Controller
public class ImageController {

	
	@RequestMapping(value="/get_image",method=RequestMethod.GET)
	public void getImage(HttpServletResponse response){
		BufferedImage image = SearchClassTable.lessonGetImage();
		response.setContentType("image/png");
		try {
			OutputStream out = response.getOutputStream();
			ImageIO.write(image, "png", out);
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
