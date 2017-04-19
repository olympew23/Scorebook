package com.theironyard.novauc;

import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import javax.swing.text.html.parser.DTD;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;

@SpringBootApplication
public class ScoreBookApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ScoreBookApplication.class, args);


//		try
//
//		{
//			URL u = new URL("http://localhost:8080/");
//			//BufferedReader br = new BufferedReader();
//			OutputStream out = new FileOutputStream("home.html");
//			InputStream in = u.openStream();
//			DTD html = DTD.getDTD("html");
//			System.out.println(html.getName());
//			in.close();
//			out.flush();
//			out.close();
//		} catch (Exception e) {
//			System.err.println("Usage: java PageSaver url local_file");
//		}


	}

}
