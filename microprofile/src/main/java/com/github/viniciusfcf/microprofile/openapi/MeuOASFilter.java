package com.github.viniciusfcf.microprofile.openapi;

import org.eclipse.microprofile.openapi.OASFilter;
import org.eclipse.microprofile.openapi.models.Operation;

public class MeuOASFilter implements OASFilter {

    @Override
    public Operation filterOperation(Operation operation) {
        // operation.setSummary("Sumario Fixo");
        if("Salva uma nova pessoa".equals(operation.getSummary())) {
            return null;
        }
        return OASFilter.super.filterOperation(operation);
    }

    
    
}
