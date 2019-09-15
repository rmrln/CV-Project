package fr.takima.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 *
 */
@RequestMapping("/")
@Controller
public class LibraryController {

    private final UserDAO userDAO;

    public LibraryController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public String homePage(Model m) {
        //m.addAttribute("users", userDAO.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String addUserPage(Model m) {
        m.addAttribute("user", new User());
        return "new";
    }

    @GetMapping("/index")
    public String indexPage(Model m) {

        return "index";
    }

    @GetMapping("/list")
    public String listCVs(Model m) {
        m.addAttribute("users", userDAO.findAll());
        return "list";
    }

    @PostMapping("/new")
    public RedirectView createNewUser(@ModelAttribute User user, RedirectAttributes attrs) {
        attrs.addFlashAttribute("message", "Utilisateur ajouté avec succès");
        userDAO.save(user);
        return new RedirectView("/");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteUser(@ModelAttribute User user, RedirectAttributes attrs) {
        attrs.addFlashAttribute("message", "CV supprimé avec succès");
        userDAO.deleteById(user.getId());
        return new RedirectView("/");
    }

    @GetMapping("/consult/{id}")
    public RedirectView consultCV(@ModelAttribute User user, RedirectAttributes attrs) {
        userDAO.findById(user.getId());
        return new RedirectView("consult");
    }

    @GetMapping("/modif/{id}")
    public String viewCV(Model m,@PathVariable Long id, User user){
        //List<User> lListeUser = userDAO.findById(id);
        if(id.equals(user.getId())){
            m.addAttribute("user", user.getId());
        }
        return "modif";
    }



}