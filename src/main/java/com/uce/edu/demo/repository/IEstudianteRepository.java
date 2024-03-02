package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	public void insertar (Estudiante estudiante);
	public Estudiante seleccionar(Integer id);
}
