package service;

import model.Usuario;

public class DownloadProxy implements IDownload{

    private DownloadService downloadService;

    public DownloadProxy(DownloadService downloadService) {
        this.downloadService = downloadService;
    }


    @Override
    public void baixar(Usuario usuario) {
        if(usuario.getTipo().equals("Premium")){
            downloadService.baixar(usuario);
        }else{
            System.out.println("Usuário sem permissão, assine o Premium!");
        }
    }
}
