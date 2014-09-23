package Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket;

import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Nota;
import Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket.SeguidorCarreraPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;

@SuppressWarnings("all")
public class EditarNotaPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private Nota notaOriginal;
  
  private Nota notaSeleccionada;
  
  public EditarNotaPage(final SeguidorCarreraPage page) {
    Nota _getNotaSeleccionada = page.getGetNotaSeleccionada();
    this.notaOriginal = _getNotaSeleccionada;
    Nota _getNotaSeleccionada_1 = page.getGetNotaSeleccionada();
    this.notaSeleccionada = _getNotaSeleccionada_1;
    CompoundPropertyModel<Nota> _compoundPropertyModel = new CompoundPropertyModel<Nota>(this.notaSeleccionada);
    final Form<Nota> editarNotaForm = new Form<Nota>("editarNotaForm", _compoundPropertyModel);
    TextField<String> _textField = new TextField<String>("fecha");
    this._wicketExtensionFactoryMethods.addChild(editarNotaForm, _textField);
    TextField<String> _textField_1 = new TextField<String>("descripcion");
    this._wicketExtensionFactoryMethods.addChild(editarNotaForm, _textField_1);
    CheckBox _checkBox = new CheckBox("aprobado");
    this._wicketExtensionFactoryMethods.addChild(editarNotaForm, _checkBox);
    XButton _xButton = new XButton("aceptar");
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        EditarNotaPage.this.editar(page);
      }
    };
    XButton _setOnClick = _xButton.setOnClick(_function);
    this._wicketExtensionFactoryMethods.addChild(editarNotaForm, _setOnClick);
    XButton _xButton_1 = new XButton("volver");
    final Procedure0 _function_1 = new Procedure0() {
      public void apply() {
        EditarNotaPage.this.volver(page);
      }
    };
    XButton _setOnClick_1 = _xButton_1.setOnClick(_function_1);
    this._wicketExtensionFactoryMethods.addChild(editarNotaForm, _setOnClick_1);
    this._wicketExtensionFactoryMethods.addChild(this, editarNotaForm);
  }
  
  public void volver(final SeguidorCarreraPage page) {
    page.setNotaSeleccionada(this.notaOriginal);
    this.setResponsePage(page);
  }
  
  public void editar(final SeguidorCarreraPage page) {
    this.setResponsePage(page);
  }
}
