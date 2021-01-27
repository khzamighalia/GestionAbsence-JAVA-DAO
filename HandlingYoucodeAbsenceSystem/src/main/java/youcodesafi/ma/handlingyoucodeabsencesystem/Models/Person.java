/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem.Models;

import youcodesafi.ma.handlingyoucodeabsencesystem.Enums.Role;

/**
 *
 * @author Jamal-Jcyber
 */
public abstract class Person {

    private long idPerson;
    private String fullname;
    private String phone;
    private String email;
    private String username;
    private String password;

    private Role role;

    public Person() {
    }

    public Person(String fullname, String phone, String email, String username, String password, Role role) {
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Person(long idPerson, String fullname, String phone, String email, String username, String password, Role role) {
        this.idPerson = idPerson;
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    

    public Person(long idPerson, String username, String password, Role role) {
        this.idPerson = idPerson;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Person(long idPerson, String fullname) {
        this.idPerson = idPerson;
        this.fullname = fullname;
    }
    
    

    public long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(long idPerson) {
        this.idPerson = idPerson;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public abstract String displayInfos();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{idPerson=").append(idPerson);
        sb.append(", fullname=").append(fullname);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }

}
