package fr.takima.demo;

import javax.persistence.*;

@Entity(name = "formations")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "formation_title")
    private  String formationTitle;
    @Column(name = "formation_description")
    private  String formationDescription;
    @Column(name = "formation_name")
    private  String formationName;
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

    public String getFormationName() {
        return formationName;
    }

    public void setFormationName(String formationName) {
        this.formationName = formationName;
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