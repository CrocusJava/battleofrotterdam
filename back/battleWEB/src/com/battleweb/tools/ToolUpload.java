package com.battleweb.tools;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.battleweb.logger.Log;

/**
 * @author rtkachuk
 *
 */
@Stateless
@LocalBean
public class ToolUpload {
			
	public String uploadImage(HttpServletRequest request, String filePath, String fileName) throws ServletException{
		String fileNameCorrect=null;

		try {
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			
			for (FileItem item : items) {
				//TODO refactoring
				if (item.isFormField()) {
					
				} else {
					/** Get MIME type of file*/
					String fileNameUser=item.getName();
					String [] fileNameUserSplit=fileNameUser.split("\\.");
					fileNameCorrect=fileName+fileNameUserSplit[fileNameUserSplit.length-1];
					File file=new File(filePath, fileNameCorrect);
					item.write(file);
				}
			}
		} catch (FileUploadException e) {
			Log.error(this, e, "Can't save file on server. File name - "+fileNameCorrect);
			throw new ServletException("Parsing file upload failed.", e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileNameCorrect;
	}
	
//	public void scalePhoto(String filePath, String fileNameCorrect, Integer width, Integer height){
//		File originalFile=new File(filePath, fileNameCorrect);
//		BufferedImage originalImage;
//		try {
//			originalImage = ImageIO.read(originalFile);
//			Integer originalWidth = originalImage.getWidth();
//			Integer originalHeight = originalImage.getHeight();
//			Integer newWidth = width;
//			Integer newHeight = height;
//			if (null == newHeight){
//				double ration = (double)(originalWidth/newWidth);
//				newHeight = (int)(originalHeight/ration);
//			}
//			Image image = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
//			BufferedImage changedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
//			Graphics2D graphics2d = changedImage.createGraphics();
//			graphics2d.drawImage(image, 0, 0, null);
//			graphics2d.dispose();
//			ImageIO.write(changedImage, FilenameUtils.getExtension(originalFile.getName()), originalFile);		
//		} catch (IOException e) {
//			Log.error(this, "Cant scale photo "+fileNameCorrect);
//		}
//	}

	public void scalePhoto(String filePath, String fileNameCorrect, Integer width, Integer height){
		File originalFile=new File(filePath, fileNameCorrect);
		try {
			BufferedImage originalImage = ImageIO.read(originalFile);
			Integer originalWidth = originalImage.getWidth();
			Integer originalHeight = originalImage.getHeight();
			Integer newWidth = width;
			Integer newHeight = height;
			double ration = Double.valueOf(originalWidth)/Double.valueOf(newWidth);
			if (null == newHeight){
				newHeight = (int)(originalHeight/ration);
			}
			BufferedImage newImage = getScaledInstance(originalImage, newWidth, newHeight, RenderingHints.VALUE_INTERPOLATION_BILINEAR, true);
			ImageIO.write(newImage, FilenameUtils.getExtension(originalFile.getName()), originalFile);	

		} catch (IOException e) {
			Log.error(this, "Cant scale photo "+fileNameCorrect);
		}
	}
	
	private BufferedImage getScaledInstance(BufferedImage img,
            int targetWidth,
            int targetHeight,
            Object hint,
            boolean higherQuality)	{
		int type = (img.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		BufferedImage ret = (BufferedImage)img;
		int w, h;
		if (higherQuality) {
			/** Use multi-step technique: start with original size, then
			 * scale down in multiple passes with drawImage()
			 * until the target size is reached
			 */
			w = img.getWidth();
			h = img.getHeight();
		} else {
			w = targetWidth;
			h = targetHeight;
		}
		do {
			if (higherQuality && w > targetWidth) {
				w /= 2;
				if (w < targetWidth) {
					w = targetWidth;
				}
			}

			if (higherQuality && h > targetHeight) {
				h /= 2;
				if (h < targetHeight) {
					h = targetHeight;
				}
			}

			BufferedImage tmp = new BufferedImage(w, h, type);
			Graphics2D g2 = tmp.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
			g2.drawImage(ret, 0, 0, w, h, null);
			g2.dispose();

			ret = tmp;
		} while (w != targetWidth || h != targetHeight);

		return ret;
	}
}
