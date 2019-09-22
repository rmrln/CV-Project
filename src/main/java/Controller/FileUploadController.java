package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileUploadController {
    public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";

    @GetMapping("upload")
    public String UploadPage(Model model){
        return "uploadView";
    }
}
