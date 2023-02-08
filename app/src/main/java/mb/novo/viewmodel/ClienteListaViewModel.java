package mb.novo.viewmodel;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import mb.novo.model.ClienteModel;
import mb.novo.repository.ClienteRepository;

public class ClienteListaViewModel extends ViewModel {
    //Atributos - API
    private ClienteRepository   clienteRepository;
    private CompositeDisposable disposable;

    //Atributos - LiveData
    public MutableLiveData<String>             titulo_LD;
    public MutableLiveData<List<ClienteModel>> buscarTodosLiveData;
 //   public MutableLiveData<Boolean>            msgErroLiveData;
  //  public MutableLiveData<Boolean>            loadingLiveData;

    //Construtor
    public ClienteListaViewModel(){
        clienteRepository = new ClienteRepository();
    }

    //LiveData (Setter, Getter) - Título
    public void setTitulo() {
        titulo_LD = new MutableLiveData<>();
        titulo_LD.postValue("Lista Clientes");
    }
    public MutableLiveData<String> getTitulo() { return titulo_LD; }

    //LiveData (Load, Getter) - Buscar Todos
    public void loadBuscarTodosViewModel(){
        //     loadingLiveData.setValue(true);

        disposable = new CompositeDisposable();
        buscarTodosLiveData = new MutableLiveData<>();


        disposable.add(
                clienteRepository.buscarTodosRepository()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<List<ClienteModel>>() {
                            @Override public void onSuccess(@NonNull List<ClienteModel> dogModelsX) {
                                Log.d("ListaDogsViewModel", dogModelsX.toString());
                                buscarTodosLiveData.setValue(dogModelsX);
                                //     loadingLiveData.setValue(false);
                           //     msgErroLiveData.setValue(false);
                            }

                            @Override public void onError(@NonNull Throwable e) {
                                //    loadingLiveData.setValue(false);
//                                msgErroLiveData.setValue(true);
                                e.printStackTrace();
                            }
                        })
        );
    }
    public MutableLiveData<List<ClienteModel>> getBuscarTodos() { return buscarTodosLiveData; }


//    public void buscar2(LifecycleOwner lo){
//        List<ClienteModel> listaClientes = new ArrayList<>();
//        buscarTodosLiveData = new MutableLiveData<>();
//
//        MutableLiveData<List<ClienteModel>> listaClientes_LD = new MutableLiveData<>();
//
//        clienteRepository.buscarTodosRepository2().observe(lo, new Observer<List<ClienteModel>>(){
//            @Override public void onChanged(List<ClienteModel> clienteModelsX) {
//                Log.d("myLog ViewModel2", clienteModelsX.toString());
//                listaClientes.addAll((Collection<? extends ClienteModel>) clienteModelsX);
//                listaClientes_LD.postValue(listaClientes);
//            }
//        });
//
//    }


    //Limpar Dados Api
    @Override protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}








//load. chamar no inicio // setter. chamar com ação !!!


