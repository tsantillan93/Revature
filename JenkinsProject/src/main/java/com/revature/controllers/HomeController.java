package java.com.revature.controller;

@Controller
public class HomeController
{
        @Autowired
        HomeService homeService;

        @RequetMapping(value = "/home", method = RequestMethod.GET)
        public String getHome(HttpSession session)
        {
            if (session.getAttribute("user") == null) //the user is not logged in
            {
                    return "redirect : login";
            }

            //the user is logged in, therefore, can access the homepage
            return "static/home.html";
        }

        @RequetMapping(value = "/getPosts", method = RequestMethod.GET)
        public void getAllPosts()
        {
        	Set <Post> posts = homeService.getAllPosts();
        }

        @RequestMapping(value = "/logout", method = RequestMethod.GET)
        public String logout(HttpSession session)
        {
            //close the session
            session.invalidate();

            //redirect to the login page
            return "redirect : login";
        }
}

