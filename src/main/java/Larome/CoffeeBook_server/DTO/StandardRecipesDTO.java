package Larome.CoffeeBook_server.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StandardRecipesDTO {

    private String SR_name;

    private String SR_desc;

    private String SR_preparation;
}
