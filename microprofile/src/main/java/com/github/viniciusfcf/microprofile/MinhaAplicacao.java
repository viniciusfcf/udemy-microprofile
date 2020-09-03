package com.github.viniciusfcf.microprofile;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@OpenAPIDefinition(info = 
    @Info(title = "Titulo da minha aplicacao", version = "0.0.1",
        //description = "Conjunto de dos usuários da minha empresa",
        contact = @Contact(email = "vinicius.ferraz@gmail.com", name = "Vinicius Ferraz")
        ,license = @License(name = "MinhaLicenca", url = "http://google.com")
    )
)
@ApplicationPath("/")
public class MinhaAplicacao extends Application {
    
}