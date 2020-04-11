package com.vivekmv23.spring.security.controller;

import com.vivekmv23.spring.security.domain.Item;
import com.vivekmv23.spring.security.service.ItemManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    ItemManagerService itemManagerService;

    @GetMapping("/")
    public String redirectHome(Model model) {
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String showAllitems(Model model) {
        List<Item> items = itemManagerService.getAllItem();
        model.addAttribute("items", items);
        return "index";
    }

    @GetMapping("/item/{id}")
    public String getAll(@PathVariable long id, Model model) {
        Item item = itemManagerService.selectItemById(id);
        model.addAttribute("item", item);
        return "details";
    }
}
