package com.example.martes_18;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.martes_18.webServices.Asynchtask;
import com.example.martes_18.webServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users",
                datos, MainActivity.this, (Asynchtask) MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject JSONlista = new JSONObject(result);
        JSONArray JSONlistaUsuarios= JSONlista.getJSONArray("data");
        ArrayList<Usuario> lstUsuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios);
        AdaptadorUsuario adapatorUsuario = new AdaptadorUsuario(this, lstUsuarios);
        ListView lstOpciones = null;
        lstOpciones.setAdapter((ListAdapter) adapatorUsuario);
    }
}
