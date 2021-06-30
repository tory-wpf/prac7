package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/abridgeUrl")
@Controller
public class AbridgeController {

    @Autowired
    AbridgeRepository repository;
    private CodeGenerator codeGenerator = new CodeGenerator();

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("Abridge", new Abridge());
        return "abridgeUrl/index";
    }

    @PostMapping("")
    public String create(@ModelAttribute("Abridge") Abridge abridge, Model model) {
            String hash = codeGenerator.generate();
            repository.save(new Abridge(abridge.getOriginalUrl(), hash));
            model.addAttribute("Abridge", repository.findByHash(hash));
            System.out.println(abridge.getHash());
        return "abridgeUrl/success";
    }

    @GetMapping(path = "/{hash}")
    public ResponseEntity<?> redirect(@PathVariable("hash") String hash) {
        Abridge abridge = repository.findByHash(hash);
        if (abridge != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", abridge.getOriginalUrl());
            return new ResponseEntity<String>(headers, HttpStatus.FOUND);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
