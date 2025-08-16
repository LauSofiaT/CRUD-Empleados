package org.example.crudempleados.controller;

import org.example.crudempleados.model.Empleado;
import org.example.crudempleados.repository.EmpleadoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoController(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }
    @GetMapping
    public String listarEmpleados(Model model) {
        model.addAttribute("empleados",
                empleadoRepository.findAll(Sort.by(Sort.Direction.DESC, "fechaIngreso")));
        return "empleados/lista";
    }

    // Mostrar formulario para nuevo empleado
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleados/formulario"; // templates/empleados/formulario.html
    }

    // Guardar empleado
    @PostMapping
    public String guardarEmpleado(@ModelAttribute Empleado empleado) {
        empleadoRepository.save(empleado);
        return "redirect:/empleados";
    }

    // Editar empleado
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("empleado", empleado);
        return "empleados/formulario";
    }

    // Eliminar empleado
    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        empleadoRepository.deleteById(id);
        return "redirect:/empleados";
    }
}
