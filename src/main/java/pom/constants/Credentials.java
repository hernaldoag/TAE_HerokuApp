package pom.constants;

public enum Credentials {

    DEFAULT_USER("at_juice005@auto.io", "AT_2023_at");

    private final String customer_email;

    private final String customer_password;

    Credentials(String customer_email, String customer_password) {
        this.customer_email = customer_email;
        this.customer_password = customer_password;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public String getCustomer_password() {
        return customer_password;
    }
}
