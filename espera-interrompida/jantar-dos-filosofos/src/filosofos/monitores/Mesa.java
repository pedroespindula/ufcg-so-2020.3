package filosofos.monitores;

import java.util.Arrays;

public class Mesa {
    private int quantidadeGarfos;
    private boolean[] garfos;

    public Mesa(int quantidadeGarfos) {
        this.quantidadeGarfos = quantidadeGarfos;
        this.garfos = new boolean[this.quantidadeGarfos];

        Arrays.fill(this.garfos, false);
    }

    public int garfoEsquerda(int idFilosofo) {
        return idFilosofo;
    }

    public int garfoDireita(int idFilosofo) {
        return idFilosofo - 1 < 0 ? this.quantidadeGarfos - 1 : idFilosofo - 1;
    }

    private boolean garfosDisponiveis(int idFilosofo) {
        return !this.garfos[this.garfoDireita(idFilosofo)] &&
               !this.garfos[this.garfoEsquerda(idFilosofo)];
    }

    public void pegarGarfos(int idFilosofo) {
        if (this.garfosDisponiveis(idFilosofo)) {
            this.garfos[this.garfoEsquerda(idFilosofo)] = true;
            this.garfos[this.garfoDireita(idFilosofo)] = true;
        }
    }

    public void soltarGarfos(int idFilosofo) {
        this.garfos[this.garfoEsquerda(idFilosofo)] = false;
        this.garfos[this.garfoDireita(idFilosofo)] = false;
    }
}
