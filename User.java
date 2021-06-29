package TRAININGJAVA;

public class User implements java.io.Serializable{

    private int  id;
    private String firstName;
    private String lastName;
    private int companyId;
    private String role;

    //
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    //
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    //
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    //
    public int getCompanyId() {
        return companyId;
    }
    public void setCompanyId(int companyId){
        this.companyId = companyId;
    }
    //
    public String getRole() {
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }
}