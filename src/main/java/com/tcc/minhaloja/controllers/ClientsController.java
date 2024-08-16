package com.tcc.minhaloja.controllers;

import com.tcc.minhaloja.models.Client;
import com.tcc.minhaloja.models.ClientDto;
import com.tcc.minhaloja.repositories.ClientsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientsRepository repo;

    @GetMapping
    public String getClients(Model model) {
        List<Client> clients = repo.getClients();
        model.addAttribute("clients", clients);
        return "clients/index";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        ClientDto clientDto = new ClientDto();
        model.addAttribute("clientDto", clientDto);
        return "clients/create";
    }


    @PostMapping("/create")
    public String createClient(
            @Valid @ModelAttribute ClientDto clientDto,
            BindingResult result
    ) {
        if (repo.getClient(clientDto.getEmail()) != null) {
            result.addError(
                    new FieldError("clientDto", "email", clientDto.getEmail(),
                            false, null, null, "Email já utilizado")
            );
        }

        if(result.hasErrors()){
            return "clients/create";
        }

        Client client = new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        client.setAddress(clientDto.getAddress());
        client.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        repo.createClient(client);

        return "redirect:/clients";
    }


}
