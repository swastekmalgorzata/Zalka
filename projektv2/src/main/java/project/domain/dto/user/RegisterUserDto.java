package project.domain.dto.user;

public class RegisterUserDto
{
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public RegisterUserDto() {
    }

    public RegisterUserDto(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
