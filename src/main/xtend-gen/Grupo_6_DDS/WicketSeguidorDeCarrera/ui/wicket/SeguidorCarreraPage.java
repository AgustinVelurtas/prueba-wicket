package Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket;

import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Materia;
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Nota;
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.SeguidorCarrera;
import java.util.List;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.ListChoice;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;

@SuppressWarnings("all")
public class SeguidorCarreraPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private SeguidorCarrera seguidor;
  
  public SeguidorCarreraPage() {
    SeguidorCarrera _seguidorCarrera = new SeguidorCarrera();
    this.seguidor = _seguidorCarrera;
    CompoundPropertyModel _compoundPropertyModel = new CompoundPropertyModel(this.seguidor);
    final Form seguidorForm = new Form("seguidorCarreraForm", _compoundPropertyModel);
    this.agregarListaMaterias(seguidorForm);
    this._wicketExtensionFactoryMethods.addChild(this, seguidorForm);
  }
  
  public MarkupContainer agregarAcciones(final Form parent) {
    MarkupContainer _xblockexpression = null;
    {
      XButton _xButton = new XButton("Nueva Materia");
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          Materia _materiaSeleccionada = SeguidorCarreraPage.this.seguidor.getMateriaSeleccionada();
          SeguidorCarreraPage.this.agregarMateria(_materiaSeleccionada);
        }
      };
      XButton _setOnClick = _xButton.setOnClick(_function);
      this._wicketExtensionFactoryMethods.addChild(parent, _setOnClick);
      XButton _xButton_1 = new XButton("Editar");
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          Nota _notaSeleccionada = SeguidorCarreraPage.this.seguidor.getNotaSeleccionada();
          SeguidorCarreraPage.this.editarNota(_notaSeleccionada);
        }
      };
      XButton _setOnClick_1 = _xButton_1.setOnClick(_function_1);
      this._wicketExtensionFactoryMethods.addChild(parent, _setOnClick_1);
      XButton _xButton_2 = new XButton("+");
      final Procedure0 _function_2 = new Procedure0() {
        public void apply() {
          SeguidorCarreraPage.this.agregarNota(SeguidorCarreraPage.this);
        }
      };
      XButton _setOnClick_2 = _xButton_2.setOnClick(_function_2);
      this._wicketExtensionFactoryMethods.addChild(parent, _setOnClick_2);
      XButton _xButton_3 = new XButton("-");
      final Procedure0 _function_3 = new Procedure0() {
        public void apply() {
          Nota _notaSeleccionada = SeguidorCarreraPage.this.seguidor.getNotaSeleccionada();
          SeguidorCarreraPage.this.eliminarNota(_notaSeleccionada);
        }
      };
      XButton _setOnClick_3 = _xButton_3.setOnClick(_function_3);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, _setOnClick_3);
    }
    return _xblockexpression;
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
      final List<Materia> materias = this.seguidor.getMaterias();
      final ListChoice listaMaterias = new ListChoice("listaMaterias", materias);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, listaMaterias);
    }
    return _xblockexpression;
  }
  
  public Object editar(final Materia materia) {
    return null;
  }
}
