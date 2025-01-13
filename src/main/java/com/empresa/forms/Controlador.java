package com.empresa.forms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador {
    @Autowired
    private Carrito carrito;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("carrito", carrito);
        mv.addObject("producto", new Producto());
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/nuevo")
    public ModelAndView nuevo(Producto p) {
        ModelAndView mv = new ModelAndView();
        carrito.getProductos().add(p);
        System.out.println(p);
        System.out.println(carrito.getProductos());
        mv.setViewName("redirect:/");
        return mv;
    }
}