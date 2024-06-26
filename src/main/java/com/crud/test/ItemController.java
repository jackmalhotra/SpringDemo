package com.crud.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("")
    public String getAllItems(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "items-list";
    }

    @GetMapping("/new")
    public String showNewItemForm(Model model) {
        // Use parameterized constructor to create a new Item object
        model.addAttribute("item", new Item());
        return "item-form";
    }

    @PostMapping("/save")
    public String saveItem(@ModelAttribute("item") Item item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }

    @GetMapping("/{id}/edit")
    public String showEditItemForm(@PathVariable Long id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "item-form";
    }

    @GetMapping("/{id}/delete")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "redirect:/items";
    }
}