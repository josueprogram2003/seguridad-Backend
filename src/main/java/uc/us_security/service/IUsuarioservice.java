package uc.us_security.service;

import java.util.List;
import uc.us_security.entity.Usuario;

public interface IUsuarioservice {
	Usuario insertarUsuario(Usuario u);
	List<Usuario> listarUsuario();
	Usuario buscarUsuario(int id);
	void eliminarUsuario(int id);
	Usuario actualizarUsuario(Usuario u);
	
}
