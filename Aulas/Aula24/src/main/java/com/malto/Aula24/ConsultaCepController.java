package com.malto.Aula24;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultaCepController {

    @GetMapping("/{cep}")
    public String getCep(@PathVariable String cep) throws UnirestException {

        HttpResponse<JsonNode> jsonReponse = Unirest.get("https://viacep.com.br/ws/"+cep+"/json/").asJson();

        JSONObject jsonObject = jsonReponse.getBody().getObject();

        return jsonObject.toString();
    }

}
