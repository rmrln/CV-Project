
package fr.takima.demo

import javax.persistence.*
import java.util.ArrayList



/**
 *
 */
@Entity(name = "users")
data class User(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        @Column(name = "cv_tittle") var cvTittle: String?,
        @Column(name = "first_name") var firstName: String?,
        @Column(name = "last_name") var lastName: String?,
        @Column(name = "age") var age: Int?,
        @Column(name = "linkedin") var linkedin: String?,
        @Column(name = "mail") var mail: String?,
        @Column(name = "presentation") var presentation: String?,
        @Column(name = "skill") var skill: String?,
        @Column(name = "language") var language: String?,
        @OneToMany(mappedBy = "users", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        var formations: Set<Formation>?,

        @OneToMany(mappedBy = "users", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        var experiences: Set<Experience>?)

{
    constructor() : this(null, null, null, null, null, null,null, null, null, null, null, null)

}