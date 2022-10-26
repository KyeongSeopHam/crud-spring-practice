package nab2.crudpractice.controller;


import lombok.RequiredArgsConstructor;
import nab2.crudpractice.dto.CreateDto;
import nab2.crudpractice.dto.MemberDetailDto;
import nab2.crudpractice.dto.MemberListDto;
import nab2.crudpractice.dto.UpdateDto;
import nab2.crudpractice.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor  // final 생성자 만들어주는거
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 생성
     */
    @PostMapping("/create/member")
    void createMember(@RequestBody CreateDto dto) {
        memberService.createMember(dto);

    }


    /**
     * 회원 전체 조회
     */
    @GetMapping("/read/memberInfo")
    List<MemberListDto> readMemberInfo() {
        return memberService.readMemberInfo();
    }

    /**
     * 회원 상세 조회
     */
    @GetMapping("/read/memberDetail")
    MemberDetailDto readDetailMemberInfo(@RequestParam Long id) {

        return memberService.readDetailMemberInfo(id);
    }

    /**
     * 회원 수정
     */

    @PutMapping("/update/memberInfo/{id}")
    void updateMemberInfo(@PathVariable Long id, @RequestBody UpdateDto dto) {
        memberService.updateMemberInfo(id, dto);
    }

    /**
     * 회원 삭제
     */

    @DeleteMapping("/delete/memberInfo")
    void removeMemberInfo(@RequestParam Long id) {
        memberService.removeMemberInfo(id);
    }


}
