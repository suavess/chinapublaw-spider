package com.suave;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Suave
 * @date 2022/11/10 10:38
 */
public class Main {

    public static final String URL = "http://www.chinapublaw.com/book/13330/";

    public static AtomicInteger flag = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {
        HttpResponse response = HttpRequest.get(URL).header("User-Agent", "Mozilla/5.0").execute();
        // 截取body
        Document document = Jsoup.parse(response.body());
        Elements info = document.getElementsByClass("top");
        Elements h1 = info.get(0).getElementsByTag("h1");
        File file = FileUtil.file("/Users/suave/Desktop/" + h1.text() + ".txt");
        if (FileUtil.exist(file)) {
            FileUtil.del(file);
        }
        file.createNewFile();
        FileOutputStream stream = new FileOutputStream(file);
        // 线程池
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Elements pageElements = document.getElementsByClass("section-list").get(1).getElementsByTag("a");
        for (int i = 0; i < pageElements.size(); i++) {
            Element element = pageElements.get(i);
            String href = element.attr("href");
            executor.execute(getRunnable(stream, element.text(), href, 2 * i));
            executor.execute(getRunnable(stream, element.text(), href, 2 * i + 1));
        }
        executor.shutdown();
    }

    private static Runnable getRunnable(FileOutputStream stream, String pageTitle, String href, int i) {
        return () -> {
            String url;
            if (i % 2 == 0) {
                url = StrUtil.format("http://www.chinapublaw.com{}", href);
            } else {
                url = StrUtil.format("http://www.chinapublaw.com{}", StrUtil.sub(href, 0, -5) + "_2.html");
            }
            HttpResponse pageResponse = HttpRequest.get(url).header("User-Agent", "Mozilla/5.0").header("X-Forwarded-For", getRandomIp()).execute();
            Document articleDocument = Jsoup.parse(pageResponse.body());
            Elements title = articleDocument.getElementsByClass("title");
            Element content = articleDocument.getElementById("content");
            content.select("div").remove();
            while (!Objects.equals(flag.get(), i)) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                if (i % 2 == 0) {
                    stream.write(title.get(0).text().getBytes());
                    stream.write("\n".getBytes());
                }
                stream.write(content.text().getBytes());
                stream.write("\n".getBytes());
                if (i % 2 == 0) {
                    System.out.println(pageTitle);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            flag.incrementAndGet();
        };
    }

    public static String getRandomIp() {
        // ip范围
        int[][] range = {
                // 36.56.0.0-36.63.255.255
                {607649792, 608174079},
                // 61.232.0.0-61.237.255.255
                {1038614528, 1039007743},
                // 106.80.0.0-106.95.255.255
                {1783627776, 1784676351},
                // 121.76.0.0-121.77.255.255
                {2035023872, 2035154943},
                // 123.232.0.0-123.235.255.255
                {2078801920, 2079064063},
                // 139.196.0.0-139.215.255.255
                {-1950089216, -1948778497},
                // 171.8.0.0-171.15.255.255
                {-1425539072, -1425014785},
                // 182.80.0.0-182.92.255.255
                {-1236271104, -1235419137},
                // 210.25.0.0-210.47.255.255
                {-770113536, -768606209},
                // 222.16.0.0-222.95.255.255
                {-569376768, -564133889},
        };
        int index = RandomUtil.randomInt(10);
        return num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
    }

    /**
     * 将十进制转换成IP地址
     */
    public static String num2ip(int ip) {
        int[] b = new int[4];
        b[0] = (ip >> 24) & 0xff;
        b[1] = (ip >> 16) & 0xff;
        b[2] = (ip >> 8) & 0xff;
        b[3] = ip & 0xff;
        return b[0] + "." + b[1] + "." + b[2] + "." + b[3];
    }

}
