package lombokModels.login;

import lombok.Data;

public @Data class LoginRequest {
    private String email, password;
}
