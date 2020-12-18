package org.vaadin.klaudeta.quill;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

/**
 * Test View for our {@link QuillEditor} add-on class. This class and others in the
 * test folder will not be included in the final JAR.
 */
@Route("binder")
public class QuillEditorBindingTestView extends VerticalLayout {

    public QuillEditorBindingTestView() {
        Div readOnlyContent = new Div();
        Binder<Bean> beanBinder = new Binder<>();

        TextField title = new TextField();
        QuillEditor quillEditor = new QuillEditor();
        quillEditor.setHeight("300px");

        add(title, quillEditor);

        beanBinder.forField(title).asRequired("Title is mandatory!")
        .bind(Bean::getTitle, Bean::setContent);

        beanBinder
                .forField(quillEditor)
                .asRequired("Content is mandatory")
                .bind(Bean::getContent, Bean::setContent);


        beanBinder.setBean(new Bean());
        Button save = new Button("Save");
        save.addClickListener(event -> {
            beanBinder.validate();
           if(beanBinder.isValid()){
               readOnlyContent.getElement().setProperty("innerHTML", quillEditor.getValue());
           }else {
               readOnlyContent.getElement().setProperty("innerHTML", quillEditor.getErrorMessage());
           }

        });

        add(save, readOnlyContent);

        this.setSizeFull();
    }

    static class Bean{

        String title;
        String content;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
