package elbuensabor.entities;

public enum Rol {
    ADMIN,
    CLI,

   EMP;
    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
