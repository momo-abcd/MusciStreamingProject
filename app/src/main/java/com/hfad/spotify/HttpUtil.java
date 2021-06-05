package com.hfad.spotify;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InterfaceAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class HttpUtil extends AsyncTask<String, JSONObject, String> {
    private RecyclerView recyclerView;
    private JSONObject resJson = null;
    public HttpUtil(RecyclerView recyclerView) {
        super();
        this.recyclerView = recyclerView;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL("http://121.146.42.126:3008/musicList");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); //전송방식
            connection.setRequestProperty("User-Agent","Mozilla/5.0" );
            connection.setDoInput(true);        //데이터를 읽어올지 설정

            InputStream is = connection.getInputStream();
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String result;
            while((result = br.readLine())!=null){
                sb.append(result+"\n");
            }

            resJson = new JSONObject(sb.toString());
            result = sb.toString();
            publishProgress(resJson);
            int responseCode = connection.getResponseCode();
            Log.i("myData555",result);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("not JSON Format response");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(JSONObject... values) {
        ArrayList<MusicList> list = new ArrayList<>();

        for(int i=0;i<5;i++){

            JSONObject value = values[0].optJSONObject(Integer.toString(i+1));
            list.add(new MusicList(value.optString("elbumImg"),Integer.toString(i+1),value.optString("title"), value.optString("singer")));
        }
         SimpleTextAdapter adapter = new SimpleTextAdapter(list);
        recyclerView.setAdapter(adapter);

        Log.i("myData1123",""+values[0].getClass().getName());
        Log.i("myData1125",""+values[0].optJSONObject("1").getClass().getName());
    }
}