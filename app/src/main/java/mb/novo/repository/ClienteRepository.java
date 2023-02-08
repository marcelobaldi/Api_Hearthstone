package mb.novo.repository;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import mb.novo.R;
import mb.novo.api.ClienteApi;
import mb.novo.model.ClienteModel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Headers;

public class ClienteRepository {
    //Atributos
    private static final String BASE_URL = "https://omgvamp-hearthstone-v1.p.rapidapi.com";
    private ClienteApi clienteApi;
    private MutableLiveData<List<ClienteModel>> listaClientesLD;

    //Construtor
    public ClienteRepository() {
        clienteApi = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ClienteApi.class);
    }

    //Buscar Todos
    public Single<List<ClienteModel>> buscarTodosRepository(){
        Log.d("ListaDogsRepository", clienteApi.buscarTodosApi().toString());
        return clienteApi.buscarTodosApi();
    }

}

