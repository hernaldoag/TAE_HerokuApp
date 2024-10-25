package pom.constants;

public enum Credentials {

    DEFAULT_USER("ha_juice003@auto.io", "HA_2023_ah");

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
