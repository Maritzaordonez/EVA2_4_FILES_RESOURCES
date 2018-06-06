package edu.tectii.eva2_4_files_resources;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Principal extends AppCompatActivity {
    TextView txtArchivo;

    @Override
    protected void onStart() {
        super.onStart();
        //vamos a leer el archivo
        //abrir el archivo
        InputStream isAbrir = getResources().openRawResource(R.raw.miarchivo);
        //acceder el contenido leer archivo
        InputStreamReader isrLeerBytes = new InputStreamReader(isAbrir);
        //trabajar con el texto
        BufferedReader brLeerTexto = new BufferedReader(isrLeerBytes);
        try {
            String sCade;
            while ((sCade = brLeerTexto.readLine()) !=null) {
                txtArchivo.append(sCade);
                txtArchivo.append("\n");
            }
            brLeerTexto.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtArchivo = (TextView)findViewById(R.id.txtArchivo);
    }
}
