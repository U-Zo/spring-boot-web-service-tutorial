package springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.service.PostsService;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    // Model: 서버 템플릿 엔진에 전달할 데이터 저장
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());

        return "index"; // 자동으로 View Resolver가 처리
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
