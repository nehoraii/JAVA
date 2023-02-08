package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "my_table_name", schema = "public", catalog = "Try")
@NamedQuery(name="select",query ="SELECT e FROM MyTableNameEntity e")
@NamedQuery(name="select withe Condition",query = "SELECT e FROM MyTableNameEntity e WHERE e.firstName=?1")


public class MyTableNameEntity {
    private String firstName;
    private int id;

    @Basic
    @Column(name = "first_name", nullable = false, length = -1)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyTableNameEntity that = (MyTableNameEntity) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "MyTableNameEntity{" +
                "firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}
