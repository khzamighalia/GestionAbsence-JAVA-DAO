package youcodesafi.ma.handlingyoucodeabsencesystem.Models;



public class StatistiqueAbsence {

    private int idStudent;
    private int heureDemiAbsence;
    private int heureAbsence;
    private int heureAbsenceTotale;
    private int absenceJus;
    private int absenceNonJus;
    private int nombreAbsence;
    private String nom;
    private String promo;
    private String referencielle;



    public StatistiqueAbsence(int idStudent,int heureAbsence ,int heureAbsenceTotale , int heureDemiAbsence ) {
        this.idStudent = idStudent;
        this.heureDemiAbsence = heureDemiAbsence;
        this.heureAbsence = heureAbsence;
        this.heureAbsenceTotale = heureAbsenceTotale;

    }
    public StatistiqueAbsence(int absenceJus,int absenceNonJus,int nombreAbsence ) {
        this.absenceJus = absenceJus;
        this.absenceNonJus = absenceNonJus;
        this.nombreAbsence =nombreAbsence;
    }

    public StatistiqueAbsence(String nom,String promo,String referencielle ) {
        this.nom = nom;
        this.promo = promo;
        this.referencielle = referencielle;
    }



    public int getHeureDemiAbsence() {
        return heureDemiAbsence;
    }

    public int getHeureAbsence() {
        return heureAbsence;
    }

    public int getHeureAbsenceTotale() {
        return heureAbsenceTotale;
    }

    public int getAbsenceJus() {
        return absenceJus;
    }

    public int getAbsenceNonJus() {
        return absenceNonJus;
    }

    public int getNombreAbsence() {
        return nombreAbsence;
    }

    public String getNom() {
        return nom;
    }

    public String getPromo() {
        return promo;
    }

    public String getReferencielle() {
        return referencielle;
    }

    @Override
    public String toString() {
        return "StatistiqueAbsence{" +
                "idStudent=" + idStudent +
                ", heureDemiAbsence=" + heureDemiAbsence +
                ", heureAbsence=" + heureAbsence +
                ", heureAbsenceTotale=" + heureAbsenceTotale +
                ", absenceJus=" + absenceJus +
                ", absenceNonJus=" + absenceNonJus +
                ", nombreAbsence=" + nombreAbsence +
                ", nom='" + nom + '\'' +
                ", promo='" + promo + '\'' +
                ", referencielle='" + referencielle + '\'' +
                '}';
    }
}
