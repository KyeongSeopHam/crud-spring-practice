package nab2.crudpractice.dto;

import lombok.Data;


@Data
public class UpdateDto {
    private String pass;
    private String name;
    private String birth;
    private String email;
    private int age;
}
