package com.example.weather_app;

import android.os.Bundle;
import android.os.*;
import  android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import  java.net.HttpURLConnection;  // connection between api with ouy app
import java.net.URL; //taking the url input establishment connection
import java.util.concurrent.ExecutionException;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    TextView cityname;
    Button search;
    TextView show;
    String url;

    class getWeather extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... urls){
            StringBuilder result= new StringBuilder(); //here we stored our data
            try{
                URL url=new URL(urls[0]);
                HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
                urlConnection.connect();

                InputStream inputStream=urlConnection.getInputStream();
               BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));

               String line=" ";
               while ((line = reader.readLine()) != null){
                   result.append(line).append("\n");

               }
               return  result.toString();
            } catch (Exception e){
                e.printStackTrace();
                return  null;
            }
        }
        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
            try{
                JSONObject jsonobject =new JSONObject(result);
                String  weatherinformation=jsonobject.getString("main");
                weatherinformation=weatherinformation.replace("temp","temperature");
                weatherinformation=weatherinformation.replace("feels_like","Feels Like");  //real-feel temperature.  wind speed, and air temperature to estimate how the temperature feels to humans.
                weatherinformation=weatherinformation.replace("temp_min","Temperature minimum");
                weatherinformation=weatherinformation.replace("temp_max","Temperature maximum" );
                weatherinformation=weatherinformation.replace("grnd_level","Ground Level" );
                // atmospheric pressure at ground level
                weatherinformation=weatherinformation.replace("{"," " );
                weatherinformation=weatherinformation.replace("}"," " );
                weatherinformation=weatherinformation.replace(","," \n" );
                weatherinformation=weatherinformation.replace(":"," : " );








                show.setText(weatherinformation);
            }
            catch (Exception e){
                e.printStackTrace();

            }

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityname=findViewById(R.id.cityName);
        search=findViewById(R.id.search);
        show=findViewById(R.id.weather);

        final String[] temp= {""};


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"button clicked!",Toast.LENGTH_LONG).show();
                String city= cityname.getText().toString();
                //need a api
                try {
                    if (city != null) {

                        url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=531ebc6b1c683c28cab2c9e2815b5fbf";
                    }else{
                        Toast.makeText(MainActivity.this,"Enter city",Toast.LENGTH_LONG).show();
                    }
                    getWeather task=new getWeather();
                    temp[0]=task.execute(url).get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                catch (InterruptedException e){  // it is used for when we enter invalid city name
                    e.printStackTrace();
                }
                if(temp[0]==null){
                    show.setText("Cannot able to find the weather");
                }

            }
        });

    }
}