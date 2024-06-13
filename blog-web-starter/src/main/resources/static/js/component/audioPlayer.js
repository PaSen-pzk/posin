/**
 * autoplay //自动播放
 * loop //循环播放
 * onPause //音频暂停
 * onPlay //音频播放
 * onTimeupdate// 当timeupdate事件大概每秒一次，用来更新音频流的当前播放时间
 * onLoadedmetadata//当加载语音流元数据完成后，会触发该事件的回调函数，语音元数据主要是语音的长度之类的数据
 * audioUrl : String,        //试听的链接
 : isPauseTtsAudio : Boolean     //是否暂停播放试听
 */
Vue.component('audio-player', {
    template: '#audioPlayerTemplate',
    props:["audioUrl","isPauseTtsAudio"],
    data() {
        return{
            audioIsPlay: true, //音频是否在播放
            audioStart: "0:00",
            durationTime: "0:00", //音频的总时长，显示的时间格式
            duration: 0, //音频的总时长
            audioVolume:80, //音量的默认值是0.8
            audioHuds: false, //是否显示音量slider
            audioRef:null,
            currentProgress: 0
        }
    },
    watch: {
        isPauseTtsAudio: function (newVal, oldVal) {
            if(newVal) {
                this.handleCloseMusic();
            }
        }
    },
    mounted: function(){
        this.calculateDuration();
    },
    methods: {
        handleCloseMusic:function () {
            let that = this;
            that.$refs.audioRef.pause();
            that.audioIsPlay = true;
        },
        // 获取音频时长
        calculateDuration:function() {
            let that = this;
            let myVid = that.$refs.audioRef;
            myVid.loop = false;
            myVid.src = that.audioUrl;
            // 监听音频播放完毕
            myVid.addEventListener(
                "ended",
                function () {
                    that.audioIsPlay = true;
                    that.currentProgress = 0;
                },
                false
            );
            if (myVid != null) {
                myVid.oncanplay = function () {
                    that.duration = myVid.duration; // 计算音频时长
                    that.durationTime = that.transTime(myVid.duration); //换算成时间格式
                };
                myVid.volume = 0.8; // 设置默认音量50%
                // 进入页面默认开始播放
                that.$refs.audioRef.play();
                that.audioIsPlay = false;
            }
        },
        // 音频播放时间换算
        transTime:function (duration) {
            const minutes = Math.floor(duration / 60);
            const seconds = Math.floor(duration % 60);
            const formattedMinutes = String(minutes).padStart(2, "0"); //padStart(2,"0") 使用0填充使字符串长度达到2
            const formattedSeconds = String(seconds).padStart(2, "0");
            return `${formattedMinutes}:${formattedSeconds}`;
        },
        // 播放暂停控制
        playAudio: function () {
            let that = this;
            if (that.$refs.audioRef.paused) {
                that.$refs.audioRef.play();
                that.audioIsPlay = false;
            } else {
                that.$refs.audioRef.pause();
                that.audioIsPlay = true;
            }
        },
        // 根据当前播放时间，实时更新进度条
        updateProgress:function (e) {
            let that = this;
            let value = e.target.currentTime / e.target.duration;
            if (that.$refs.audioRef.play) {
                that.currentProgress = value * 100;
                that.audioStart = that.transTime(that.$refs.audioRef.currentTime);
            }
        },
        //调整播放进度
        handleProgressChange:function(val) {
            let that = this;
            console.log(val);
            if (!val) {
                return;
            }
            let currentTime = that.duration * (val / 100);
            // 更新音频的当前播放时间
            that.$refs.audioRef.currentTime = currentTime;
        },
        //调整音量
        handleAudioVolume:function(val) {
            let that = this;
            that.$refs.audioRef.volume = val / 100;
        }
    }
})

