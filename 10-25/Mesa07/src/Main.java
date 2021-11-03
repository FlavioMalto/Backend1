import model.Arvore;

public class Main {

    public static void main(String[] args) {
        ArvoreFactory factory = new ArvoreFactory();

//        Arvore florifera = factory.buscarArvore(100, 200, "azul");

        for(int i=0; i<500000; i++){
            Arvore ornamental = factory.buscarArvore(200, 400, "verde");
            Arvore frutifera = factory.buscarArvore(500, 300, "vermelha");
        }

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    }

}
