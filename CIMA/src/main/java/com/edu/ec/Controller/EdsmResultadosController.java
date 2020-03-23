package com.edu.ec.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.chart.PieChartModel;

import com.edu.ec.Bussines.Edsm_preguntasBussines;
import com.edu.ec.Favorito.EdsmFavorito;
import com.edu.ec.Favorito.EdsmPreguntasResultados;
import com.edu.ec.Modelos.Edsm;
import com.edu.ec.Modelos.Nivel_preguntas;

@ManagedBean
@ViewScoped
public class EdsmResultadosController {

	private List<EdsmPreguntasResultados> edsmResultados;
	private PieChartModel model;
	
	@Inject
	private Edsm_preguntasBussines edsmpregBus;
	
	@Inject
	private EdsmFavorito edsmFav;
	
	@PostConstruct
	public void init() {
		List[] resultadosAreglo = new List[2];
		Edsm edsm = edsmFav.getEdsm();
		Nivel_preguntas nivel  = new Nivel_preguntas();
		nivel.setNiv_id(2);
		resultadosAreglo = edsmpregBus.TemporalResultado(edsm, nivel);
		edsmResultados = resultadosAreglo[0];
		
		model = new PieChartModel();
        model.set(" A " + resultadosAreglo[1].get(0), (int)resultadosAreglo[1].get(0));
        model.set(" N " + resultadosAreglo[1].get(1), (int)resultadosAreglo[1].get(1));
        model.set(" P " + resultadosAreglo[1].get(2), (int)resultadosAreglo[1].get(2));
        model.setTitle("Resultados");
        model.setShadow(false);
        model.setShowDataLabels(true);
        model.setLegendPosition("w");   
      
        
	}

	public List<EdsmPreguntasResultados> getEdsmResultados() {
		return edsmResultados;
	}

	public void setEdsmResultados(List<EdsmPreguntasResultados> edsmResultados) {
		this.edsmResultados = edsmResultados;
	}
	
	public PieChartModel getModel() {
		return model;
	}
	
}
