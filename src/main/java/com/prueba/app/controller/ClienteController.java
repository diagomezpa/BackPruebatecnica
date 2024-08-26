package com.prueba.app.controller;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.app.dto.ClientDTO;
import com.prueba.app.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:4200") 
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @GetMapping
    public ResponseEntity<ClientDTO> getclient(@RequestParam String documentType, @RequestParam String documentNumber) {

        
        // valida los tipos de documentos sean C o P
        if (!"C".equalsIgnoreCase(documentType) && !"P".equalsIgnoreCase(documentType)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // valida que el numero de documento no sea nulo o vacio
        if (documentNumber == null || documentNumber.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);//400
        }   

        try {
            ClientDTO client = clienteService.getclient(documentType, documentNumber);
            if (client == null) {
                //404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(client);// 200
        } catch (Exception e) {
            // codigo 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }


    }
    
}
