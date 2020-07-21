package demo.file_writer_and_reader;

import java.io.Serializable;

public class Country implements Serializable {
    private int id;
    private String code;
    private String name;
    private String continent;

    public Country() {
        super();
    }

    public Country(int id, String code, String name, String continent) {
        super();
        this.id = id;
        this.code = code;
        this.name = name;
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country [id = " + id + ", code = " + code + ", name = " + name + ", continent = " + continent + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
