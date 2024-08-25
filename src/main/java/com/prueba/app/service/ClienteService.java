package com.prueba.app.service;

import org.springframework.stereotype.Service;

import com.prueba.app.dto.ClientDTO;

@Service
public class ClienteService {

  public ClientDTO getclient(String documentType, String documentNumber) {
    
    if("C".equalsIgnoreCase(documentType) && "23445322".equalsIgnoreCase(documentNumber)) {
      ClientDTO client = new ClientDTO();
      client.setPrimerNombre("Juan");
      client.setSegundoNombre("Carlos");
      client.setPrimerApellido("Perez");
      client.setSegundoApellido("Gomez");
      client.setTelefono("1234567");
      client.setDireccion("Calle 123");
      client.setCiudad("Bogota");
      return client;
    }

    return null;

  } 

	
}
