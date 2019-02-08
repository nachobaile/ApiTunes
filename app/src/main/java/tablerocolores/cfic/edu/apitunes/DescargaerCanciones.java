package tablerocolores.cfic.edu.apitunes;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DescargaerCanciones extends AsyncTask<String,Void,ResultadoCanciones> {


    private MainActivity ma;

    public DescargaerCanciones(MainActivity ma){

        this.ma =ma;

    }


//https://itunes.apple.com/search/?media=music&term=chiquetete
    private static final String URI_ITUNES = "https://itunes.apple.com/search/?media=music&term=";





// En este método hacemos la conexión y recuperamos los datos.
    @Override
    protected ResultadoCanciones doInBackground(String ... canciones) {
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        ResultadoCanciones resultadoCanciones = null;
        InputStreamReader is = null;
        Gson gson = null;

        //intentamos algo
       try{

           url = new URL(URI_ITUNES + canciones[0]);
           //httpURLConnection.setRequestMethod("GET");  por defecto siempre es GET, si no hay que poner POST.
           httpURLConnection = (HttpURLConnection)url.openConnection();

           if (httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK){
               //la respuesta fue buena
               String ct = httpURLConnection.getContentType();
               Log.d("MIAPP","TIPO MIME RX " + ct);
               is = new InputStreamReader( httpURLConnection.getInputStream());//accedo l cuerpo del mensaje.
               gson= new Gson();
               resultadoCanciones= gson.fromJson(is,ResultadoCanciones.class);
           }

       }catch (Exception e)//si falla se viene aquí
       {
           Log.e("MIAPP","Error al comunicar con Itunes",e);

       }finally //falle o no, hará el esto
       {

           try {
               is.close();
           } catch (IOException e) {
              Log.e("MIAPP","Error al cerrar",e);
           }

           httpURLConnection.disconnect();

       }




        return resultadoCanciones;
    }
//Este método será invocado cuando acaba doInBackground.
    @Override
    protected void onPostExecute(ResultadoCanciones rc) {
        super.onPostExecute(rc);

        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        String string_canciones = gson.toJson(rc);


       Log.d("MIAPP", "CANCIONES = " + string_canciones);
       this.ma.mostrarResultados(rc);
    }
}



