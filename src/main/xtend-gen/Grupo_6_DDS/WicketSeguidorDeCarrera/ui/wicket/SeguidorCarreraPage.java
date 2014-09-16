package Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket;

import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Materia;
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.SeguidorCarrera;
import java.util.List;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.ListChoice;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;

@SuppressWarnings("all")
public class SeguidorCarreraPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private SeguidorCarrera seguidor;
  
  public SeguidorCarreraPage() {
    SeguidorCarrera _seguidorCarrera = new SeguidorCarrera();
    this.seguidor = _seguidorCarrera;
    CompoundPropertyModel<SeguidorCarrera> _compoundPropertyModel = new CompoundPropertyModel<SeguidorCarrera>(this.seguidor);
    final Form seguidorForm = new Form<SeguidorCarrera>("seguidorCarreraForm", _compoundPropertyModel);
    this.agregarListaMaterias(seguidorForm);
    this._wicketExtensionFactoryMethods.addChild(this, seguidorForm);
  }
  
  public Object agregarAcciones(final Form parent) {
    return null;
  }
  
  public void eliminarNota(final Object object) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void agregarNota(final Object object) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void editarNota(final Object object) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void agregarMateria(final Object object) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Object agregarDetallesMateria(final Form parent) {
    return null;
  }
  
  public MarkupContainer agregarListaMaterias(final Form parent) {
    MarkupContainer _xblockexpression = null;
    {
      this.seguidor.show();
      final Materia materiaSeleccionada = this.seguidor.getMateriaSeleccionada();
      final List<Materia> materias = this.seguidor.getMaterias();
      PropertyModel<Materia> _propertyModel = new PropertyModel<Materia>(this, "materiaSeleccionada");
      final ListChoice listaMaterias = new ListChoice<Materia>("listaMaterias", _propertyModel, materias);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, listaMaterias);
    }
    return _xblockexpression;
  }
  
  public Object editar(final Materia materia) {
    return null;
  }
}
