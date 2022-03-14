package dzien1.przyklad4;

public class Country {
    private Integer id;
    private String name;
    private String alias;


    public Country(Integer id, String name, String alias) {
        this.id = id;
        this.name = name;
        this.alias = alias;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
