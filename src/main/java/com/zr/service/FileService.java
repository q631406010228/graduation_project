package com.zr.service;

import javax.servlet.http.HttpServletResponse;

public interface FileService {
	public HttpServletResponse downFile(String path, HttpServletResponse response) ;
	
}
