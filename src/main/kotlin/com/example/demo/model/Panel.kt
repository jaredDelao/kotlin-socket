package com.example.demo.model

class Panel {
  var nombre: String? = null
  var apellido: String? = null
  var correo: String? = null

  constructor(nombre: String, apellido: String, correo: String){
    this.nombre = nombre
    this.apellido = apellido
    this.correo = correo
  }
}
