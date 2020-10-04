package filosofos.monitores;

import java.util.Arrays;
import java.util.Random;

public class Filosofo implements Runnable {
    private final Mesa mesa;
    private final int id;

    private final int SEGUNDO = 1000;

    private final int TEMPO_LIMITE_PENSAR = 3;
    private final int TEMPO_LIMITE_COMER = 5;

    private EstadoFilosofo estadoFilosofo;

    public Filosofo(Mesa mesa, int id) {
        this.mesa = mesa;
        this.id = id;
        this.estadoFilosofo = EstadoFilosofo.PENSANDO;

        new Thread(this).start();
    }

    public int[] garfos() {
        return new int[]{this.mesa.garfoDireita(this.id), this.mesa.garfoEsquerda(this.id)};
    }

    public void pensar() {
        System.out.println(this.id + ": Pensando...");
        aguardar(TEMPO_LIMITE_PENSAR);
    }

    public void comer() {
        System.out.println(this.id + ": Comendo :)");
        aguardar(TEMPO_LIMITE_COMER);
    }

    public void pegarGarfos() {
        System.out.println(this.id + ": Aguardando os garfos " + Arrays.toString(this.garfos()) );
        this.mesa.pegarGarfos(this.id);

        System.out.println(this.id + ": Pegou os garfos      " + Arrays.toString(this.garfos()) );
    }

    public void soltarGarfos() {
        this.mesa.soltarGarfos(this.id);

        System.out.println(this.id + ": Soltou os garfos     " + Arrays.toString(this.garfos()) );
    }

    private void aguardar(int tempoLimite) {
        try {
            int tempoAguardo = new Random().ints(SEGUNDO, tempoLimite * SEGUNDO).findFirst().getAsInt();
            Thread.sleep(tempoAguardo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            this.pensar();
            this.pegarGarfos();
            this.comer();
            this.soltarGarfos();
        }
    }
}
