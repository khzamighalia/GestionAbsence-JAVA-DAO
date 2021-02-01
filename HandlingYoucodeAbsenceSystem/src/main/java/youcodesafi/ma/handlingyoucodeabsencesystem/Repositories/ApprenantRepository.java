package youcodesafi.ma.handlingyoucodeabsencesystem.Repositories;

import java.sql.SQLException;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Apprenant;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.StatistiqueAbsence;


public interface ApprenantRepository {
    public void pourcentageProgress(ProgressBar x, Label y, int pourcentage);
    public StatistiqueAbsence getAbsenceWeek(int sessionApp, int week);
    public StatistiqueAbsence getAbsenceJustification(int Month,int sessionApp);
    public StatistiqueAbsence getInfos(int sessionApp);
    public int addApprenant(Apprenant p) throws SQLException;
}
