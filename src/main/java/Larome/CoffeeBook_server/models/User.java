package Larome.CoffeeBook_server.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data @ToString(exclude = "userRecipes")
@Entity
@Table(name = "Users")
@RequiredArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_surname")
    private String surname;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_nickname")
    private String nickname;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userOwner")
    private Set<UserRecipes> userRecipes;
}
