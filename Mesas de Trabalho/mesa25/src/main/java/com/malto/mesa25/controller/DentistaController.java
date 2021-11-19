package com.malto.mesa25.controller;

import com.malto.mesa25.dao.DentistaDAO;
import com.malto.mesa25.model.Dentista;
import com.malto.mesa25.model.Paciente;
import com.malto.mesa25.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dentista")
public class DentistaController implements ControllerInterface<Dentista, DentistaDAO> {

    @Autowired
    private DentistaService dentistaService;

    @Override
    public ResponseEntity<Map<Integer, Dentista>> getMethod() {
        return ResponseEntity.status(HttpStatus.OK).body(dentistaService.buscar());
    }

    @Override
    public ResponseEntity<String> deleteMethod(Integer id) {
        dentistaService.deletar(id);

        //.ok = .status(HttpStatus.OK)
        return ResponseEntity.ok("Deletado com sucesso");
    }

    @Override
    public ResponseEntity<Dentista> postMethod(DentistaDAO dao) {
        Dentista dentista = dentistaService.criar(dao);

        if(dentista == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(dentista);
    }

    @Override
    public ResponseEntity<Dentista> putMethod(DentistaDAO dao) {
        //.status(200) = .status(HttpStatus.OK)
        return ResponseEntity.status(200).body(dentistaService.editar(dao));
    }
}
