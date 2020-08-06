package com.github.viniciusfcf.microprofile.metrics;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
// @Counted
public class MPService {
    
    public void metodo1() {

    }

    public void metodo2() {

    }

    // @Gauge(unit = "none")
    public int metodo3() {
        return 3;
    }

    // @Produces
    // @ApplicationScoped
    public ClasseCustomizada criar() {
        return new ClasseCustomizada();
    }

}