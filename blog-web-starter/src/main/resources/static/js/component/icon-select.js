Vue.component('IconSelect', {
    template: '#iconSelectTemplate',
    props: {
        activeIcon: {
            type: String
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
    methods: {
        filterIcons() {
            this.iconList = this.icons;
            if (this.name) {
                this.iconList = this.iconList.filter(item => item.includes(this.name));
            }
        },
        selectedIcon(name) {
            this.$emit('selected', name);
            document.body.click();
        },
        reset() {
            this.name = '';
            this.iconList = this.icons;
        }
    }
});
