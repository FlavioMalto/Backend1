package com.malto.Aula30.repository;

import com.malto.Aula30.model.Jogador;
import com.malto.Aula30.model.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

    //select * from jogador where treinador_id = id
    //?1 indica que é o primeiro atributo recebido no método
    //no caso o primeiro atributo de treinador é o id
    @Query("select j.nome from Jogador j where j.treinador = ?1")
    List<String> findAllJogadoresPorTreinador(Treinador treinador);

}
