package uc.us_security.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uc.us_security.entity.Usuario;
import uc.us_security.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService u;
	
	@PostMapping("/save")
	public ResponseEntity<Usuario> save(@RequestBody Usuario a){
		try {
			Usuario usuario = u.insertarUsuario(a);
			return new ResponseEntity<>(usuario,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>> getAutor(){
		try {
			List<Usuario> list = new ArrayList<>();
			list=u.listarUsuario();
			System.out.println("Pase");
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Usuario> getAutorID(@PathVariable("id") int id){
		Usuario a = u.buscarUsuario(id);
		if (a.getId()>0) {
			return new ResponseEntity<>(a,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/delete/{id}")
		public ResponseEntity<HttpStatus> delete(@PathVariable("id")int id){
			try {
				u.eliminarUsuario(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Usuario> update(@RequestBody Usuario a, @PathVariable("id") int id){
		try {
			System.out.println("Hola");
			Usuario ul = u.buscarUsuario(id);
			if(ul.getId()>0) {
				ul.setUsername(a.getUsername());
				ul.setPassword(a.getPassword());
				ul.setEstado(a.getEstado());
				return new ResponseEntity<>(u.actualizarUsuario(ul),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
