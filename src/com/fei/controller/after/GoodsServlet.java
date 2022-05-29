package com.fei.controller.after;

import com.fei.bean.Goods;
import com.fei.controller.BaseServlet;
import com.fei.service.after.GoodsService;
import com.fei.service.after.impl.GoodsServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/Goods/*")
public class GoodsServlet extends BaseServlet {

    private GoodsService goodsService = new GoodsServiceImpl();

    public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo = request.getParameter("pageNo");
        String goodsName = request.getParameter("goodsName");
        String deployDate = request.getParameter("deployDate");
        String typeId = request.getParameter("typeId");
        List<Goods> goodsList = goodsService.queryAll(pageNo, goodsName, deployDate, typeId);
        long count = goodsService.goodsCount();
        if (pageNo != null) {
            request.setAttribute("pageNo", pageNo);
        } else {
            request.setAttribute("pageNo", 1);
        }
        request.setAttribute("pageCount", count);
        request.setAttribute("goodsList", goodsList);
        request.getRequestDispatcher("/after/goods_list.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
        fileUpload.setHeaderEncoding("UTF-8");
        Map<String,String> map = new HashMap<>();
        try {
            List<FileItem> list = fileUpload.parseRequest(request);
            for (FileItem item : list) {
                //如果fileitem中封装的是普通输入项的数据
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    //String value1 = new String(name.getBytes("iso8859-1"), "UTF-8");
                    map.put(name,value);
                } else {
                    //如果fileitem中封装的是上传文件，得到上传的文件名称，
                    String fileName = item.getName();
                    //System.out.println(fileName);

                    if (fileName == null || fileName.trim().equals("")) {
                        continue;
                    }
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
                    int index = fileName.lastIndexOf(".");
                    String imgType = fileName.substring(index);
                    Date date = new Date();
                    long time = date.getTime();
                    map.put("imgPath",time+imgType);
                    //获取item中的上传文件的输入流
                    InputStream is = item.getInputStream();
                    //创建一个文件输出流
                    FileOutputStream fos = new FileOutputStream("E:\\JavaWork\\fengmiwang\\web\\images\\imgGoods" + File.separator + time + imgType);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int length = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while ((length = is.read(buffer)) > 0) {
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        fos.write(buffer, 0, length);
                    }
                    //关闭输入流
                    is.close();
                    //关闭输出流
                    fos.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    //message = "文件上传成功";
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        String contextPath = request.getContextPath();
        Goods goods = new Goods(Integer.parseInt(map.get("id")), map.get("goodsName"), Double.parseDouble(map.get("price")),
                Integer.parseInt(map.get("typeId")), map.get("imgPath"), map.get("comment"));
        boolean flag = goodsService.goodsUpdate(goods);
        if (flag){
            response.sendRedirect(contextPath + "/Goods/query");
        }
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
        fileUpload.setHeaderEncoding("UTF-8");
        Map<String,String> map = new HashMap<>();
        try {
            List<FileItem> list = fileUpload.parseRequest(request);
            for (FileItem item : list) {
                //如果fileitem中封装的是普通输入项的数据
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    //String value1 = new String(name.getBytes("iso8859-1"), "UTF-8");
                    map.put(name,value);
                } else {
                    //如果fileitem中封装的是上传文件，得到上传的文件名称，
                    String fileName = item.getName();
                    //System.out.println(fileName);

                    if (fileName == null || fileName.trim().equals("")) {
                        continue;
                    }
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
                    int index = fileName.lastIndexOf(".");
                    String imgType = fileName.substring(index);
                    Date date = new Date();
                    long time = date.getTime();
                    map.put("imgPath",time+imgType);
                    //获取item中的上传文件的输入流
                    InputStream is = item.getInputStream();
                    //创建一个文件输出流
                    FileOutputStream fos = new FileOutputStream("E:\\JavaWork\\fengmiwang\\web\\images\\imgGoods" + File.separator + time + imgType);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int length = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while ((length = is.read(buffer)) > 0) {
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        fos.write(buffer, 0, length);
                    }
                    //关闭输入流
                    is.close();
                    //关闭输出流
                    fos.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    //message = "文件上传成功";
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        String contextPath = request.getContextPath();
        Goods goods = new Goods(0, map.get("goodsName"), Double.parseDouble(map.get("price")),
                Integer.parseInt(map.get("typeId")), map.get("imgPath"), map.get("comment"));
        boolean flag = goodsService.goodsAdd(goods);
        long count = goodsService.goodsCount();
        if (flag){
            response.sendRedirect(contextPath + "/Goods/query?pageNo=" + count);
        }
    }
}
