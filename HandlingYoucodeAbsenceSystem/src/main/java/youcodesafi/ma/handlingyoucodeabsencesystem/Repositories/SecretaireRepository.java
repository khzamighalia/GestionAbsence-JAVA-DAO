package youcodesafi.ma.handlingyoucodeabsencesystem.Repositories;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.AbsenceApprenant;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Person;

public interface SecretaireRepository {
    public List<AbsenceApprenant> getAll(int idStaff) throws ClassNotFoundException, SQLException;
    
    public List<Person> getStaff() throws SQLException;

    public void justiferChecks(int id, Date i);

    public AbsenceApprenant getInfosSec(int sessionApp);
}
