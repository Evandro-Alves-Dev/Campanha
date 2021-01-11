package com.campanha.time.requests;

import java.time.LocalDate;

import javax.persistence.ManyToOne;

import com.campanha.time.models.Time;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

public class CampanhaResquest {

	@NotNull
	private String nomeCampanha;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataInicioVigencia;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataFimVigencia;

	@ManyToOne
	private Time time;

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getNomeCampanha() {
		return nomeCampanha;
	}

	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}

	public LocalDate getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public LocalDate getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void setDataFimVigencia(LocalDate dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

}
