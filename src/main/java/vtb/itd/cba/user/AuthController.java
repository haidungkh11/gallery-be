package vtb.itd.cba.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import vtb.itd.cba.config.CodeDefs;
import vtb.itd.cba.config.JwtService;
import vtb.itd.cba.explorerItem.ExplorerItem;
import vtb.itd.cba.response.ResponseObject;

import java.util.List;

@RestController
@RequestMapping("/api/ledung/auth")
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    private final UserServiceInterface userServiceInterface;

    public AuthController(AuthenticationManager authManager,
                          JwtService jwtService,UserServiceInterface userServiceInterface) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.userServiceInterface = userServiceInterface;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseObject<String>> login(@RequestBody User user, @RequestHeader("RequestId") String requestId) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUserName(), user.getPassword()
                )
        );

        return ResponseEntity.ok(
                new ResponseObject<>(
                        requestId,
                        CodeDefs.RETURN_CODE_SUCCEED.getStatusCode(),
                        CodeDefs.RETURN_CODE_SUCCEED.getDescription(),
                        jwtService.generateToken((UserDetails) auth.getPrincipal())
                )
        );
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseObject<User>> signUp(@RequestBody User user, @RequestHeader("RequestId") String requestId) {

        return ResponseEntity.ok(
                new ResponseObject<>(
                        requestId,
                        CodeDefs.RETURN_CODE_SUCCEED.getStatusCode(),
                        CodeDefs.RETURN_CODE_SUCCEED.getDescription(),
                        userServiceInterface.save(user)
                )
        );
    }

}
