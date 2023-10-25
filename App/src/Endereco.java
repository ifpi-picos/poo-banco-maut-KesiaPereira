public class Endereco {
    
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String uf;
    private Cliente cliente;

    public Endereco(String logradouro, int numero, String bairro, String cidade, String uf){
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getLogradouro(){
        return logradouro;
    }

    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public String getBairro(){
        return bairro;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    public String getCidade(){
        return cidade;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    @Override
    public String toString(){
        return "\nLogradouro: " + this.getLogradouro() +
               "\nNumero: " + this.getNumero() + 
               "\nBairro: " + this.getBairro() +
               "\nCidade: " + this.getCidade() +
               "\nUf: " + this.getUf();
    }
}
