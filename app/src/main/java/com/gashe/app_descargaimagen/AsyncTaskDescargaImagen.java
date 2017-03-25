package com.gashe.app_descargaimagen;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cice on 25/3/17.
 */

public class AsyncTaskDescargaImagen extends AsyncTask<String, Void, Bitmap[]> {

    private Context context;

    public AsyncTaskDescargaImagen(Context context) {
        this.context = context;
    }

    @Override
    protected Bitmap[] doInBackground(String... url) {

        //VARARGS STRING ... string -> número indeterminado de parametro, éste un array de string
        Bitmap[] bitmap = new Bitmap[url.length];
        String url_image = null;
        URL object_url = null;
        HttpURLConnection http = null;
        int response = -5;
        InputStream inputStream = null;


        try {

            for(int i = 0; i < url.length; i++) {

                url_image = url[i];
                object_url = new URL(url_image);
                http = (HttpURLConnection) object_url.openConnection();
                // http.setRequestMethod("GET"); por defecto hace esto (get) con openConnection();

                response = http.getResponseCode();
                if (response == HttpURLConnection.HTTP_OK) {
                    Log.d("MENSAJE", "Todo OK");
                    inputStream = http.getInputStream();
                    bitmap[i] = BitmapFactory.decodeStream(inputStream);
                } else {
                    Log.d("MENSAJE", "Algo fue mal");
                }

            }

        }catch (Throwable t){

            Log.d("MENSAJE", "Algo fue mal" + t);

        }finally {
            http.disconnect();
        }

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap[] bitmap) {

        Log.d("MENSAJE", "Tarea de descarga finalizada");
        MainActivity activity = (MainActivity) context;
        activity.drawImage(bitmap);

        super.onPostExecute(bitmap);
    }


}
