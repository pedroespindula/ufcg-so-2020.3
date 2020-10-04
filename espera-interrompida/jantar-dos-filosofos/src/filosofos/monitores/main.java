package filosofos.monitores;

public class main {
    private static final int garfos = 5;

    public static void main(String[] args) {
        Mesa mesa = new Mesa(garfos);

        Filosofo[] filosofos = new Filosofo[garfos];

        for (int i = 0; i < filosofos.length; i++) {
            filosofos[i] = new Filosofo(mesa, i);
        }
    }
}
