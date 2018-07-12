package com.wuping.api.core;

import com.wp.javax.script.JSSecret;
import com.wuping.api.netease.Api;
import com.wuping.api.netease.UrlParamPair;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class NeteaseApi {

    public static String getPlaylistOfUser(String uid){
        try {
//            String req_str = "{\n" +
//                    "                \"offset\": 0,\n" +
//                    "                \"uid\": 98706997,\n" +
//                    "                \"limit\": 3,\n" +
//                    "                \"csrf_token\":\"kjdjdjdkdfjdk\"\n" +
//                    "            }";
//            String uid = "97526496";
            UrlParamPair upp = Api.getPlaylistOfUser(uid);
            System.out.println("UrlParamPair:"+upp.toString());
            String req_str = upp.getParas().toJSONString();
            System.out.println("req_str:"+req_str);
            JSSecret.getDatas(req_str);

            Connection.Response
                    response = Jsoup.connect("http://music.163.com/weapi/user/playlist?csrf_token=")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0")
                    .header("Accept", "*/*")
                    .header("Cache-Control", "no-cache")
                    .header("Connection", "keep-alive")
                    .header("Host", "music.163.com")
                    .header("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                    .header("DNT", "1")
                    .header("Pragma", "no-cache")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data(JSSecret.getDatas(req_str))
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .timeout(10000)
                    .execute();
            String list = response.body();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getDetailOfPlaylist(String musicId){
        try {
//            String music_id = "516392300";
            UrlParamPair upp = Api.getDetailOfPlaylist(musicId);
            String req_str = upp.getParas().toJSONString();
            System.out.println("req_str:"+req_str);
            //某个歌的评论json地址
            //http://music.163.com/weapi/v1/resource/comments/R_SO_4_516392300?csrf_token=1ac15bcb947b3900d9e8e6039d121a81
            Connection.Response
                    response = Jsoup.connect("http://music.163.com/weapi/v1/resource/comments/R_SO_4_"+musicId+"?csrf_token=")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0")
                    .header("Accept", "*/*")
                    .header("Cache-Control", "no-cache")
                    .header("Connection", "keep-alive")
                    .header("Host", "music.163.com")
                    .header("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                    .header("DNT", "1")
                    .header("Pragma", "no-cache")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data(JSSecret.getDatas(req_str))
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .timeout(10000)
                    .execute();
            String list = response.body();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String searchMusicList(String typeName,String type){
        try {
//            String music_name="Mi_Chong";
//            String type = "1002";
            UrlParamPair upp = Api.SearchMusicList(typeName,type);
            String req_str = upp.getParas().toJSONString();
            System.out.println("req_str:"+req_str);
            Connection.Response
                    response = Jsoup.connect("http://music.163.com/weapi/cloudsearch/get/web?csrf_token=")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0")
                    .header("Accept", "*/*")
                    .header("Cache-Control", "no-cache")
                    .header("Connection", "keep-alive")
                    .header("Host", "music.163.com")
                    .header("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                    .header("DNT", "1")
                    .header("Pragma", "no-cache")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data(JSSecret.getDatas(req_str))
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .timeout(10000)
                    .execute();
            String list = response.body();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


}
