//package com.dailycodework.sbemailverificationdemo.user;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/logouts")
//@CrossOrigin(origins = "http://localhost:5173")
//public class LogoutController {
//    @Autowired
//    private IUserService userService;
//
//    @PostMapping
//    public ResponseEntity<?> logout(@RequestBody LogoutRequest logoutRequest) {
//        String email = logoutRequest.getEmail();
//        String password = logoutRequest.getPassword();
//        String token = logoutRequest.getToken();
//
//        try {
//            // Validar las credenciales del usuario
//            if (userService.validateCredentials(email, password)) {
//                // Llamar al servicio para invalidar o eliminar el token de inicio de sesión
//                userService.invalidateLoginToken(token);
//
//                // Devolver una respuesta exitosa al cliente
//                return ResponseEntity.ok("Logout exitoso.");
//            } else {
//                // Las credenciales no son válidas
//                String errorMessage = "Credenciales inválidas. El logout no puede ser realizado.";
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(errorMessage));
//            }
//        } catch (Exception e) {
//            // Manejar cualquier excepción que pueda ocurrir
//            String errorMessage = "Error al procesar la solicitud de logout.";
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(errorMessage));
//        }
//    }
//}
