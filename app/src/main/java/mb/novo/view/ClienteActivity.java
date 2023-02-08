package mb.novo.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import mb.novo.R;
import mb.novo.databinding.ActivityClienteBinding;
import mb.novo.model.ClienteModel;
import mb.novo.viewmodel.ClienteViewModel;

public class ClienteActivity extends AppCompatActivity {
    private ActivityClienteBinding  binding;            //Tela XML
    private ClienteViewModel        clienteViewModel;   //Camada ViewModel
    private ClienteModel            clienteModel;       //Camada Model

    //Método Inicial
    @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);
        //TelaXml, ViewModel, Contexto
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cliente);
        clienteViewModel = new ViewModelProvider(this).get(ClienteViewModel.class);

        //Receber Objetos
        Intent intentVindo = getIntent();
        if(intentVindo.getExtras() != null){
            //Objeto - Receber
            clienteModel = (ClienteModel) intentVindo.getExtras().getSerializable("chaveCliente");

            //Objeto - Setar Via Data Binding
            binding.setClienteModel(clienteModel);

            //Objeto - Manipular Via onClickListener (Evento)
            binding.btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Botão Salvar", Toast.LENGTH_LONG).show();
            }});
        }
    }

    //Evento - Manipular Via Método do Objeto (cada objeto tem um método void)
    public void cli_btn_deletar_xml(View view) {
        Toast.makeText(getBaseContext(), "Botão Deletar", Toast.LENGTH_LONG).show();
    }

    //Evento - Manipular Via Método do DataBinding (1 método para todos os eventos dos objeto)
    public class EventosObjetos_DB{
    }
}

//objeto setado com DataBidning, mas poderia com o viewbinding
//eventos via setonclick on create, método void do objeto, 1 metodo data binding.   metodo próprio. atenção viewbinding!!!

//nomes sem under line. padrão comel case !!!

//setar databind. eh a set + variável !!!

