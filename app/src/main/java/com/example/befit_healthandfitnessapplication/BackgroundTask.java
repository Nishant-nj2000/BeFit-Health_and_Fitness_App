package com.example.befit_healthandfitnessapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.transform.OutputKeys;

public class BackgroundTask extends AsyncTask<String, String, String>{
    Context context;
    BackgroundTask(Context ctx)
    {
        context=ctx;
    }
    @Override
    protected String doInBackground(String... strings) {
        String type=strings[0];
        String regUrl="http://localhost/signup.php";
        if(type.equals("reg"))
        {
            String email=strings[1];
            String password=strings[2];

            Toast.makeText(context, email, Toast.LENGTH_LONG).show();
            Toast.makeText(context, password, Toast.LENGTH_LONG).show();

            try
            {
                URL url = new URL(regUrl);
                try
                {
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    String insert_data = URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+
                            "&"+URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
                    bufferedWriter.write(insert_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream= httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result="";
                    String line="";
                    StringBuilder stringBuilder = new StringBuilder();
                    while((line=bufferedReader.readLine())!= null)
                    {
                        stringBuilder.append(line).append("\n");
                    }
                    result = stringBuilder.toString();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
        //super.onPostExecute(s);
    }
}
