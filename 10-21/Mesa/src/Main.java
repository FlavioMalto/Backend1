import model.Usuario;
import service.DownloadProxy;
import service.DownloadService;
import service.IDownload;

public class Main {
    public static void main(String[] args) {

        Usuario usuario1 = new Usuario(1, "Free");
        Usuario usuario2 = new Usuario(2, "Premium");

        IDownload download = new DownloadProxy(new DownloadService());

        download.baixar(usuario1);
        download.baixar(usuario2);

    }

}
