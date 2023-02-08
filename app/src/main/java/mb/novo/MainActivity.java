package mb.novo;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import mb.novo.view.ClienteListaActivity;

public class MainActivity extends AppCompatActivity {
    //Atributos
    //...

    @Override protected void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);
        //Tela Inicial
        setContentView(R.layout.activity_main);

        //Redirecionamento
        Intent intentX = new Intent(this, ClienteListaActivity.class);
        startActivity(intentX);
        //startActivity(new Intent(this, LsCliActivity.class));
    }
}


//strings no xml
//tamanos noxml  = dp