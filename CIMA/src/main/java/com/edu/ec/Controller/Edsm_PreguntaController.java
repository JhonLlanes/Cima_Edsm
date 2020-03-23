package com.edu.ec.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import com.edu.ec.Bussines.Edsm_preguntasBussines;
import com.edu.ec.Favorito.EdsmFavorito;
import com.edu.ec.Modelos.Edsm;
import com.edu.ec.Modelos.Edsm_preguntas;
import com.edu.ec.Modelos.Nivel_preguntas;

@ManagedBean
@ViewScoped
public class Edsm_PreguntaController  {

	private List<Edsm_preguntas> edsmTemp;
	
	
	
	
	@Inject
	private Edsm_preguntasBussines edsmpregBus;
	
	@Inject
	private EdsmFavorito edsmFav;
	
	@PostConstruct
	public void init() {
		Edsm edsm = edsmFav.getEdsm();
		Nivel_preguntas nivel  = new Nivel_preguntas();
		nivel.setNiv_id(2);
		
		System.out.println(edsm.getPersona().getPer_nombre());
		edsmTemp = edsmpregBus.Contarlistar(edsm, nivel);
		
		
	}
	
	public void actualizarEdsmPreguntas(Edsm_preguntas edsmPregunta) {
		edsmpregBus.actualizarEdsmPreguntas(edsmPregunta);
		addMessage("Infromador" + edsmPregunta.getEds_pre_informador()+ " Observador " + edsmPregunta.getEds_pre_observador());
	}

	public List<Edsm_preguntas> getEdsmTemp() {
		return edsmTemp;
	}

	public void setEdsmTemp(List<Edsm_preguntas> edsmTemp) {
		this.edsmTemp = edsmTemp;
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }



	
}
