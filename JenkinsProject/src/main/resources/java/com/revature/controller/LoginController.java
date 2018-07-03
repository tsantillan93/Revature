package java.com.revature.controller;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapper(value = "/login") //maps the url
public class LoginController
{
        @Autowired
        LoginService loginService;

        @RequestMapping(method = RequestMethod.GET) //maps GET requests to this function
        public String getLogin(HttpSession session)
        {
            if(session.getAttribute("user") == null)
            {
                //if the login was successful, forward to the login page
                return "static/login.html"
            }

            //if the login was UNsuccessful, redirect to the home page/dashboard
            return "redirect : home";
        }

        @RequestMapping(method = RequestMethod.POST) //maps POST requests to this function
        public String login(String username, String password, HttpSession session) //making use of the LoginService method login()
        {
            User u = loginService.login(username, password);
            System.out.println("Credentials Received-\n\tUsername: " + username + "\n\tPassword: " + password);
            if (u == null) //the user has not registered
            {
                return "redirect : login";
            }

            //the user's credentials are valid
            return "redirect : home"
        }

        public void setLogin(LoginService login)
        {
            //instantiate the LoginService instance
            this.login = login;
        }
}
