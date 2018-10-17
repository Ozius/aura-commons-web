package com.nemsolutions.auracommons.web.views.ajustesFlow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class AjustesBean implements Serializable {

    private static final long serialVersionUID = -6475904463005363351L;
    private static final Logger log = LoggerFactory.getLogger(AjustesBean.class);

    public void init() {
        log.debug("AjustesBean init!!");
    }
}
