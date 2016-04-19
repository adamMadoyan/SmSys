package com.energizeglobal.smsys.action;

import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */

public class FileDownload extends HttpServlet {

    private String message;

    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {

        System.out.println("------------------------------------------------------------");
        // Set response content type
        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream("/home/adamm/Desktop/tapestry/SMSys/data/1/36download.jpg");
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
        }
        in.close();

    }

    @Override
    public void service(ServletRequest req, ServletResponse response) throws ServletException, IOException {

        System.out.println("------------------------------------------------------------");

        File file =  new File("/home/adamm/Desktop/tapestry/SMSys/data/1/36download.jpg");
        byte[] srcFile = FileUtils.readFileToByteArray(file);

        response.setContentType("image/jpeg");

        OutputStream out = response.getOutputStream();
        out.write(srcFile);
    }

    public void destroy()
    {
        // do nothing.
    }

}
