package com.gashe.app_descargaimagen;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by cice on 25/3/17.
 */

public class AsyncTaskDescargaImagen extends AsyncTask<String, Void, Bitmap> {

    private Context context;

    public AsyncTaskDescargaImagen(Context context) {
        this.context = context;
    }

    @Override
    protected Bitmap doInBackground(String... url) {

        //VARARGS STRING ... string -> número indeterminado de parametro, éste un array de string
        Bitmap bitmap = null;
        String url_image = null;


        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {

        Log.d("MENSAJE", "Tarea de descarga finalizada");
        MainActivity activity = (MainActivity) context;
        activity.drawImage(bitmap);

        super.onPostExecute(bitmap);
    }


}
