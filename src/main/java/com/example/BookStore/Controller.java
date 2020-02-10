package com.example.BookStore;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String mainView(@RequestParam int side, Model m) {

        ArrayList<Integer> p = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            p.add(i);
        }

        BookRepository b = new BookRepository();
        m.addAttribute("books", b.getPage(side, 10));
        m.addAttribute("side", side);
        m.addAttribute("list", p);
        m.addAttribute("currentPage", side);
        m.addAttribute("getBook", b.getBook(10));


        return "page";
    }

    @GetMapping("/details")
    public String getBook(Model m) {
        BookRepository b = new BookRepository();
        m.addAttribute("s", b.getBook(12));
        return "details";
    }
}

