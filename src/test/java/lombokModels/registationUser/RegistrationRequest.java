package lombokModels.registationUser;

import lombok.Data;

public @Data
class RegistrationRequest {
    private String email, password;
}