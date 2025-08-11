package portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
	
	@GetMapping("/")
    public String homePage() {
		System.out.println(">>> HOME PAGE HIT <<<");
        return "index";
    }
	
	@GetMapping("/testabout")
	@ResponseBody
	public String testAbout() {
	    return "Test About Works!";
	}


    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/education")
    public String educationPage() {
        return "education";
    }

    @GetMapping("/skills")
    public String skillsPage() {
        return "skills";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
}
