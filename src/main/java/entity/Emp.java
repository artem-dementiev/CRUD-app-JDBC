package entity;

public class Emp {
    private int id_emp;
    private String name_emp;
    private String surname_emp;
    private int id_e_role;
    private String name_role;
    private String name_department;

    public void setName_role(String name_role) {
        this.name_role = name_role;
    }

    public void setName_department(String name_department) {
        this.name_department = name_department;
    }

    public String getName_role() {
        return name_role;
    }

    public String getName_department() {
        return name_department;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id_emp=" + id_emp +
                ", name_emp='" + name_emp + '\'' +
                ", surname_emp='" + surname_emp + '\'' +
                ", id_e_role=" + id_e_role +
                ", name_role='" + name_role + '\'' +
                ", name_department='" + name_department + '\'' +
                ", employment_date='" + employment_date + '\'' +
                ", phone_number_emp='" + phone_number_emp + '\'' +
                ", id_e_department=" + id_e_department +
                '}';
    }

    private String employment_date;
    private String phone_number_emp;
    private int id_e_department;

    public int getId_emp() {
        return id_emp;
    }

    public String getName_emp() {
        return name_emp;
    }

    public String getSurname_emp() {
        return surname_emp;
    }

    public int getId_e_role() {
        return id_e_role;
    }

    public String getEmployment_date() {
        return employment_date;
    }

    public String getPhone_number_emp() {
        return phone_number_emp;
    }

    public int getId_e_department() {
        return id_e_department;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public void setName_emp(String name_emp) {
        this.name_emp = name_emp;
    }

    public void setSurname_emp(String surname_emp) {
        this.surname_emp = surname_emp;
    }

    public void setId_e_role(int id_e_role) {
        this.id_e_role = id_e_role;
    }

    public void setEmployment_date(String employment_date) {
        this.employment_date = employment_date;
    }

    public void setPhone_number_emp(String phone_number_emp) {
        this.phone_number_emp = phone_number_emp;
    }

    public void setId_e_department(int id_e_department) {
        this.id_e_department = id_e_department;
    }
    public Emp(){}
    public Emp(int id_emp, String name_emp, String surname_emp, int id_e_role, String employment_date, String phone_number_emp, int id_e_department) {
        this.id_emp = id_emp;
        this.name_emp = name_emp;
        this.surname_emp = surname_emp;
        this.id_e_role = id_e_role;
        this.employment_date = employment_date;
        this.phone_number_emp = phone_number_emp;
        this.id_e_department = id_e_department;
    }
}
