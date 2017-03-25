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
        asyncTaskDescargaImagen.execute(URL_IMAGE);

        Log.d("MENSAJE", "Tarea descargada lanzada");
    }

    public void drawImage(Bitmap bitmap){

        Button button = (Button)findViewById(R.id.getImage);
        button.setEnabled(true);
        ImageView imageView = (ImageView)findViewById(R.id.myImage);
        imageView.setImageBitmap(bitmap);

        Log.d("MENSAJE", "Imagen seteada");
    }

}
