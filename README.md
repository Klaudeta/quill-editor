# Quill RichText Editor

A RichText Editor component for Vaadin Flow using the open source Quill Editor library

## Install

Add the quill-editor dependency to your pom.xml:

```xml
<dependency>
   <groupId>org.vaadin.klaudeta</groupId>
   <artifactId>quill-editor</artifactId>
   <version>1.0.0</version>
</dependency>
```
Do not forget to add the `vaadin-addons` repository:
```xml
<repository>
   <id>vaadin-addons</id>
   <url>http://maven.vaadin.com/vaadin-addons</url>
</repository>
```

### Basic Usage

Create a `QuillEditor` and configure the toolbar. Define which toolbar commands
should be removed. The default behaviour is that the toolbar will contain all 
available commands.
```java
    QuillEditor quillEditor = new QuillEditor();
    quillEditor.getToolbarConfigurator()
        .noFontDecorators()
        .noColors()
        .initEditor();

    quillEditor.setSizeFull();
    layout.add(quillEditor);
```
Binding the `QuillEditor` to a Binder<T> instance. QuillEditor extends the
`com.vaadin.flow.component.AbstractCompositeField` class so it is possible to
bind it to a Binder as with all the other Vaadin components which extend the 
`HasValue` interface.
```java
    QuillEditor quillEditor = new QuillEditor();
    Binder<Bean> beanBinder = new Binder<>();
    
    beanBinder
        .forField(quillEditor)
        .asRequired("Content is mandatory")
        .bind(Bean::getContent, Bean::setContent);

```

### Branching information

* `master` the latest version of the component, using latest stable platform version
* `v14` the version for Vaadin 14, which is the newest LTS  

## Running demos locally

1. Fork the `quill-editor` repository and clone it locally.
1. Build the project: `mvn clean install`
1. Start the test/demo server: `mvn jetty:run`
1. Navigate to http://localhost:8080 to view the demo.
