package nab2.crudpractice.service;

import nab2.crudpractice.domain.Member;
import nab2.crudpractice.dto.CreateDto;
import nab2.crudpractice.dto.MemberDetailDto;
import nab2.crudpractice.dto.MemberListDto;
import nab2.crudpractice.dto.UpdateDto;
import nab2.crudpractice.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원 가입
     */
    // 회원 가입
    public void createMember(CreateDto dto) {

        Member inputMemberInfo = new Member(
                dto.getLoginId(), dto.getPass(),
                dto.getName(), dto.getBirth(),
                dto.getEmail(), dto.getAge()
        );
        memberRepository.save(inputMemberInfo);
    }


    /**
     * 조회, 상세조회
     */


    // 회원 전체 조회
    public List<MemberListDto> readMemberInfo() {
//        return memberRepository.findAll();
        List<Member> memberList = memberRepository.findAll();
        List<MemberListDto> result = new ArrayList<>();

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getEmail().contains("naver.com")) {

                String email = memberList.get(i).getEmail();
                int idx = email.indexOf("@");
                String emailFilter = email.substring(0, idx);

                result.add(
                        MemberListDto.builder()
                                .loginId(memberList.get(i).getLoginId())
                                .email(emailFilter + "@네이버 ")
                                .name(memberList.get(i).getName())
                                .build()
                );
            } else {
                result.add(
                        MemberListDto.builder()
                                .loginId(memberList.get(i).getLoginId())
                                .email(memberList.get(i).getEmail())
                                .name(memberList.get(i).getName())
                                .build()
                );
            }
        }
        return result;
    }

    // 회원 상세 조회
    public MemberDetailDto readDetailMemberInfo(Long memberId) {

        Member findMember = memberRepository.findById(memberId).get();

        return MemberDetailDto.builder()
                .loginId(findMember.getLoginId())
                .pass("*****")
                .name(findMember.getName())    //93-10-29
                .birth(findMember.getBirth().substring(0, 2) + "-" +
                        findMember.getBirth().substring(2, 4) + "-" +
                        findMember.getBirth().substring(4, 6)
                )
                .email(findMember.getEmail())
                .age(findMember.getAge())
                .build();

    }

    // 정보수정시 int type String 처리 ?

    public void updateMemberInfo(Long memberId, UpdateDto memberInfo) {
        // 회원조회
        Member findMember = memberRepository.findById(memberId).get();

        findMember.updateInfo(
                memberInfo.getPass(),
                memberInfo.getName(),
                memberInfo.getBirth(),
                memberInfo.getEmail(),
                memberInfo.getAge()
        );
        memberRepository.save(findMember);

    }

    /**
     * 회원 삭제
     */
    public void removeMemberInfo(Long memberId) {

        memberRepository.deleteById(memberId);
    }

}
