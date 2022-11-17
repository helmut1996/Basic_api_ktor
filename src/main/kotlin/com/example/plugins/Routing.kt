package com.example.plugins

import com.example.models.Customer
import com.example.models.UsersInfo
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import java.io.File

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
            /* TODO: REQUEST EXAMPLE

            println("Ruta: ${call.request.uri}")
            println("Headers: ${call.request.headers.names()}")
            println("user-Agent: ${call.request.headers["User-Agent"]}")
            println("Accept: ${call.request.headers["Accept"]}")
            println("QueryParameters: ${call.request.queryParameters.names()}")
            println("Name: ${call.request.queryParameters["name"]}")
            println("email: ${call.request.queryParameters["email"]}")

            * */

        }

        /*TODO: PARAMETERS URL*/
        get ( "/iphones/{page}"){
            val pageNumber = call.parameters["page"]

            call.respondText("El numero de la pagina es: ${pageNumber}")
        }

        /*TODO: READING BODY*/
        post("/customer") {
            val customer = call.receive<Customer>()
           // customerStorage.add(customer)
            println(customer)
            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
        }

        /*TODO RESPOND JSON*/
        get("/user"){
            val respondeObject = UsersInfo(firstname = "Helmut", lastname = "Josue", email = "josubrenes0@gmsil.com", numbers = 820503)
            call.respond(respondeObject)
        }

        /*TODO:  Attaching Headers Respond*/
        get ("/headers"){
            call.response.headers.append("Server-hcolindres", "ktorServer")
            call.response.headers.append("Anime","Types")
            call.respondText ("Headers news")
        }


        /*TODO  Downloading a File*/
        get("/file"){
            val file= File("files/imagen.png")
            call.response.header(
                HttpHeaders.ContentDisposition,
                ContentDisposition.Attachment.withParameter(
                    ContentDisposition.Parameters.FileName, "Descarga-Ktor.png"
                ).toString()
            )
            call.respondText("Descargar Imagen......")
        }

    }
}
