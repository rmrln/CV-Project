package fr.takima.demo;

import org.springframework.boot.SpringApplication;
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
    private static String UPLOADED_FOLDER = "../CV-Project/uploads/";

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

    @GetMapping("upload")
    public String UploadPage(Model model){
        return "uploadView";
    }

 /*   @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("msg", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("msg",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg",
                    "Bad" + file.getOriginalFilename() + "'");
        }

        return "uploadStatus";
    }*/

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }



    @GetMapping("/new")
    public String addUserPage(Model m) {
       // User user = new User();
       // Set<Formation> formations = new HashSet<>();
        //user.setFormations(formations);
        m.addAttribute("user", new User());
        return "new";
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
        user.setPicture(UPLOADED_FOLDER + file.getOriginalFilename());
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
