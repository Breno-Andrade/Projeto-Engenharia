package dominio;

public class Pagamento {
    private int precoQuadraBasica = 40;
    private int precoQuadraCoberta = 70;
    private int custo;

    public int calculadorCusto(int periodo, Object quadraCoberta) {
        if (quadraCoberta == "true"){
            custo = (precoQuadraCoberta*periodo);
            return custo;
        }
        else {
            custo = (precoQuadraBasica*periodo);
            return custo;
        }
    }

    public int getPrecoQuadraBasica() {
        return precoQuadraBasica;
    }
    public void setPrecoQuadraBasica(int precoQuadraBasica) {
        this.precoQuadraBasica = precoQuadraBasica;
    }
    public int getPrecoQuadraCoberta() {
        return precoQuadraCoberta;
    }
    public void setPrecoQuadraCoberta(int precoQuadraCoberta) {
        this.precoQuadraCoberta = precoQuadraCoberta;
    }
}
