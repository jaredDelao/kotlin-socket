package com.example.demo.model

import lombok.Data
import java.io.Serializable
import javax.validation.constraints.NotNull


@Data
class Vacantes : Serializable {

  @NotNull
  var nombre: String? = null
  var apellido: String? = null
  var correo: String? = null
}
