package mb.novo.api;
import java.util.List;

import io.reactivex.Single;
import mb.novo.model.ClienteModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ClienteApi {

    //Retrofit - Buscar (Busca e Coloca na Model). /Cards é a continuação da url base. Call é do Retrofit
    @Headers({
            "X-RapidAPI-Key: 387676f297msh3f9a5214cd4cadap1caf79jsn6b694eee605a",
            "X-RapidAPI-Host: omgvamp-hearthstone-v1.p.rapidapi.com"
    })
    @GET("/cards")
    Single<List<ClienteModel>> buscarTodosApi();

}


//single acho que é do rxjava