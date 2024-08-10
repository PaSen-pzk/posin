Vue.component('svg-icon', {
    template: '#svgIcon',
    props: {
        iconClass: {
            type: String,
            required: true
        },
        className: {
            type: String,
            default: ''
        }
    },
    data() {
        return {
            name: '',
            icons: [
                "fa fa-random",
                "fa fa-share-alt",
                "fa fa-table"
            ],
            iconList: []
        }
    },
    computed:{
        isExternal() {
            return isExternal(this.iconClass)
        },
        iconName() {
            return `#icon-${this.iconClass}`
        },
        svgClass() {
            if (this.className) {
                return 'svg-icon ' + this.className
            } else {
                return 'svg-icon'
            }
        },
        styleExternalIcon() {
            return {
                mask: `url(${this.iconClass}) no-repeat 50% 50%`,
                '-webkit-mask': `url(${this.iconClass}) no-repeat 50% 50%`
            }
        }
    },
    methods: {
    }
});
