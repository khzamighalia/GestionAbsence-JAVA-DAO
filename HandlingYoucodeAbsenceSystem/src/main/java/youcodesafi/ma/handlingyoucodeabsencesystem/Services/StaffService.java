/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import youcodesafi.ma.handlingyoucodeabsencesystem.Connection.Singleton;
import youcodesafi.ma.handlingyoucodeabsencesystem.Enums.Role;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Apprenant;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.ClassRoom;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Groupes;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Person;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Promotion;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Referencial;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Speciality;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Staff;
import youcodesafi.ma.handlingyoucodeabsencesystem.Repositories.StaffRepository;

/**
 *
 * @author Jamal-Jcyber
 */
public class StaffService implements StaffRepository {

    private static StaffService staffService;

    public StaffService() {
    }

    public static StaffService getInstance() {
        if (staffService == null) {
            staffService = new StaffService();
        }
        return staffService;
    }

    @Override
    public LinkedList<Promotion> getPromotionByReferencialOrBySpeciality(long search_Key1, long search_Key2) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        LinkedList<Promotion> _ListsPromotionByReferencial = new LinkedList<>();
        Promotion promotion;
        try {
            connection = Singleton.getConnection();
            String _query = "SELECT p.idPromo, p.titlePromotion FROM (((handlingyasvbetav2.promo p INNER JOIN referencial on p.idReferencial = referencial.idReferencial)inner join speciality sp on p.idSpeciality = sp.idSpeciality)inner join type t on p.idType = t.idType) where (p.idReferencial = ? or p.idSpeciality = ?) and p.idType = 2";
            statement = connection.prepareStatement(_query);
            statement.setLong(1, search_Key1);
            statement.setLong(2, search_Key2);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                promotion = new Promotion(resultSet.getInt(1), resultSet.getString(2));
                _ListsPromotionByReferencial.add(promotion);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return _ListsPromotionByReferencial;
    }

//    @Override
//    public LinkedList<Promotion> getPromotionBySpeciality(long speciality_ID) throws SQLException {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        LinkedList<Promotion> _ListsPromotionBySpeciality = new LinkedList<>();
//        Promotion promotion;
//        try {
//            connection = Singleton.getConnection();
//            String _query = "SELECT p.idPromo, p.titlePromotion FROM handlingyasvalphav2.promo p INNER JOIN speciality on p.idSpeciality = speciality.idSpeciality where p.idSpeciality =?";
//            statement = connection.prepareStatement(_query);
//            statement.setInt(1, (int) speciality_ID);
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                promotion = new Promotion(resultSet.getInt(1), resultSet.getString(2));
//                _ListsPromotionBySpeciality.add(promotion);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.getStackTrace();
//        } finally {
//            if (connection != null) {
//                connection.close();
//            }
//            if (statement != null) {
//                statement.close();
//            }
//            if (resultSet != null) {
//                resultSet.close();
//            }
//        }
//        return _ListsPromotionBySpeciality;
//    }
    @Override
    public LinkedList<Apprenant> getListsApprenantByPromotion(long promotion_ID) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        LinkedList<Apprenant> _ListsApprenantByPromotion = new LinkedList<>();
        Apprenant apprenant;
        try {
            connection = Singleton.getConnection();
            String _query = "SELECT DISTINCT p.idPerson, p.fullname from ((handlingyasvbetav2.belongtopromotion btp inner join student on btp.Stu_idPerson = student.idPerson)inner join person p on student.idPerson = p.idPerson) where btp.idPromo =?";
            statement = connection.prepareStatement(_query);
            statement.setInt(1, (int) promotion_ID);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                apprenant = new Apprenant(resultSet.getInt(1), resultSet.getString(2));
                _ListsApprenantByPromotion.add(apprenant);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return _ListsApprenantByPromotion;
    }

    @Override
    public LinkedList<Referencial> getListsReferencials() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Referencial referencial = null;
        LinkedList<Referencial> _ListsReferencials = new LinkedList<>();
        try {
            connection = Singleton.getConnection();
            String _query = "SELECT r.referencialTitle FROM handlingyasvbetav2.referencial r";
            statement = connection.prepareStatement(_query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                referencial = new Referencial(resultSet.getString(1));
                _ListsReferencials.add(referencial);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return _ListsReferencials;
    }

    @Override
    public LinkedList<Speciality> getListsSpecialities() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Speciality speciality = null;
        LinkedList<Speciality> _ListsSpecialities = new LinkedList<>();
        try {
            connection = Singleton.getConnection();
            String _query = "SELECT s.specialityTitle FROM handlingyasvbetav2.speciality s";
            statement = connection.prepareStatement(_query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                speciality = new Speciality(resultSet.getString(1));
                _ListsSpecialities.add(speciality);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return _ListsSpecialities;
    }

    @Override
    public int makeAbsenceForOneSpecificApprenant(int Stu_ID, int Promo_ID, int Nbr_Hours) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        int counter = 0;
        try {
            connection = Singleton.getConnection();
            String query_makeAbsence = "INSERT INTO `handlingyasvbetav2`.`belongtopromotion`(`Stu_idPerson`,`idPromo`,`Nbr_Hours`,`Justification`)VALUES(?,?,?,false)";
            statement = connection.prepareStatement(query_makeAbsence);
            statement.setInt(1, Stu_ID);
            statement.setInt(2, Promo_ID);
            statement.setInt(3, Nbr_Hours);
            counter = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }

        return counter;
    }

    @Override
    public LinkedList<ClassRoom> get_ClassRoomsListsBasedOnTheStaff(long staff_ID) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ClassRoom classRoom = null;
        LinkedList<ClassRoom> _ListsClassRooms = new LinkedList<>();
        try {
            connection = Singleton.getConnection();
            String _query = "SELECT clr.idClass, clr.titleClass FROM ((handlingyasvbetav2.classroom clr inner join staff stf on clr.idPerson = stf.idPerson)inner join type t on clr.idType = t.idType) where clr.idPerson = ? and clr.idType=1";
            statement = connection.prepareStatement(_query);
            statement.setLong(1, staff_ID);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                classRoom = new ClassRoom(resultSet.getInt(1), resultSet.getString(2));
                _ListsClassRooms.add(classRoom);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return _ListsClassRooms;
    }

    @Override
    public Person return_Staff(Person p) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Person person = null;
        try {
            connection = Singleton.getConnection();
            String query_Authentication = "SELECT p.idPerson, p.username, p.password, p.role, t.idType FROM ((handlingyasvbetav2.staff stf inner join person p on stf.idPerson = p.idPerson) inner join type t on stf.idType = t.idType) where p.username=? and p.password=? and p.role=?";
            statement = connection.prepareStatement(query_Authentication);
            statement.setString(1, p.getUsername());
            statement.setString(2, p.getPassword());
            statement.setString(3, p.getRole().toString());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                person = new Staff(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), Role.valueOf(resultSet.getString(4)), resultSet.getInt(5));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return person;
    }

    @Override
    public LinkedList<Apprenant> getListsApprenantByClassANDGroupes(long clssRoom_ID, int groupe_ID) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        LinkedList<Apprenant> _ListsApprenantByClassAndGroup = new LinkedList<>();
        Apprenant apprenant;
        try {
            connection = Singleton.getConnection();
            String _query = "SELECT distinct p.idPerson, p.fullname, g.titleGroup, class.titleClass, class.idClass FROM ((((handlingyasvbetav2.absencebyclass abc inner join classroom class on abc.idClass = class.idClass)inner join student std on abc.Stu_idPerson = std.idPerson)inner join person p on std.idPerson = p.idPerson)inner join groupes g on std.idGroup = g.idGroup) where abc.idClass = ? and std.idGroup = ?";
            statement = connection.prepareStatement(_query);
            statement.setInt(1, (int) clssRoom_ID);
            statement.setInt(2, groupe_ID);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                apprenant = new Apprenant(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5));
                _ListsApprenantByClassAndGroup.add(apprenant);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return _ListsApprenantByClassAndGroup;
    }

    @Override
    public LinkedList<Groupes> getListsGroupes() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Groupes groupe = null;
        LinkedList<Groupes> _ListsGroupes = new LinkedList<>();
        try {
            connection = Singleton.getConnection();
            String _query = "SELECT g.idGroup, g.titleGroup FROM handlingyasvbetav2.groupes g";
            statement = connection.prepareStatement(_query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                groupe = new Groupes(resultSet.getInt(1), resultSet.getString(2));
                _ListsGroupes.add(groupe);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return _ListsGroupes;
    }

    @Override
    public int makeAbsenceByClassForOneSpecificApprenant(int Stu_ID, int class_ID, int Nbr_Hours) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        int counter = 0;
        try {
            connection = Singleton.getConnection();
            String query_makeAbsence = "INSERT INTO `handlingyasvbetav2`.`absencebyclass` (`Stu_idPerson`, `idClass`, `Nbr_Hours`, `Justification`) VALUES (?,?,?,false)";
            statement = connection.prepareStatement(query_makeAbsence);
            statement.setInt(1, Stu_ID);
            statement.setInt(2, class_ID);
            statement.setInt(3, Nbr_Hours);
            counter = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return counter;
    }

}
