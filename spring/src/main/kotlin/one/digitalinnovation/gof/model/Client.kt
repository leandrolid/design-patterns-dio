package one.digitalinnovation.gof.model

import javax.persistence.*

@Entity
class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val name: String,

    @ManyToOne
    var address: Address
)