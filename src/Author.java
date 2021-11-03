import java.util.Objects;

public class Author {
    private String name;
    private String lastname;
    private String gender;

    public Author(String name, String lastname, String gender) {
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(lastname, author.lastname) && Objects.equals(gender, author.gender);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, gender);
    }
}
