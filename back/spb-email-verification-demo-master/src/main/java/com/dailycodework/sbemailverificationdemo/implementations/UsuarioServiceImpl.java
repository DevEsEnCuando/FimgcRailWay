//package com.dailycodework.sbemailverificationdemo.implementations;
//
//
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.dailycodework.sbemailverificationdemo.entities.Rol;
//import com.dailycodework.sbemailverificationdemo.entities.Usuario;
//import com.dailycodework.sbemailverificationdemo.repositories.IEscuelaRepository;
//import com.dailycodework.sbemailverificationdemo.repositories.IRolRepository;
//import com.dailycodework.sbemailverificationdemo.repositories.IUsuarioRepository;
//import com.dailycodework.sbemailverificationdemo.services.IUsuarioService;
//
//@Service
//public class UsuarioServiceImpl implements IUsuarioService{
//    @Autowired
//	private IUsuarioRepository usuarioRepository;
//    
//    @Autowired
//	private IEscuelaRepository escuelaRepository;
//    
//    @Autowired
//	private IRolRepository rolRepository;
//
//	@Override
//	public List<Usuario> listarUsuarios() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	@Override
//    public Usuario obtenerUsuarioPorId(Long id) {
//        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
//        return usuarioOptional.orElseThrow();
//    }
//
//	@Override
//	public Usuario register(Usuario entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Usuario updateUsuario(Usuario entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Usuario findUsuarioById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Usuario findUsuarioByUsername(String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Usuario> findUsuarioByEscuela(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//	
//	
//	
//	
//	//J-verificar docentes
//	
//
//    @Override
//    public List<Usuario> getUsersByRoleId(Long roleId) {
//        return usuarioRepository.findByRolId(roleId);
//    }
//	
//    
//    @Override
//    public List<Usuario> buscarDocentesPorNombre(String nombres, Long rolId) {
//        Rol rol = rolRepository.findById(rolId).orElseThrow(() -> new IllegalArgumentException("ID de rol inválido: " + rolId));
//        return usuarioRepository.findByNombresContainingAndRol(nombres, rol);
//    }
//	
//
//}
