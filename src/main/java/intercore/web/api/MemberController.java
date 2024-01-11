package intercore.web.api;

import intercore.Member;
import intercore.data.MemberRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/members", produces = "application/json")
@CrossOrigin(origins = {"http:localhost:8080", "http://intercorerudn.ru"})
public class MemberController {
    private MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    @GetMapping(params = "recent")
    public Iterable<Member> recentMembers(){
        PageRequest page = PageRequest.of(0, 10, Sort.by("createdAt").descending());
        return memberRepository.findAll(page).getContent();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Member postMember(@RequestBody Member member){
        return memberRepository.save(member);
    }
}
