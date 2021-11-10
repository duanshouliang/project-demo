package com.tuen.nacos.service;

import org.springframework.http.ResponseEntity;


public class NacosTestServiceFallback implements NacosTestService{
    @Override
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("echo fallback");
    }

    public static void main(String[] args) {
        String cover = downCover("test", "198554068", "music");
        System.out.println(cover);
    }

    public static String downCover(String url, String targetId, String type) {
        String cover = "";
        if (url != null) {
            //补充３位防止位数不够
            String targetIdNew = "000" + targetId;
            String targetPath = "/" + type + "/" + targetIdNew.substring(targetIdNew.length() - 3);
            String target = targetId + "-1000x1000.jpg";

            //下载
//            Utils.downloadFile(url, appConfig.getKwRootPath() + targetPath, target);

            cover = targetPath + "/" + target;
        }

        return cover;
    }
}
