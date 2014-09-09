package Grupo_6_DDS.WicketSeguidorDeCarrera.domain

import java.util.ArrayList
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.Entity

@Observable
class Materia extends Entity implements Cloneable{
	@Property 
	String nombre
	@Property
	Boolean finalAprobado
	@Property
	Integer anioCursada
	@Property
	String profesor
	@Property
	ArrayList<Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Nota> notas
	@Property
	Grupo_6_DDS.WicketSeguidorDeCarrera.domain.UbicacionMateria ubicacion
	
	new(){
		notas = new ArrayList
	}
	
	def crear(Boolean aprobado, Integer anio, String prof, String modalidad, String nivel){
		finalAprobado = aprobado
		anioCursada = anio
		profesor = prof
		ubicacion.setModalidad(modalidad)
		ubicacion.setNivel(nivel)
	}
		
	def agregarNota(Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Nota nota){
		notas.add(nota)
	}
	
	def borrarNota(Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Nota nota){
		var Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Nota notita = new Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Nota
		notita = notas.findFirst[notaAux | notaAux.descripcion == nota.descripcion]
		notas.remove(notita)

	}
	
	
}