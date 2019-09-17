package fr.takima.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

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

    @GetMapping("/index")
    public String indexPage(Model m) {

        return "index";
    }

    @GetMapping("/index_dev")
    public String testPage(Model m) {

        return "index_dev";
    }

    @GetMapping("/list")
    public String listCVs(Model m) {
        m.addAttribute("users", userDAO.findAll());
        return "list";
    }

    @GetMapping("/new")
    public String addUserPage(Model m) {
        User user = new User();
        Set<Formation> formations = new HashSet<>();
        user.setFormations(formations);
        m.addAttribute("user", user);
        return "new";
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
        Optional str = userDAO.findById(id);
        if(str.isPresent()){
            m.addAttribute("user",userDAO.findById(id).get());
        }
        return "modif";
    }
}