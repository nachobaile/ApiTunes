package tablerocolores.cfic.edu.apitunes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String artista = "Julio";
        new DescargaerCanciones(this).execute(artista);

    }

    public void mostrarResultados(ResultadoCanciones rc)
    {
        findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
        Toast.makeText(this, "DESCARGA FINALIZADA CON ÉXITO INFINITO", Toast.LENGTH_SHORT).show();

        //TODO CON LOS DATOS OBTENIDOS(ResultadoCanciones)
        //HACED UN RECYCLERVIEW QUE MUESTRE artistId, nombre y nombre_cancion.
    }

}
