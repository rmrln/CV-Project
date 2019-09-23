package fr.takima.demo;

import javax.persistence.*;

@Entity(name = "formations")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Nom de la formation
    @Column(name = "formation_title")
    private  String formationTitle;

    // Description de la formation
    @Column(name = "formation_description")
    private  String formationDescription;

    // Date de la formation
    @Column(name = "formation_date")
    private  int formationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private  User user;



    public String getFormationTitle() {
        return formationTitle;
    }

    public void setFormationTitle(String formationTitle) {
        this.formationTitle = formationTitle;
    }

    public String getFormationDescription() {
        return formationDescription;
    }

    public void setFormationDescription(String formationDescription) {
        this.formationDescription = formationDescription;
    }

    public int getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(int formationDate) {
        this.formationDate = formationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
