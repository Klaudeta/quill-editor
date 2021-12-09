package org.vaadin.klaudeta.quill;

import com.vaadin.flow.component.HasElement;

public interface QuillToolbarConfigurator extends HasElement {

    String fontDecorators = "withFontDecorators";
    String codeBlocks = "withCodeBlocks";
    String mainHeaders = "withMainHeaders";
    String lists = "withLists";
    String scripts = "withScripts";
    String indents = "withIndents";
    String directions = "withDirections";
    String sizes = "withSizes";
    String headers = "withHeaders";
    String colors = "withColors";
    String fonts = "withFonts";
    String aligns = "withAligns";
    String cleanFormats = "withCleanFormats";


    /**
     * Configuring the editor to not include the font decorators commands:
     * 'bold', 'italic', 'underline', 'strike'
     *
     * @return this instance of the {@link QuillEditorComponent} as a QuillToolbarConfiguration
     */
    default QuillToolbarConfigurator noFontDecorators(){
        getElement().setProperty(fontDecorators, false);
        return this;
    }

    /**
     * Configuring the editor to not include the codeblocks commands:
     * 'blockquote', 'code-block'
     *
     * @return this instance of the {@link QuillEditorComponent} as a QuillToolbarConfiguration
     */
    default QuillToolbarConfigurator noCodeBlocks(){
        getElement().setProperty(codeBlocks, false);
        return this;
    }

    /**
     * Configuring the editor to not include the main headers commands:
     * 'H1', 'H2'
     *
     * @return this instance of the {@link QuillEditorComponent} as a QuillToolbarConfiguration
     */
    default QuillToolbarConfigurator noMainHeaders(){
        getElement().setProperty(mainHeaders, false);
        return this;
    }

    /**
     * Configuring the editor to not include the ordered &amp; bullet lists commands:
     *
     * @return this instance of the {@link QuillEditorComponent} as a QuillToolbarConfiguration
     */
    default QuillToolbarConfigurator noLists(){
        getElement().setProperty(lists, false);
        return this;
    }

    /**
     * Configuring the editor to not include the scripts lists commands:
     *
     * @return this instance of the {@link QuillEditorComponent} as a QuillToolbarConfiguration
     */
    default QuillToolbarConfigurator noScripts(){
        getElement().setProperty(scripts, false);
        return this;
    }

    /**
     * Configuring the editor to not include the indent commands:
     *
     * @return this instance of the {@link QuillEditorComponent} as a QuillToolbarConfiguration
     */
    default QuillToolbarConfigurator noIndents(){
        getElement().setProperty(indents, false);
        return this;
    }

    /**
     * Configuring the editor to not include the directions options:
     *
     * @return this instance of the {@link QuillEditorComponent} as a QuillToolbarConfiguration
     */
    default QuillToolbarConfigurator noDirections(){
        getElement().setProperty(directions, false);
        return this;
    }

    /**
     * Configuring the editor to not include the font sizes options:
     *
     * @return this instance of the {@link QuillEditorComponent} as a QuillToolbarConfiguration
     */
    default QuillToolbarConfigurator noSizes(){
        getElement().setProperty(sizes, false);
        return this;
    }

    /**
     * Configuring the editor to not include the headers options:
     *
     * @return this instance of the {@link QuillEditorComponent} as a QuillToolbarConfiguration
     */
    default QuillToolbarConfigurator noHeaders(){
        getElement().setProperty(headers, false);
        return this;
    }

    /**
     * Configuring the editor to not include the font &amp; background color options:
     *
     * @return this instance of the {@link QuillEditorComponent} as a QuillToolbarConfiguration
     */
    default QuillToolbarConfigurator noColors(){
        getElement().setProperty(colors, false);
        return this;
    }

    /**
     * Configuring the editor to not include the font family options:
     *
     * @return this instance of the {@link QuillEditorComponent} as a QuillToolbarConfiguration
     */
    default QuillToolbarConfigurator noFonts(){
        getElement().setProperty(fonts, false);
        return this;
    }

    /**
     * Configuring the editor to not include the text alignment options:
     *
     * @return this instance of the {@link QuillEditorComponent} as a QuillToolbarConfiguration
     */
    default QuillToolbarConfigurator noAligns(){
        getElement().setProperty(aligns, false);
        return this;
    }

    /**
     * Configuring the editor to not include the clean formatting options:
     *
     * @return this instance of the {@link QuillEditorComponent} as a QuillToolbarConfiguration
     */
    default QuillToolbarConfigurator noCleanFormat(){
        getElement().setProperty(cleanFormats, false);
        return this;
    }

    /**
     * Initialize the frontend editor component in order to update the toolbar options.
     */
    void initEditor();
}
