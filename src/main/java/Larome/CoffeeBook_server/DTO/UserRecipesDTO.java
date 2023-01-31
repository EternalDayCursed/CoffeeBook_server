package Larome.CoffeeBook_server.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserRecipesDTO {

    private String UR_name;


    private String UR_desc;


    private String UR_preparation;


}
