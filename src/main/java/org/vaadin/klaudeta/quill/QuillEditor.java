package org.vaadin.klaudeta.quill;

import com.vaadin.flow.component.AbstractCompositeField;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasValidation;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import org.apache.commons.lang3.StringUtils;

import static org.vaadin.klaudeta.quill.QuillEditorComponent.EMPTY_VALUE;

public class QuillEditor extends AbstractCompositeField<Div, QuillEditor, String> implements HasValidation, HasSize {
    private Span errorMessageLabel = new Span();
    private boolean invalid;

    private QuillEditorComponent quillEditorComponent = new QuillEditorComponent();

    private Div htmlContent = new Div();

    public QuillEditor() {
        super(EMPTY_VALUE);

        getContent().add(errorMessageLabel, quillEditorComponent, htmlContent);
        htmlContent.addClassNames("ql-container", "ql-snow", "ql-readonly");
        htmlContent.setVisible(false);
        quillEditorComponent.addValueChangeListener(quillValueChangeEvent -> {
            setValue(quillValueChangeEvent.getValue());
        });

        getContent().addClassName("quill-editor");
        errorMessageLabel.addClassName("error-message");
        errorMessageLabel.setVisible(false);
        quillEditorComponent.setHeight("90%");
    }

    @Override
    protected void setPresentationValue(String newPresentationValue) {
        _setValueBasedOnReadOnly(newPresentationValue, isReadOnly());
    }

    @Override
    public void clear() {
        super.clear();
        if(isReadOnly()){
            htmlContent.getElement().removeProperty("innerHTML");
        }else{
            quillEditorComponent.setHtmlContent(null);
        }
    }

    @Override
    public void setErrorMessage(String errorMessage) {
        errorMessageLabel.setText(errorMessage);
    }

    @Override
    public String getErrorMessage() {
        return errorMessageLabel.getText();
    }

    @Override
    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
        errorMessageLabel.setVisible(invalid);
        if(errorMessageLabel.isVisible()){
            quillEditorComponent.setHeight("80%");
        }else {
            quillEditorComponent.setHeight("90%");
        }
    }

    @Override
    public boolean isInvalid() {
        return invalid;
    }

    @Override
    public void setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        _setValueBasedOnReadOnly(getValue(), readOnly);

    }

    private void _setValueBasedOnReadOnly(String value, boolean isReadOnly){
        if(isReadOnly){
            htmlContent.setVisible(true);
            htmlContent.getElement().setProperty("innerHTML", getValue());
            quillEditorComponent.setVisible(false);
        }else {
            quillEditorComponent.setVisible(true);
            quillEditorComponent.setHtmlContent(getValue());
            htmlContent.setVisible(false);
        }
    }

    public QuillToolbarConfigurator getToolbarConfigurator(){
        return quillEditorComponent;
    }

}
