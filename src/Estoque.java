import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Estoque extends Produtos {
  // #region Campos

  private int _id = 0;
  private Double _preco;
  private int _quantia;
  private Double _total;
  private ArrayList<Estoque> lista = new ArrayList<Estoque>();

  // #endregion

  // #region Constructor

  public Estoque() {}

  public Estoque(int id, String nome, String marca, String descricao, double preco, int quantia) {
    SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    setId(id);
    setNome(nome);
    setMarca(marca);
    setDescricao(descricao);
    setDataHora(dataFormatada.format(new Date()));
    this._preco = preco;
    this._quantia = quantia;
  }

  // #endregion

  // #region Metodos

  private ArrayList<Estoque> adicionarListaDecrescente() {
    ArrayList<Estoque> _lista = new ArrayList<Estoque>();

    if (lista.size() > 0) {
      for (int i = 1; i <= lista.size(); i++) {
        _lista.add(lista.get(lista.size() - i));
      }
    }

    return _lista;
  }

  public String alterarProduto(int id, String nome, Double preco, int quantia, String marca, String descricao) {
    String mensagem = "\nErro ao aleterar produto\n";

    if (lista.size() > 0) {
      for (Estoque item : lista) {
        if (item.getId() == id) {
          item.setNome(nome);
          item.setPreco(preco);
          item.setQuantia(quantia);
          item.setMarca(marca);
          item.setDescricao(descricao);
          item.calcularTotal(item.getId(), item.getPreco(), item.getQuantia());
        }
      }

      mensagem = "\nProduto alterado com sucesso\n";
    }

    return mensagem;
  }

  public String cadastrarProduto(String nome, Double preco, int quantia, String marca, String descricao) {
    lista.add(new Estoque(_id, nome, marca, descricao, preco, quantia));
    _id++;

    return "\nProduto gravado com sucesso\n";
  }

  private void calcularTotal(int id, Double preco, int quantia) {
    for (Estoque produto : lista) {
      double total = 0;

      if (produto.getId() == id) {
        total = produto.getPreco() * produto.getQuantia();
        produto.setTotal(total);
      }
    }
  }

  public String listarProdutos() {
    StringBuilder sb = new StringBuilder();

    if (lista.size() > 0) {
      for (Estoque produto : lista) {
        calcularTotal(produto.getId(), produto.getPreco(), produto.getQuantia());
        sb.append(String.format(
            "\n\t\t\t Listagem dos produtos\nId: %s, Produto: %s, Preços: R$%s, Quantidade: %s, Total: R$%s, Data de cadastro: %s, Marca: %s, Descrição: %s\n",
            produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantia(), produto.getTotal(),
            produto.getDataHora(), produto.getMarca(), produto.getDescricao()));
      }
    } else {
      sb.append("\nNenhum registro cadastrado.\n");
    }

    return sb.toString();
  }

  public String exluirProduto(int id) {
    ArrayList<Estoque> _lista = adicionarListaDecrescente();
    String mensagem = "\nErro ao tentar excluir produto\n";

    for (Estoque item : _lista) {
      if (item.getId() == id) {
        lista.remove(id);
        mensagem = "\nProduto excluido com sucesso\n";
        break;
      }
    }

    return mensagem;
  }

  // #endregion

  //#region Propriedades

  public Double getPreco() {
    return _preco;
  }

  public void setPreco(Double preco) {
    this._preco = preco;
  }

  public int getQuantia() {
    return _quantia;
  }

  public void setQuantia(int quantia) {
    this._quantia = quantia;
  }

  public Double getTotal() {
    return _total;
  }

  public void setTotal(Double total) {
    this._total = total;
  }
  
  //#endregion
}