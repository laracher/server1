package com.application.bank.server.controller;

import com.application.bank.server.entity.RiskGroup;
import com.application.bank.server.repository.ClientRepository;
import com.application.bank.server.repository.RiskGroupHistoryChangeReposotory;
import com.application.bank.server.repository.RiskGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //все методы контроллера возвращают json
@RequestMapping("/group-risk")
public class GroupRiskController
{
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RiskGroupRepository riskGroupRepository;

    @Autowired
    private RiskGroupHistoryChangeReposotory riskGroupHistoryChangeReposotory;


    //                  ГРУППЫ РИСКА (ГР)
//                              получить все ГР
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<RiskGroup> getAllRiskGroups()
    {
        return riskGroupRepository.findAll();
    }
    //                          получить ГР по id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RiskGroup getRiskGroup(@PathVariable long id)
    {
        return riskGroupRepository.findById(id).get();
    }

    //                          сохранить/добавить группу риска
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public RiskGroup saveRiskGroup(@RequestBody RiskGroup riskGroup)
    {
        return riskGroupRepository.saveAndFlush(riskGroup);
    }

    //                          удалить группу риска
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteRiskGroup(@PathVariable long id)
    {
        riskGroupRepository.deleteById(id);
    }
}
