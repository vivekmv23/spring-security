package com.vivekmv23.spring.security.controller;

import com.vivekmv23.spring.security.domain.Item;
import com.vivekmv23.spring.security.service.ItemManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @GetMapping("/item/delete/{id}")
    public String deleteItem(@PathVariable long id, Model model) {
        itemManagerService.deleteItemById(id);
        return "redirect:/items";
    }

    @GetMapping("/item/edit/{id}")
    public String editItem(@PathVariable long id, Model model) {
        Item item = itemManagerService.selectItemById(id);
        model.addAttribute("item", item);
        model.addAttribute("isUpdate", true);
        return "add_item";
    }



    @GetMapping("/item/form")
    public String getAddForm(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("isUpdate", false);
        return "add_item";
    }

    @RequestMapping(value = "/item/add", method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addItem(Item item,  Model model) {
        Item itemAdded = itemManagerService.addNewItem(item);
        model.addAttribute("item", itemAdded);
        return "details";
    }

    @RequestMapping(value = "/item/update", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateItem(Item item,  Model model) {
        Item itemAdded = itemManagerService.editItem(item);
        model.addAttribute("item", itemAdded);
        return "details";
    }

}
