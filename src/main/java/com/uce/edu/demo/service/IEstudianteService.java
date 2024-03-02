package com.uce.edu.demo.service;

import com.uce.edu.demo.service.to.EstudianteTO;

public interface IEstudianteService {
	
	public void guardar(EstudianteTO estudiante);
	public EstudianteTO buscar(Integer id);
}
