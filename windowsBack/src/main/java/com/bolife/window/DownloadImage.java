package com.bolife.window;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;


/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/12 15:21
 * @Description:
 */
public class DownloadImage {

    private final String filePath = "D:\\Program Files\\backimage\\bg.jpg";

    public String getLink(){
        String link = "";
        try {
            Document document = Jsoup.connect("https://cn.bing.com").get();
            Element bgLink = document.getElementById("bgLink");
            link = bgLink.absUrl("href");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return link;
    }

    public Boolean dowloadImage(String url,String filePath){
        InputStream in = null;
        FileOutputStream fos = null;
        try {
            URL image = new URL(url);
            in = image.openConnection().getInputStream();
            byte[] img = new byte[1024];
            int len = 0;
            fos = new FileOutputStream(new File(filePath));
            while ((len = in.read(img)) != -1){
                fos.write(img,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                fos.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    public static void main(String[] args) {
        DownloadImage downloadImage = new DownloadImage();
        File file = new File(downloadImage.filePath);
        if(file.exists()){
            file.delete();
        }

        downloadTimer();
    }

    public static void downloadTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                DownloadImage downloadImage = new DownloadImage();
                downloadImage.dowloadImage(downloadImage.getLink(),downloadImage.filePath);
            }
        };
        // 设置执行时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);// 每天
        calendar.set(year, month, day, 9, 00, 00);
        // 定制每天的09:10:00执行，不重复执行
        Date date = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(task, date);
    }
}
