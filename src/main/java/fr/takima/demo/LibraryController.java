package fr.takima.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 */
@RequestMapping("/")
@Controller
public class LibraryController {

    private final UserDAO userDAO;
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "../CV-Project/src/main/resources/static/uploads/";

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
       // User user = new User();
       // Set<Formation> formations = new HashSet<>();
        //user.setFormations(formations);
        m.addAttribute("user", new User());
        return "new";
    }

    @RequestMapping()
    public RedirectView modifNewUser(@ModelAttribute User user, RedirectAttributes attrs,@RequestParam("file") MultipartFile file) {
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            attrs.addFlashAttribute("msg",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
            attrs.addFlashAttribute("msg",
                    "Bad" + file.getOriginalFilename() + "'");
        }
        attrs.addFlashAttribute("message", "Utilisateur ajouté avec succès"+UPLOADED_FOLDER);
        System.out.println(UPLOADED_FOLDER + file.getOriginalFilename());
        String pathModif = "uploads/";
        user.setPicture(pathModif + file.getOriginalFilename());
        userDAO.save(user);
        return new RedirectView("/");
    }


    @PostMapping("/new")
    public RedirectView createNewUser(@ModelAttribute User user, RedirectAttributes attrs,@RequestParam("file") MultipartFile file) {
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            attrs.addFlashAttribute("msg",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
            attrs.addFlashAttribute("msg",
                    "Bad" + file.getOriginalFilename() + "'");
        }
        attrs.addFlashAttribute("message", "Utilisateur ajouté avec succès"+UPLOADED_FOLDER);
        System.out.println(UPLOADED_FOLDER + file.getOriginalFilename());
        String pathModif = "../../../../uploads/";
        user.setPicture(pathModif + file.getOriginalFilename());
        userDAO.save(user);
        return new RedirectView("/");
    }
   /* @PostMapping("/new")
    public RedirectView createNewUser(@ModelAttribute User user, RedirectAttributes attrs,@RequestParam("file") MultipartFile file) {
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            attrs.addFlashAttribute("msg",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
            attrs.addFlashAttribute("msg",
                    "Bad" + file.getOriginalFilename() + "'");
        }
        attrs.addFlashAttribute("message", "Utilisateur ajouté avec succès"+UPLOADED_FOLDER);
        System.out.println(UPLOADED_FOLDER + file.getOriginalFilename());
        user.setPicture("../../resources/static/uploads/"+file.getOriginalFilename());
        userDAO.save(user);
        return new RedirectView("/");
    }*/

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
    public String viewCV(Model m,@PathVariable Long id){
        m.addAttribute("photo", userDAO.findById(id).get().getPicture());
        m.addAttribute("connectedUser",userDAO.findById(id));
        return "modif";
    }

    @PostMapping("/modif/{id}")
    public RedirectView updateUser(@ModelAttribute User connectedUser) {
        userDAO.save(connectedUser);
        return new RedirectView("/modif/"+connectedUser.getId());
    }
}
