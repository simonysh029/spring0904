package sp1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller	//인터페이스를 해당 클래스 안에 있는 모든 메소드에 적용하라는 뜻
public class webpage {
	ModelAndView mv = null;
/*
 @RequestMapping ; 가상 파일명 GET,POST 모두 사용(service)
 @GetMapping : GET 전송
 @PostMapping : POST 전송
 @PutMapping : Database - insert 전용 (Ajax)
 @DeleteMapping : Database - delete 전용 (Ajax)
 @PatchMapping : Database - update 전용 (Ajax)
 */
	/*
	 ModelAndView(구식 - Controller Interface) vs Model(신식 - 
	 Model : 어노테이션을 사용하여 적용하는 사항 + 데이터를 담기 위한
	 View에서 Model에 담겨진 데이터 자동으로 바인딩
	 */
	
	
	/*
	 ModelAndView : return 시 jsp는 같은 이름으로 처리
	 setViewName을 사용하지 않을 경우 webpage.xml에 prefix에 해당
	 view 경로를 적어 주셔야 보안상 jsp 강제 입력이 되지 않습니다.
	 
	 setViewName을 사용시 webpage.xml에 prefix에는 /로 처리하고
	 해당 ("view 경로")를 필수로 입력하셔야 합니다.
	 */
	//로그인
	@PostMapping("/login.do")
	public ModelAndView loginok(HttpServletRequest req, HttpServletResponse res, Model model) {
		
		String mid = req.getParameter("mid");
		String mpw = req.getParameter("mpw");
		
		model.addAttribute("id",mid);
		model.addAttribute("pw",mpw);
				
		return "WEB-INF/viewpage/loginok";
	}
	
	//상품검색 (문자 자료형으로 return 사용하여 해당 페이지로 view 출력)
	@GetMapping("/search.do")
	public String search(HttpServletRequest req, HttpServletResponse res, Model model) {
		String sh = req.getParameter("product");
		model.addAttribute("word",sh);
		return "WEB-INF/viewpage/product";
	}

	/*
	 void 메소드는 response를 사용시 해당 view를 찾지 못하는 상황이 발생함
	 */
	//아이디 및 패스워드 찾기
	@RequestMapping("/idsearch.do")
	public void idsearch(Model model, HttpServletRequest req) {
		String names = req.getParameter("person");

		model.addAttribute("user",names);
		System.out.println(m.getAttribute("user"));
	}

}
