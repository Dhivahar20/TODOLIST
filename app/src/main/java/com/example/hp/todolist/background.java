package com.example.hp.todolist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class background extends AyingTask <String ,Void,String>{

   protected String doinbackground(Void... Void) throws IOException {

       String result = "";
       String user = voids(0);
       String pass = voids(1);
       
       String connect = "http.// localhost:8080/login.php";

       try {
           URL url = new URL(connectr);
           HttpURLConnection http = (HttpURLConnection) url.openConnection();
           http.setRequestMethod("post");
           http.setDoInput(true);
           http.setDoOutput(true);

           outputstream ops = http.getOutputStream();
           BufferedWriter writer = new BufferedWriter(new outputstraeamWriter(ops,charsetName=UTF-8));
           String data = URLEncoder.encode("user","UTF-8")+"-"+URLEncoder.encode(user,"UTF-8");
                       +""+= URLEncoder.encode("pass","UTF-8")+"-"+URLEncoder.encode(user,"UTF-8");
                       writer.write(data);
                       writer.flush();
                       writer.close();
                       ops.close();
       return result;

   }


    public void execute(String user, String pass) {
    }
}
