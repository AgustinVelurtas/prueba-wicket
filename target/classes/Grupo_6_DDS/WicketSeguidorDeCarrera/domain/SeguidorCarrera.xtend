package Grupo_6_DDS.WicketSeguidorDeCarrera.domain

import java.util.ArrayList
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.utils.ApplicationContext
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.HomeMaterias
import java.util.List
import java.io.Serializable

@Observable
class SeguidorCarrera implements Serializable {
	@Property
	List <Materia> materias
	@Property
	String nombre
	@Property
	Materia materiaSeleccionada
	@Property
	Nota notaSeleccionada
	
	public def getMaterias(){
		return this._materias
	}
	
	def agregarMateria(Materia materia){
		materias.add(materia)
	}
	
	def agregar(){
		var materia = new Materia
		agregarMateria(materia)
	}
	
	def show() {
		materias = new ArrayList<Materia>
		materias = getHomeMaterias().show()
	}
	
	def HomeMaterias getHomeMaterias() {
		ApplicationContext::instance.getSingleton(typeof(Materia))
	}
	
		
}