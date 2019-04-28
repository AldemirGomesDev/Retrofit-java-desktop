package controllers;

import java.io.IOException;

import models.api.PublicidadeResult;
import services.PublicidadeService;

public class PublicidadeController {
	
	private PublicidadeService publicidadeService;

    public PublicidadeController(){
        publicidadeService = PublicidadeService.INSTANCE;
    }

    public PublicidadeResult getPublicidade() throws IOException {
        return publicidadeService.getPublicidade();
    }

}
