package com.idat.MayoServicioPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.idat.MayoServicioPrueba.model.Cliente;



@RepositoryRestResource(path = "cliente")
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

}
