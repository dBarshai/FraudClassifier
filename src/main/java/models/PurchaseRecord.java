package models;

public class PurchaseRecord {

    private String id;
    private Long total_price;
    private String created_at;
    private String email;
    private String first_name;
    private String city;
    private String country;
    private String browser_ip;
    private String currency;
    private boolean digital;
    private Product[] products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Long total_price) {
        this.total_price = total_price;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBrowser_ip() {
        return browser_ip;
    }

    public void setBrowser_ip(String browser_ip) {
        this.browser_ip = browser_ip;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
