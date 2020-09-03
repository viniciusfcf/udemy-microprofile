package com.github.viniciusfcf.microprofile.openapi;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.OASModelReader;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.info.Info;

public class MeuOASReader implements OASModelReader {


    @Override
	public OpenAPI buildModel() {
        OpenAPI createOpenAPI = OASFactory.createOpenAPI();
        Info info = OASFactory.createInfo();
		info.setDescription("Descricao from READER");
        createOpenAPI.setInfo(info);
        return createOpenAPI;
	}
    
}
