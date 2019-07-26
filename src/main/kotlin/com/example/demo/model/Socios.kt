package com.example.demo.model

import lombok.Data
import java.io.Serializable
import javax.validation.constraints.NotNull


@Data
class Socios : Serializable {

  @NotNull
  var idEstadoSocio: Number? = null
  var prioridad: Number? = null
  var nombreComercial: String? = null
  var rfc: String? = null
  var razonSocial: String? = null
  var alias: String? = null
  var prioridades: String? = null
  var estado: Number? = null
  var activo: String? = null
}
