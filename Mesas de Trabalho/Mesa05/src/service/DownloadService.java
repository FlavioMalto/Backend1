package service;

import model.Usuario;

public class DownloadService implements IDownload{
    @Override
    public void baixar(Usuario usuario) {
        System.out.println("Download completo!");
    }
}
