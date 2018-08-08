package com.application.bank.server.controller;

import com.application.bank.server.entity.Client;
import com.application.bank.server.entity.RiskGroup;
import com.application.bank.server.entity.RiskGroupHistoryChange;
import com.application.bank.server.repository.ClientRepository;
import com.application.bank.server.repository.RiskGroupHistoryChangeReposotory;
import com.application.bank.server.repository.RiskGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3500", maxAge = 3600)
@RestController //все методы контроллера возвращают json
@RequestMapping("/clients")
public class ClientController
{
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RiskGroupRepository riskGroupRepository;

    @Autowired
    private RiskGroupHistoryChangeReposotory historyReposotory;

//              КЛИЕНТЫ
//                          получить всех клиентов
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Client> getAllClients()
    {
        return clientRepository.findAll();
    }
//                          получить клиента по id
//    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Client getClient(@PathVariable long id)
//    {
//        return clientRepository.findById(id).get();
//    }
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Client getClient(@PathVariable("id") long clientId)
    {
        return clientRepository.findById(clientId).get();
    }

//                          сохранить/добавить клиента
// возможно, в этом методе ошибка...
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
//    public Client saveClient(@RequestBody Client client)
//    {
//        Client addClient = clientRepository.saveAndFlush(client);
//        RiskGroupHistoryChange rghc = new RiskGroupHistoryChange();
//        rghc.setClient(addClient);
//        rghc.setJoinDate(new Date());
//        rghc.setRiskGroup(riskGroupRepository.findById(client.getId()).get());
//        historyReposotory.saveAndFlush(client);
//        return client;
//    }
    public Client saveClient(@RequestBody Client client)
    {
        return clientRepository.saveAndFlush(client);
    }

//                          удалить клиента
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteClient(@PathVariable long id)
    {
//        clientRepository.deleteById(id);
        clientRepository.delete(clientRepository.findById(id).get());
    }
}
