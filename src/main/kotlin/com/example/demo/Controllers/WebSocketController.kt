//package com.example.demo.Controllers
//
//import com.example.demo.model.Panel
//import com.example.demo.model.Vacantes
//import org.apache.logging.log4j.LogManager
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.messaging.handler.annotation.MessageMapping
//import org.springframework.messaging.handler.annotation.SendTo
//import org.springframework.messaging.simp.SimpMessagingTemplate
//import org.springframework.stereotype.Controller
//import org.springframework.web.bind.annotation.*
//import java.lang.Exception
//
//
//@Controller
//@CrossOrigin
//@RestController
//@RequestMapping("/servicios")
//class WebSocketController @Autowired
//
//constructor(private val template: SimpMessagingTemplate) {
//  @RequestMapping(value = "/saveTask/1", method = arrayOf(RequestMethod.POST))
//  fun greeting(@RequestBody message: Vacantes): Panel? {
//    try {
//      val p = Panel("nombre: "+message.nombre, "apellido: "+message.apellido, "correo: "+message.correo)
//      this.template.convertAndSend("/task/panel/1", p)
//
//      return p
//    }
//    catch (e: Exception) {
//      logger.error("Error al insertar")
//      e.printStackTrace()
//      return null
//    }
//  }
//
//  @MessageMapping("/saveTask/1")
//  @SendTo("/task/panel/1")
//  fun greeting1(@RequestBody v: Vacantes): Panel? {
//    try {
//      val p = Panel( "" + v.nombre, "" + v.apellido, "" +  v.correo)
//      logger.info("New User: " + p.nombre)
//      return p
//    } catch (e: Exception) {
//      logger.error("Error al insertar")
//      e.printStackTrace()
//      return null
//    }
//  }
//
//
//  companion object {
//
//    private val logger = LogManager.getLogger(WebSocketController::class.java)
//  }
//}
//
package com.example.demo.Controllers

import com.example.demo.model.Panel
import com.example.demo.model.Socios
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.lang.Exception


@Controller
@CrossOrigin
@RestController
@RequestMapping("/socios")
class WebSocketController @Autowired

constructor(private val template: SimpMessagingTemplate) {
  @RequestMapping(value = "/saveTask/1", method = arrayOf(RequestMethod.POST))
  fun greeting(@RequestBody message: Socios): Panel? {
    try {
      val p = Panel( message.idEstadoSocio, message.prioridad, message.nombreComercial,
        message.rfc, message.razonSocial, message.alias, message.prioridades, message.estado, message.activo )
      this.template.convertAndSend("/task/panel/1", p)
      return p
    }
    catch (e: Exception) {
      logger.error("Error al insertar")
      e.printStackTrace()
      return null
    }
  }

  //Response
  @MessageMapping("/saveTask/1")
  @SendTo("/task/panel/1")
  fun greeting1(@RequestBody v: Socios): Panel? {
    try {
      val p = Panel(v.idEstadoSocio, v.prioridad, v.nombreComercial,
        v.rfc, v.razonSocial, v.alias, v.prioridades, v.estado, v.activo)
      logger.info(p.activo, p.idEstadoSocio, p.alias, p.nombreComercial, p.prioridad, p.razonSocial, p.rfc)
      logger.info(p.alias)

      return p
    } catch (e: Exception) {
      logger.error("Error al insertar")
      e.printStackTrace()
      return null
    }
  }


  companion object {

    private val logger = LogManager.getLogger(WebSocketController::class.java)
  }
}

