package mb.novo.model;                                      //Pacote    Caminho Arquivo
import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;                                //CI        Serializable

public class ClienteModel implements Serializable {
    //Atributos - API
    @SerializedName("cardId")   private String cardId;
    @SerializedName("name")     private String name;
    @SerializedName("flavor")   private String flavor;
    @SerializedName("type")     private String type;
    @SerializedName("faction")  private String faction;
    @SerializedName("rarity")   private String rarity;
    @SerializedName("img")      private String img;
    @SerializedName("imgGold")  private String imgGold;

    //Atributos - Outros
    private int    uuid;

    //Construtor - Vazio, SemId, ComId, Etc
    public ClienteModel() { }

    //GetterSetter
    public String getCardId() {
        return cardId;
    }
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFlavor() {
        return flavor;
    }
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getFaction() {
        return faction;
    }
    public void setFaction(String faction) {
        this.faction = faction;
    }
    public String getRarity() {
        return rarity;
    }
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getImgGold() {
        return imgGold;
    }
    public void setImgGold(String imgGold) {
        this.imgGold = imgGold;
    }
    public int getUuid() {
        return uuid;
    }
    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    //Lista (ToString)


    @NonNull
    @Override
    public String toString() {
        return "ClienteModel{" +
                "cardId='" + cardId + '\'' +
                ", name='" + name + '\'' +
                ", flavor='" + flavor + '\'' +
                ", type='" + type + '\'' +
                ", faction='" + faction + '\'' +
                ", rarity='" + rarity + '\'' +
                ", img='" + img + '\'' +
                ", imgGold='" + imgGold + '\'' +
                ", uuid=" + uuid +
                '}';
    }
}


//falta descrição curta e imagem, set pertence, ataque, ataque, custo, health
















//atributos primitivos (menos espaço);
// se não regra para setar, então deixar como publico;



//paderia ser parcelable tb

//Classe Entity/Model
//- Herança:            Serializable/Parcelable, P/ Poder Passar Objeto Instanciado Entre Activies;
//- Atributos:          Private e Campos (UserId, Id, Etc);
//- Construtor(3):      Vazio, Sem ID - Salvar, Com ID - Atualizar. Não Colocar Listas;
//- GetterSetter:       Dos Atributos Private (Inclusive das Listas);
//- Métodos Normais:    Void ou Return
//- Métodos Lista:      CRUD (Adicionar Item, Remover Item, Etc);
//- Método ToString:    Debugar Objeto Instanciado, Bem Como a Lista Deste Objeto;

