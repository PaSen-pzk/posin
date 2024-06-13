var vm=new Vue({
    el: "#articleEditor",
    data: {
        title: null,
        content: null,
        label: null,
        link: null
    },
    created: function () {
    },
    watch: {

    },
    mounted: function () {

    },
    methods:{
        saveDraft: function() {
            let that = this;
            let param = {
                title: that.title,
                content: document.getElementById("articleContent").value,
                label: that.label,
                link: that.link
            }
            console.log(param);
            axios
                .post(ADMIN_API_SERVICE.concat(ADMIN_SERVER.ARTICLE_DRAFT_SAVE), param)
                .then(function (response) {
                    let res = response.data;
                    if(res.code && res.code == SERVICE_RESPONSE.SUCCESS.CODE){
                        alert("保存成功");
                        window.location.replace(window.location.origin.concat("/view/article/manage/list"))
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        publish: function () {

        }
    }
});
