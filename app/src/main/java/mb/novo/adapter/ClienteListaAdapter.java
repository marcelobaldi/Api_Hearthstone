package mb.novo.adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import mb.novo.R;
import mb.novo.databinding.AdapterClienteListaBinding;
import mb.novo.model.ClienteModel;
import mb.novo.view.ClienteActivity;

public class ClienteListaAdapter extends RecyclerView.Adapter<ClienteListaAdapter.ClienteListaHolder> {
    //Atributos
    private Context            contexto;                          //Contexto (Pego Aqui do Adapter!)
    private List<ClienteModel> listaClientes = new ArrayList<>();

    //Lista - Conteúdo
    public void atualizarLista(List<ClienteModel> listaClientesV){
        listaClientes.clear();                                 //Lista - Limpar
        listaClientes.addAll(listaClientesV);                  //Lista - Setar
        notifyDataSetChanged();                                //Lista - Atualizar
    }

    //Lista - Tamanho
    @Override public int getItemCount() {
        return listaClientes.size();
    }

    //Linha - Configuração (Arquivo XML)
    @NonNull @Override public ClienteListaHolder onCreateViewHolder(@NonNull ViewGroup pX, int viewType){
        //Inflater
        LayoutInflater inflaterX = LayoutInflater.from(pX.getContext());

        //Arquivo XML (ViewBinding)
        AdapterClienteListaBinding adpLinha = AdapterClienteListaBinding.inflate(inflaterX, pX, false);

        //Contexto (Pego Aqui do Adapter!)
        contexto = pX.getContext();

        //Classe Holder
        return new ClienteListaHolder(adpLinha);
    }

    //Linha - Configuração (Objetos do Arquivo Xml)
    @Override public void onBindViewHolder(@NonNull ClienteListaHolder holderX, @SuppressLint("RecyclerView") int positionY) {
        //Objetos - Setar
        ClienteModel clienteModel = listaClientes.get(positionY);
        holderX.bindingAdapter.nomeAdpt.setText(clienteModel.getName());
//        holderX.bindingAdapter.idadeAdpt.setText(String.valueOf(clienteModel.getIdade()));
//        holderX.bindingAdapter.imagemAdpt.setImageResource(clienteModel.getImagem());

        //Linha - Ação nos Objetos
//        holderX.bindingAdapter.nomeAdpt.setOnClickListener(new View.OnClickListener() {
//            @Override public void onClick(View view) {
//                Toast.makeText(contexto, listaClientes.get(positionY).getNome(),Toast.LENGTH_LONG).show();
//            }
//        });

        //Linha - Ação na Linha (itemView)
//        holderX.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override public void onClick(View view) {
//                Intent intentX  = new Intent(contexto, ClienteActivity.class);
//                intentX.putExtra("chaveCliente", listaClientes.get(positionY));
//                contexto.startActivity(intentX);
//            }
//        });
    }

    //Linha - Identificação (Arquivo Xml)
    public static class ClienteListaHolder extends RecyclerView.ViewHolder{
        //Atributos
        public AdapterClienteListaBinding bindingAdapter;           //Arquivo XML (ViewBinding)

        //Construtor
        public ClienteListaHolder(AdapterClienteListaBinding adpBinding) {
            super(adpBinding.getRoot());
            this.bindingAdapter = adpBinding;
        }
    }
}


//metodos setonclick pode ser em lambda;




//Classe Adapter
//- Conceito:       Configuração da Respectiva Lista Recyclerview;
//- Observação:     Receber a Lista do Objeto e o Contexto (poderes activity - Toast, Intent)

////////////////////////////////////////////////////////////////////////////////////////////////////

//Criar Classe Adapter
//- Criar Classe Java Normal
//- Fazer Herança da Classe Interna RecyclerView.Adapter, Contendo Sua Sub Classe Holder
//- Implementar os 3 Métodos Sugeridos Pela IDE (OnCreateViewHolder, OnBindViewHolder, GetItemCount)
//* A Sua Sub Classe Holder Ainda Não Existe, Mas Necessita Ser Criada (Conforme o Nome Dado);

////////////////////////////////////////////////////////////////////////////////////////////////////

//Criar Classe Secundária Holder
//- Criar Sub Classe Holder, Com o Mesmo Nome Informado na Herança da Sua Classe;
//- Identificar Objetos da Linha da Lista (Declarar como atributos desta sub classe);
//- Criar Construtor Vazio Desta Sub Classe, e Correlacionar (Atributos Declarados x Objetos XML)
//* Esta Sub Classe Poderia Estar Em Arquivo Separado Também (eu não prefiro)

////////////////////////////////////////////////////////////////////////////////////////////////////

//Atributos e Construtor
//- Atributos:      Lista do Objeto (Dados) e Contexto (Variável Com Poder Activity - Toast, Intent)
//- Construtor:     Com Tais Atributos, Para Quando Esta Classe For Instanciada, Já os Passar;
//* Observação:     Alguns Comandos da Activity (startActivity), Agora São Via Contexto Recebido;

////////////////////////////////////////////////////////////////////////////////////////////////////

//- OnCreateViewHolder:     Arquivo XML (Linha da Lista) e Sua Sub Classe Holder
//- OnBindViewHolder:       Configuração da Linha da Lista
//- GetItemCount:           Tamanho da Lista


