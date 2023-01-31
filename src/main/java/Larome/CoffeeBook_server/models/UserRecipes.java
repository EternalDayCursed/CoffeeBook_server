package Larome.CoffeeBook_server.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "User_recipes")
@RequiredArgsConstructor
public class UserRecipes {
    @Id
    @Column(name = "UR_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UR_id;

    @Column(name = "UR_name")
    private String UR_name;

    @Column(name = "UR_desc")
    private String UR_desc;

    @Column(name = "UR_preparation")
    private String UR_preparation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UR_userid", referencedColumnName = "user_id")
    private User userOwner;
}
