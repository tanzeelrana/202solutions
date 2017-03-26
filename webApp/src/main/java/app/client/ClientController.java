package app.client;

import app.parse.ParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import parse4j.ParseUser;

/**
 * Created by tanzeelrana on 3/25/2017.
 */
@Controller
public class ClientController {

    @Autowired
    ParseService parseService;

    @ModelAttribute("module")
    String module() {
        return "clients";
    }

    @RequestMapping({"/clients"})
    String index(RedirectAttributes ra, Model model) {
        if(ParseUser.currentUser != null){
            model.addAttribute("clients", parseService.getAllClients());
            return "/clients/clients";
        }else{
            ra.addAttribute("error","1");
            return "redirect:/signin";
        }
    }

}
