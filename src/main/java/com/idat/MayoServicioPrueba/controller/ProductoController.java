package com.idat.MayoServicioPrueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.MayoServicioPrueba.dto.ProductoDTORequest;
import com.idat.MayoServicioPrueba.dto.ProductoDTOResponse;
import com.idat.MayoServicioPrueba.service.ProductoService;

@Controller
@RequestMapping( path = "/producto/v1")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<ProductoDTOResponse>>  listar() {
		
		return new ResponseEntity<List<ProductoDTOResponse>>(service.listarProductos(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ProductoDTORequest productos) {
		service.guardarProducto(productos);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		ProductoDTOResponse p =service.obtenerProductoId(id);
		if(p != null) {
			service.eliminarProducto(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody ProductoDTORequest productos) {
		ProductoDTOResponse p =service.obtenerProductoId(productos.getId());
		if(p != null) {
			service.actualizarProducto(productos);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductoDTOResponse> obtenerId(@PathVariable Integer id) {
		ProductoDTOResponse p =service.obtenerProductoId(id);
		if(p != null) {
			return  new ResponseEntity<ProductoDTOResponse>(service.obtenerProductoId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<ProductoDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
