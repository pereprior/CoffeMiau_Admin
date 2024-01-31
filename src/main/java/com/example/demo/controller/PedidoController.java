package com.example.demo.controller;

import com.example.demo.models.entities.LinPedido;
import com.example.demo.models.entities.Pedido;
import com.example.demo.models.entities.Usuario;
import com.example.demo.models.services.LinPedidoService;
import com.example.demo.models.services.PedidoService;
import com.example.demo.models.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private UsuarioService usuarioService;


    @Autowired
    private LinPedidoService linPedidoService; //

    @GetMapping("/pedidos")
    public String pedidos(Model model) {
        List<Pedido> listaPedidos = pedidoService.findAll();
        model.addAttribute("pedidos", listaPedidos);
        return "pedidos";
    }

    @GetMapping("/pedidos/add")
    public String mostrarFormularioNuevoPedido(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("usuarios", usuarioService.findAll());
        List<LinPedido> linPedidos = linPedidoService.findAll();
        model.addAttribute("linpedidos", linPedidos);

        return "add_pedido";
    }

    @PostMapping("/pedidos/add")
    public String crearNuevoPedido(@ModelAttribute Pedido pedido, Model model) {
        if(pedido.getCliente() == null) {
            model.addAttribute("error", "El usuario seleccionado no existe.");
            List<Usuario> listaUsuarios = usuarioService.findAll();
            model.addAttribute("usuarios", listaUsuarios);
            return "add_pedido";
        } else {
            pedidoService.save(pedido);
            return "redirect:/pedidos";
        }
    }

    @PostMapping("/pedidos/delete/{id}")
    public String borrarPedido(@PathVariable Long id) {
        pedidoService.delete(id);
        return "redirect:/pedidos";
    }

    @GetMapping("/pedidos/edit/{id}")
    public String mostrarFormularioEditarPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.findById(id);
        if (pedido == null) {
            return "redirect:/pedidos";
        }

        List<Usuario> listaUsuarios = usuarioService.findAll();
        model.addAttribute("usuarios", listaUsuarios);
        model.addAttribute("pedido", pedido);

        return "edit_pedido";
    }

    @PostMapping("/pedidos/edit")
    public String actualizarPedido(@ModelAttribute Pedido pedido, Model model) {
        if (pedido.getCliente() == null) {
            model.addAttribute("error", "El usuario seleccionado no existe.");
            List<Usuario> listaUsuarios = usuarioService.findAll();
            model.addAttribute("usuarios", listaUsuarios);
            return "edit_pedido";
        } else {
            pedidoService.save(pedido);

            return "redirect:/pedidos";
        }
    }

}