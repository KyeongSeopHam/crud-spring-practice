package nab2.crudpractice.dto;

import lombok.Data;

@Data
public class CreateDto {
    private String loginId;
    private String pass;
    private String name;
    private String birth;
    private String email;
    private int age;
}
