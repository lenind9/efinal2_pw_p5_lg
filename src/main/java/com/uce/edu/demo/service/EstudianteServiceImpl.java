package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEstudianteRepository;
import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Override
	public void guardar(EstudianteTO estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(this.convertirTO(estudiante));
	}
	
	private Estudiante convertirTO(EstudianteTO estuTO) {
		Estudiante estu = new Estudiante();
		estu.setApellido(estuTO.getApellido());
		estu.setCedula(estuTO.getCedula());
		estu.setId(estuTO.getId());
		estu.setNombre(estuTO.getNombre());
		return estu;
	}
	
	private EstudianteTO convertir(Estudiante estu) {
		EstudianteTO estuTO = new EstudianteTO();
		estuTO.setApellido(estu.getApellido());
		estuTO.setCedula(estu.getCedula());
		estuTO.setId(estu.getId());
		estuTO.setNombre(estu.getNombre());
		return estuTO;
	}

	@Override
	public EstudianteTO buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.convertir(this.estudianteRepository.seleccionar(id));
	}

}
