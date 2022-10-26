package nab2.crudpractice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDetailDto {
    private String loginId;
    private String pass;
    private String name;
    private String birth;
    private String email;
    private int age;
}
