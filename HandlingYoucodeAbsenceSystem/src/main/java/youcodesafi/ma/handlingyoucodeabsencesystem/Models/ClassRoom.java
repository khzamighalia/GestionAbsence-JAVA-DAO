/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem.Models;

/**
 *
 * @author Jamal-Jcyber
 */
public class ClassRoom {

    private int id_Class;
    private int id_Staff;
    private int id_Type;
    private String class_Title;

    public ClassRoom(int id_Class, String class_Title) {
        this.id_Class = id_Class;
        this.class_Title = class_Title;
    }

    public ClassRoom(int id_Class, int id_Staff, int id_Type, String class_Title) {
        this.id_Class = id_Class;
        this.id_Staff = id_Staff;
        this.id_Type = id_Type;
        this.class_Title = class_Title;
    }

    public int getId_Class() {
        return id_Class;
    }

    public void setId_Class(int id_Class) {
        this.id_Class = id_Class;
    }

    public int getId_Staff() {
        return id_Staff;
    }

    public void setId_Staff(int id_Staff) {
        this.id_Staff = id_Staff;
    }

    public int getId_Type() {
        return id_Type;
    }

    public void setId_Type(int id_Type) {
        this.id_Type = id_Type;
    }

    public String getClass_Title() {
        return class_Title;
    }

    public void setClass_Title(String class_Title) {
        this.class_Title = class_Title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ClassRoom{id_Class=").append(id_Class);
        sb.append(", id_Staff=").append(id_Staff);
        sb.append(", id_Type=").append(id_Type);
        sb.append(", class_Title=").append(class_Title);
        sb.append('}');
        return sb.toString();
    }

}
