package com.gashe.app_descargaimagen;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String URL_IMAGE = "http://static.vueling.com/cms/media/1216759/cadiz.jpg";
    private static final String URL_IMAGE2 = "http://www.oleandalucia.com/wp-content/uploads/2015/10/portada-post-cadiz-e1445201826830.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getImage(View view){

        Log.d("MENSAJE", "Toco el botón");

        view.setEnabled(false);
        AsyncTaskDescargaImagen asyncTaskDescargaImagen = new AsyncTaskDescargaImagen(this);
        //asyncTaskDescargaImagen.execute(URL_IMAGE).get() -> fuerzo a que sea sincrono y no se ejecuta las siguientes lineas.
        asyncTaskDescargaImagen.execute(URL_IMAGE, URL_IMAGE2);

        Log.d("MENSAJE", "Tarea descargada lanzada");
    }

    public void drawImage(Bitmap[] bitmap){

        Button button = (Button)findViewById(R.id.getImage);
        button.setEnabled(true);
        ImageView imageView = null;
        int imgres = 0;
        for(int i = 0; i < bitmap.length; i++) {

            imgres = getResources().getIdentifier("myImage" + i, "id", "com.gashe.app_descargaimagen");
            imageView = (ImageView) findViewById(imgres);

            imageView.setImageBitmap(bitmap[i]);
        }

        Log.d("MENSAJE", "Imagen seteada");
    }

}
