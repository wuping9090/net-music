package com.wp.javax.script;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class JSSecret {
    private static Invocable inv;
    public static final String encText = "encText";
    public static final String encSecKey = "encSecKey";

    /**
     * 从本地加载修改后的 js 文件到 scriptEngine
     */
    static {
        try {
            //第一步先读入js中所有的内容放到String中
//            String filePath = "D:\\StudyResource\\Android\\my-open-project\\net-music\\script-android\\core.js";
            String filePath = "core.js";
            File file = new File(filePath);
            String path = file.getAbsolutePath();
            String path1 = file.getCanonicalPath();
            String path2 = file.getPath();

            InputStream stream = new FileInputStream(file);
            InputStreamReader isreader = new InputStreamReader(stream);
            BufferedReader reader=new BufferedReader(isreader);
            StringBuilder sb=new StringBuilder();
            String line=null;
            while((line=reader.readLine())!=null){
                sb.append(line);
            }
            reader.close();
//            Path path = Paths.get("core.js");
//            byte[] bytes = Files.readAllBytes(path);
//            String js = new String(bytes);
            String js = sb.toString();
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByName("JavaScript");
            engine.eval(js);
            inv = (Invocable) engine;
            System.out.println("Init completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ScriptObjectMirror get_params(String paras) throws Exception {
        ScriptObjectMirror so = (ScriptObjectMirror) inv.invokeFunction("myFunc", paras);
        return so;
    }

    public static HashMap<String, String> getDatas(String paras) {
        try {
            ScriptObjectMirror so = (ScriptObjectMirror) inv.invokeFunction("myFunc", paras);

//            Set<Map.Entry<String, Object>> entries = so.entrySet();
//            for (Map.Entry<String,Object> map: entries) {
//                System.out.println("key:"+map.getKey());
//                System.out.println("value:"+map.getValue());
//            }
//

            HashMap<String, String> datas = new HashMap<>();
            datas.put("params", so.get(JSSecret.encText).toString());
            datas.put("encSecKey", so.get(JSSecret.encSecKey).toString());
            return datas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

