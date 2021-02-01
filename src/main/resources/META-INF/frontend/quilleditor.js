import { LitElement, html, css } from "lit-element";
import Quill from 'quill';

const Parchment = Quill.import('parchment');
const DirectionAttribute = Quill.import('attributors/attribute/direction');
Quill.register(DirectionAttribute, true);
const AlignClass = Quill.import('attributors/class/align');
Quill.register(AlignClass, true);
const BackgroundClass = Quill.import('attributors/class/background');
Quill.register(BackgroundClass, true);
const ColorClass = Quill.import('attributors/class/color');
Quill.register(ColorClass, true);
const DirectionClass = Quill.import('attributors/class/direction');
Quill.register(DirectionClass, true);
const FontClass = Quill.import('attributors/class/font');
Quill.register(FontClass, true);
const SizeClass = Quill.import('attributors/class/size');
Quill.register(SizeClass, true);
const AlignStyle = Quill.import('attributors/style/align');
Quill.register(AlignStyle, true);
const BackgroundStyle = Quill.import('attributors/style/background');
Quill.register(BackgroundStyle, true);
const ColorStyle = Quill.import('attributors/style/color');
Quill.register(ColorStyle, true);
const DirectionStyle = Quill.import('attributors/style/direction');
Quill.register(DirectionStyle, true);
const FontStyle = Quill.import('attributors/style/font');
Quill.register(FontStyle, true);
const SizeStyle = Quill.import('attributors/style/size');
Quill.register(SizeStyle, true);

class IndentAttributor extends Parchment.Attributor.Style {
    add (node, value) {
        if (value === 0) {
            this.remove(node)
            return true
        } else {
            return super.add(node, `${value}em`)
        }
    }
}


class QuillEditor extends LitElement{

    static get styles() {
        return css`
            :host {
                display: block;
                font-size: 14px;
            }
        `
    }

    static get properties() {
        return {
            withFontDecorators: {type: Boolean},
            withBlockCodes: {type: Boolean},
            withMainHeaders: {type: Boolean},
            withLists: {type: Boolean},
            withScripts: {type: Boolean},
            withIndents: {type: Boolean},
            withDirections: {type: Boolean},
            withSizes: {type: Boolean},
            withHeaders: {type: Boolean},
            withColors: {type: Boolean},
            withFonts: {type: Boolean},
            withAligns: {type: Boolean},
            withCleanFormat: {type: Boolean}
        }
    }

    constructor(){
        super();
        this.withFontDecorators = true;
        this.withCodeBlocks = true;
        this.withMainHeaders = true;
        this.withLists = true;
        this.withScripts = true;
        this.withIndents = true;
        this.withDirections = true;
        this.withSizes = true;
        this.withHeaders = true;
        this.withColors = true;
        this.withFonts = true;
        this.withAligns = true;
        this.withCleanFormat = true;

        this.fontDecorators = ['bold', 'italic', 'underline', 'strike'];
        this.codeBlocks = ['blockquote', 'code-block'];
        this.mainHeaders = [{ 'header': 1 }, { 'header': 2 }];
        this.lists = [{ 'list': 'ordered'}, { 'list': 'bullet' }];
        this.scripts = [{ 'script': 'sub'}, { 'script': 'super' }];
        this.indents = [{ 'indent': '-1'}, { 'indent': '+1' }];
        this.directions = [{ 'direction': 'rtl' }];
        this.sizes = [{ 'size': ['10px', false, '18px', '32px'] }];
        this.headers = [{ 'header': [1, 2, 3, 4, 5, 6, false] }];
        this.colors = [{ 'color': [] }, { 'background': [] }];
        this.fonts =  [{ 'font': [] }];
        this.aligns = [{ 'align': [] }];
        this.cleanFormat = ['clean'];

        this.toolbarOptions = [
            this.fontDecorators, this.blockCodes, this.mainHeaders, this.lists, this.scripts, this.indents,
            this.directions, this.sizes, this.headers, this.colors, this.fonts,
            this.aligns, this.cleanFormat
        ];

        let IndentStyle = new IndentAttributor('indent', 'text-indent', {
            scope: Parchment.Scope.BLOCK,
            whitelist: ['1em', '2em', '3em', '4em', '5em', '6em', '7em', '8em', '9em']
        })

        Quill.register(IndentStyle, true);

    }

    render(){
        return html`
            <slot>
            </slot>
        `
    }

    initEditor(element){
        if(element == null){
            return;
        }
        let options = [];

        if(this.withFontDecorators){
            options.push(this.fontDecorators);
        }
        if(this.withCodeBlocks){
            options.push(this.codeBlocks);
        }
        if(this.withMainHeaders){
            options.push(this.mainHeaders);
        }
        if(this.withLists){
            options.push(this.lists);
        }
        if(this.withScripts){
            options.push(this.scripts);
        }
        if(this.withIndents){
            options.push(this.indents);
        }
        if(this.withDirections){
            options.push(this.directions);
        }
        if(this.withSizes){
            options.push(this.sizes);
        }
        if(this.withHeaders){
            options.push(this.headers);
        }
        if(this.withColors){
            options.push(this.colors);
        }
        if(this.withFonts){
            options.push(this.fonts);
        }
        if(this.withAligns){
            options.push(this.aligns);
        }
        if(this.withCleanFormat){
            options.push(this.cleanFormat);
        }


        this.quillEditor = new Quill(element, {
            modules: {
                toolbar: options
            },
            theme: 'snow'
        });

        const thisThat = this;

        this.quillEditor.on('text-change', function(delta, oldDelta, source) {
            thisThat.$server.setHtml(thisThat.quillEditor.root.innerHTML);
        });

    }

    getHtml() {
        return this.quillEditor.root.innerHTML;
    }

    setHtml(htmlContent) {
        this.quillEditor.root.innerHTML = htmlContent;
    }
}

customElements.define('quill-editor', QuillEditor);