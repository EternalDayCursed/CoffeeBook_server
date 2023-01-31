package Larome.CoffeeBook_server.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "Standard_recipes")
@RequiredArgsConstructor
public class StandardRecipes {

    @Id
    @Column(name = "SR_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SR_id;

    @Column(name = "SR_name")
    private String SR_name;

    @Column(name = "SR_desc")
    private String SR_desc;

    @Column(name = "SR_preparation")
    private String SR_preparation;

}
