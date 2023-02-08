package mb.novo.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mb.novo.R;
import mb.novo.adapter.ClienteListaAdapter;
import mb.novo.databinding.ActivityClienteListaBinding;
import mb.novo.model.ClienteModel;
import mb.novo.repository.ClienteRepository;
import mb.novo.viewmodel.ClienteListaViewModel;

public class ClienteListaActivity extends AppCompatActivity {
    //Atributos
    private ActivityClienteListaBinding binding;
    private ClienteListaViewModel       clienteListaViewModel;
    private ClienteListaAdapter         listaClienteAdapter;
    private ArrayList<ClienteModel>     listaCliente        = new ArrayList<ClienteModel>();
    private LinearLayoutManager         listaLayout         = new LinearLayoutManager(this);

    //Método Inicial
    @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);
        //TelaXml, ViewModel
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cliente_lista);
        clienteListaViewModel = new ViewModelProvider(this).get(ClienteListaViewModel.class);

        //Carregamento Inicial  (Setter's)
        clienteListaViewModel.setTitulo();
        clienteListaViewModel.loadBuscarTodosViewModel();

        //Listener's            (Getter's)
        observers();
    }

    //Listener's
    public void observers(){
        //Título
        clienteListaViewModel.getTitulo().observe(this, new Observer<String>() {
            @Override public void onChanged(String sX) {
                binding.txtTitulo.setText(sX);
            }
        });

        //Lista - Conteúdo
        clienteListaViewModel.getBuscarTodos().observe(this, new Observer<List<ClienteModel>>() {
            @Override public void onChanged(List<ClienteModel> clienteModelsX) {
                Log.d("myLog Activity", clienteModelsX.toString());
                listaCliente.addAll(clienteModelsX);

                //Lista - Adapter
                listaClienteAdapter = new ClienteListaAdapter();
                listaClienteAdapter.atualizarLista(listaCliente);
                binding.recycleListaClientes.setAdapter(listaClienteAdapter);

                //Lista - Layout (Vertical ou Horizontal). Se Horizontal, Descomentar o Código Abaixo
                //listaLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                binding.recycleListaClientes.setLayoutManager(listaLayout);
            }
        });
    }

}


//this é para passar o contexto























//Observações Gerais
//- Requisitos:			ArrayList com Classe;
//- Conteúdo Linha:     String, Integer, Imagem, Botão Comando;
//- Ação Linha:         Na Linha e/ou Nos Objetos da Linha;
//- RecyclerView:       Lista Utilizada. Tem a ListView, Mas Não é Padrão e Da Leg Carregamento
//- Orientation:        Utilizado Na Ordem Vertical no Layout (Xml), Mas Funcionou Sem Também
//- ScrollView:         Não Utilizada Barra de Rolagem no Layout (Xml), Pois a RecyclerView Já Tem
//- Traço Linha:        Utilizado o Objeto View no Layout (XML). Poderia Ficar Sem o Traço Também
//- Imagens:            Colar os Arquivos na Pasta Res/Drawable
//* ArrayList:          Aqui Esta Em Quem Utiliza (View, Controller,Etc)    Fazer Na Model           ***
//* Recolher/Expandir:  Tem o Modelo de Listas Recolhidas/Expandidas.       Fazer Este Modelo        ***
//* Com CardView:       Tem o Modelo de Linhas Estilo Cartões.              Fazer Este Modelo        ***

////////////////////////////////////////////////////////////////////////////////////////////////////

//Recycleview (No XML)
//- Antes Funcionava:   android.support.v7.widget.RecyclerView
//- Agora Só Assim:     androidx.recyclerview.widget.RecyclerView

////////////////////////////////////////////////////////////////////////////////////////////////////

//Manifest e Libs
//- Manifest:           Não Aplicável;
//- Build Gradle Mod:   RecyclerView, Embora Testei Sem e Funcionou;
//* Observação:         Se Converter P/ AndroidX, Alertas no Gradle Podem Desaparecer, Mas Objetos
//                      no XML Poderão Ñ Funcionar (aí terá que converter o objeto p/ AndroidX tb)

////////////////////////////////////////////////////////////////////////////////////////////////////

//Lista (Estrutura)
//- Quantidade Arquivos:    7
//- Arquivos Lista:         5       View, Adapter, Entity/Model, Xml View, Xml Linha Lista
//- Arquivos Item:          2       View e Xml View

//- View:                   Java    Programação Tela        (Chama a Programação da Lista, Etc)
//- Adapter:                Java    Programação Lista       (Contem a Sub Classe Holder Tambem)
//- Entity/Model:           Java    Campos Objeto           (Com Serializable ou Parcelable)
//- Layout Tela:            XML     Lista e Outros          (ConstraintLayout e LinearLayout Juntos)
//- Layout Linha Lista:     XML     Conteúdo Linha          (LinearLayout Só)

////////////////////////////////////////////////////////////////////////////////////////////////////

//Lista (Etapas)
//- Manifest:               Não Necessário
//- Build Gradle Project:   Não Necessário
//- Build Gradle Module:    Lib RecyclerView                (Embora Testei Sem e Funcionou)
//- Classe Entity/Model:
//- Layout Linha Lista:
//- Layout Tela Lista:
//- Classe Adapter:
//- Classe View:
//* Fazer Arqu. de Layout (XML) Antes das Classes Java, Sendo as Linhas Primeiro e Depois as Listas;
//* Fazer o Item da Lista Depois (Classe do Item e Arquivo XML do Item)

////////////////////////////////////////////////////////////////////////////////////////////////////

//Linha Lista
//- Nome Arquivo:           Adapter Xml
//- Template - Tipo:        Constraint, Mas Poderia Ser LinearLayout, RelativeLayout, Etc;
//- Template - Tamanho:     Width (Match) e Height (Wrap)                                            ***
//* Observação:             No Layout, DEVE Ser Exibido a Simulação de 1 Linha !!!

//Lista
//- Nome Arquivo:           Activity Xml
//- Template - Tipo:        ConstraintLayout e LinearLayout (eu prefiro assim)
//- Template - Tamanho:     Width (Match) e Height (Match)                                           ***
//* Observação:             No Layout, DEVE Ser Exibido a Simulação de VÁRIAS LINHAS IGUAIS !!!

////////////////////////////////////////////////////////////////////////////////////////////////////

//XML - Tools:Context
//- Conceito:           Configuração Nos Templates do XML (Caminho da Respectiva Classe Java);
//- Observação:         No Arquivo XML de Itens da Linha Eu Não Utilizo;                             ***

//XML - Android:Id
//- Conceito:           Identificação do Template Deste Arquivo e dos Objetos Deste Arquivo;
//- Observação:         Caso Tal Objeto Não Seja Manipulado, Então Não Precisa, mas recomendado ter;

//XML - Width/Height
//- Conceito:           É o Tamanho do Template e Objetos (Width - Comprimento e Heigth - Altura)
//- Observação1:        Match (Espaço Total) ou Wrap (Só o Necessário) ou "Tamanho Definido" (-20sp)
//- Observação2:        Recomendado Utilizar o Tamanho com o "SP", Podendo Ser Positivo ou Negativo;

//XML - Posição:
//- Conceito:           É o Alinhamento e Posição dos Objetos na Tela;
//- Observação1:        Layout_Margin, Padding, Gravity, Layout_Gravity, TextAlignment
//- Observação2:        Recomendado Utilizar o Tamanho com o "SP", Podendo Ser Positivo ou Negativo
//- Observação3:        Se Utilizado o Constraint no Template e os "Apps" no Objeto, é Só Arrastar


