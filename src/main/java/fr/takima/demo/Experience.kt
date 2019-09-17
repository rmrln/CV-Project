package fr.takima.demo

import javax.persistence.*



@Entity(name = "experiences")
data class Experience(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var ExperienceID: Long?,
        @Column(name = "experience_tittle") var experienceTittle: String?,
        @Column(name = "experience_description") var experienceDescription: String?,
        @Column(name = "experience_position") var experiencePosition: String?,
        @Column(name = "experience_name") var experienceName: String?,
        @Column(name = "experience_date") var experienceDate: Int?,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        var users: User?)
{
    constructor() : this(null, null, null, null,null,null,null)

}