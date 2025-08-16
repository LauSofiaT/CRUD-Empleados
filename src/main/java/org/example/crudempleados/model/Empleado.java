package org.example.crudempleados.model;

import jakarta.persistence.*;
import lombok.Data;

@Data // Lombok
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "idEmpleado")
    private Long idEmpleado;

    @Column(name = "Nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "cargo", nullable = false, length = 100)
    private String cargo;

    @Column(name = "correo_electronico", nullable = false, length = 150)
    private String correoElectronico;

    @Column(name = "Edad", length = 3)
    private Integer edad;

    @Column(name = "fecha_ingreso", nullable = false)
    private java.time.LocalDate fechaIngreso;

}

