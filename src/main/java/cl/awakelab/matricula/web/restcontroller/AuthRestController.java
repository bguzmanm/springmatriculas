package cl.awakelab.matricula.web.restcontroller;

import cl.awakelab.matricula.model.domain.dto.AuthenticationRequest;
import cl.awakelab.matricula.model.domain.dto.AuthenticationResponse;
import cl.awakelab.matricula.model.domain.service.UserService;
import cl.awakelab.matricula.web.security.JWTUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

    Log logger = LogFactory.getLog(AuthRestController.class);

    private final AuthenticationManager authenticationManager;
    private final UserService service;
    private final JWTUtil util;

    public AuthRestController(AuthenticationManager authenticationManager, UserService service, JWTUtil util) {
        this.authenticationManager = authenticationManager;
        this.service = service;
        this.util = util;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){
        try {
            authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            logger.info("Entre al Controlador");
            UserDetails userDetails = service.loadUserByUsername(request.getUsername());
            logger.info(userDetails.getUsername());
            String jwt = util.generateToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        } catch (BadCredentialsException e){
            logger.error("No tiene permiso");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
