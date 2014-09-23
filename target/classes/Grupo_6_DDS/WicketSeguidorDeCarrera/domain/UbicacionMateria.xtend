package Grupo_6_DDS.WicketSeguidorDeCarrera.domain

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.Entity
import java.io.Serializable

@Observable
class UbicacionMateria extends Entity implements Serializable{
	@Property
	String nivel
	@Property
	String modalidad
	
	def getDescripcion(){
		modalidad.concat(" - ").concat(nivel)
	}
	
	override def toString(){
		descripcion
	}
}