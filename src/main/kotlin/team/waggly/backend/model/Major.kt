package team.waggly.backend.model

import team.waggly.backend.commomenum.ActiveStatusType
import team.waggly.backend.commomenum.CollegeType
import javax.persistence.*

@Entity
class Major (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    val university: University,

    @Column(columnDefinition = "VARCHAR(30)")
    val majorName: String,

    @Column(columnDefinition = "VARCHAR(30)")
    val collegeEnum: CollegeType, // 이넘

    @Column
    val major_status: ActiveStatusType = ActiveStatusType.ACTIVE
)