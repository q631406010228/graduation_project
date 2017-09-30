package com.zr.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.zr.service.FileService;

public class FileServiceImpl implements FileService {
 @Override
 public HttpServletResponse downFile(String path, HttpServletResponse response) {
	 try {
         // path是指欲下载的文件的路径。
         File file = new File(path);
         // 取得文件名。
         String filename = file.getName();
         System.out.println("下载文件的文件名："+filename);
         // 取得文件的后缀名。
         String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
         System.out.println("下载文件的文件名的后缀："+ext);
         // 以流的形式下载文件。
         InputStream fis = new BufferedInputStream(new FileInputStream(path));
         byte[] buffer = new byte[fis.available()];
         fis.read(buffer);
         fis.close();
         // 清空response
         response.reset();
         // 设置response的Header
        
		
         response.addHeader("content-cisposition", "attachment;filename="+filename);
         response.addHeader("Content-Length", "" + file.length());
         OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
         response.setContentType("application/octet-stream");
         toClient.write(buffer);
         toClient.flush();
         toClient.close();
     //	response.getWriter().write("下载成功");
     } catch (IOException ex) {
         ex.printStackTrace();
     }
     return response;
	
}
 
}
