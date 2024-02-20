public abstract class Produtos {
    // #region Campos

    private int _id;
    private String _marca;
    private String _nome;
    private String _dataHora;
    private String _descricao;

    // #endregion
    
    // #region Propriedades

    public String getDataHora() {
        return _dataHora;
    }

    public void setDataHora(String dataHora) {
        this._dataHora = dataHora;
    }

    public String getDescricao() {
        return _descricao;
    }

    public void setDescricao(String descricao) {
        this._descricao = descricao;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getMarca() {
        return _marca;
    }

    public void setMarca(String marca) {
        this._marca = marca;
    }

    public String getNome() {
        return _nome;
    }

    public void setNome(String nome) {
        this._nome = nome;
    }

    // #endregion
}