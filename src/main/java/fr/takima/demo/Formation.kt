package fr.takima.demo

import javax.persistence.*
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name = "formations")
data class Formation(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var FormationID: Long?,
        @Column(name = "formation_tittle") var formationTittle: String?,
        @Column(name = "formation_description") var formationDescription: String?,
        @Column(name = "formation_name") var formationName: String?,
        @Column(name = "formation_date") var formationDate: Int?,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        var users: User?)


{
    constructor() : this(null, null, null, null,null,null)

}