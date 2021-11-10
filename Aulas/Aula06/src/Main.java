import service.ISerie;
import service.SerieProxy;
import service.SerieService;

public class Main {
    public static void main(String[] args) {

        String[] series = {"round6", "breakingbad", "strangerthings", "lucifer", "blindspot", "startrek"};

        ISerie link = new SerieProxy(new SerieService());

        for(String serie : series){
            System.out.println(link.getSerie(serie));
        }

    }
}
