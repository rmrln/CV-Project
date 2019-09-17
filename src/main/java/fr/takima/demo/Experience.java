package fr.takima.demo;


import javax.persistence.*;

@Entity(name = "experiences")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "experience_title")
    private String experienceTitle;
    @Column(name = "experience_description")
    private String experienceDescription;
    @Column(name = "experience_position")
    private String experiencePosition;
    @Column(name = "experience_name")
    private String experienceName;
    @Column(name = "experience_date")
    private int experienceDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExperienceTitle() {
        return experienceTitle;
    }

    public void setExperienceTitle(String experienceTitle) {
        this.experienceTitle = experienceTitle;
    }

    public String getExperienceDescription() {
        return experienceDescription;
    }

    public void setExperienceDescription(String experienceDescription) {
        this.experienceDescription = experienceDescription;
    }

    public String getExperiencePosition() {
        return experiencePosition;
    }

    public void setExperiencePosition(String experiencePosition) {
        this.experiencePosition = experiencePosition;
    }

    public String getExperienceName() {
        return experienceName;
    }

    public void setExperienceName(String experienceName) {
        this.experienceName = experienceName;
    }

    public int getExperienceDate() {
        return experienceDate;
    }

    public void setExperienceDate(int experienceDate) {
        this.experienceDate = experienceDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

