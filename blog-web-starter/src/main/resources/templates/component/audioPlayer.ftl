
<template id="audioPlayerTemplate">
  <div>
    <audio
            @timeupdate="updateProgress"
            controls
            ref="audioRef"
            style="display: none"
    >
      <source :src="audioUrl" type="audio/mpeg" />
      您的浏览器不支持音频播放
    </audio>
    <div class="audio_right">
      <span
              v-if="!audioIsPlay"
              @click="playAudio"
              class="audio_icon"
              alt="播放"
      ><i class="el-icon-video-play"></i></span>

<#--      <img-->
<#--              v-if="!audioIsPlay"-->
<#--              @click="playAudio"-->
<#--              class="audio_icon"-->
<#--              src="/img/audio/play.png"-->
<#--              alt="播放"-->
<#--      />-->
<#--      <img-->
<#--              v-if="audioIsPlay"-->
<#--              @click="playAudio"-->
<#--              class="audio_icon"-->
<#--              src="/img/audio/pause.png"-->
<#--              alt="暂停"-->
<#--      />-->
      <span
              v-if="audioIsPlay"
              @click="playAudio"
              class="audio_icon"
              alt="暂停"
      ><i class="el-icon-video-pause"></i></span>
      <el-slider
              class="slider_box"
              v-model="currentProgress"
              :show-tooltip="false"
              @input="handleProgressChange"
      />
      <div class="audio_time">
        <span class="audio_current">{{ audioStart }}</span>
        &nbsp;/&nbsp;
        <span class="audio_total">{{ durationTime }}</span>
      </div>
      <div class="volume">
        <div class="volume_progress" v-show="audioHuds">
          <el-slider
                  vertical
                  height="100px"
                  class="volume_bar"
                  v-model="audioVolume"
                  :show-tooltip="false"
                  @change="handleAudioVolume"
          />
        </div>
<#--        <img-->
<#--                class="volume_icon"-->
<#--                v-if="audioVolume <= 0"-->
<#--                @click.stop="audioHuds = !audioHuds"-->
<#--                src="/img/audio/audio_mute.png"-->
<#--                alt=""-->
<#--        />-->
        <span
                class="volume_icon"
                v-if="audioVolume <= 0"
                @click.stop="audioHuds = !audioHuds"
                alt="">
          <svg t="1716982631302" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2411" width="200" height="200"><path d="M469.333333 106.666667v810.666666a21.333333 21.333333 0 0 1-36.42 15.086667L225.833333 725.333333H53.333333a53.393333 53.393333 0 0 1-53.333333-53.333333V352a53.393333 53.393333 0 0 1 53.333333-53.333333h172.5l207.08-207.086667A21.333333 21.333333 0 0 1 469.333333 106.666667z m146.793334 296.2a21.333333 21.333333 0 0 0-3.526667 29.96 127.366667 127.366667 0 0 1 0 158.346666 21.333333 21.333333 0 0 0 33.493333 26.433334 170.733333 170.733333 0 0 0 0-211.213334 21.333333 21.333333 0 0 0-29.966666-3.526666zM853.333333 512a340.32 340.32 0 0 0-100-241.333333 346.585333 346.585333 0 0 0-22.046666-20.213334 21.333333 21.333333 0 1 0-27.446667 32.666667c6.666667 5.586667 13.146667 11.553333 19.333333 17.726667C779.6 357.22 810.666667 432.22 810.666667 512s-31.066667 154.78-87.48 211.186667c-6.173333 6.173333-12.666667 12.14-19.333334 17.726666a21.333333 21.333333 0 1 0 27.446667 32.666667 346.585333 346.585333 0 0 0 22.046667-20.213333 340.32 340.32 0 0 0 100-241.333334z m133.173334-192.666667a508.806667 508.806667 0 0 0-112.466667-169.386666 518.346667 518.346667 0 0 0-57.533333-49.653334 21.333333 21.333333 0 0 0-25.42 34.273334 474.246667 474.246667 0 0 1 52.78 45.553333c182.993333 182.993333 182.993333 480.74 0 663.733333a474.853333 474.853333 0 0 1-52.78 45.553334 21.333333 21.333333 0 0 0 25.413333 34.273333 519.026667 519.026667 0 0 0 57.54-49.653333 512.546667 512.546667 0 0 0 112.466667-554.666667z" fill="#5C5C66" p-id="2412"></path></svg>
        </span>
<#--        <img-->
<#--                class="volume_icon"-->
<#--                v-if="audioVolume > 0"-->
<#--                @click.stop="audioHuds = !audioHuds"-->
<#--                src="/img/audio/audio_high.png"-->
<#--                alt=""-->
<#--        />-->
        <span  class="volume_icon"
               v-if="audioVolume > 0"
               @click.stop="audioHuds = !audioHuds"
               alt=""
        >
          <svg t="1716982737223" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2560" width="200" height="200"><path d="M469.333333 106.666667v810.666666a21.333333 21.333333 0 0 1-36.42 15.086667L225.833333 725.333333H53.333333a53.393333 53.393333 0 0 1-53.333333-53.333333V352a53.393333 53.393333 0 0 1 53.333333-53.333333h172.5l207.08-207.086667A21.333333 21.333333 0 0 1 469.333333 106.666667z m176.753334 299.726666a21.333333 21.333333 0 0 0-33.486667 26.433334 127.366667 127.366667 0 0 1 0 158.346666 21.333333 21.333333 0 0 0 33.493333 26.433334 170.733333 170.733333 0 0 0 0-211.213334z" fill="#5C5C66" p-id="2561"></path></svg>
        </span>
      </div>
    </div>
  </div>
</template>

<style>
  .audio_right {
    width: 230px;
    height: 40px;
    display: flex;
    align-items: center;
    background: linear-gradient(to left, #2e7bff 0%, #8ee7ff 100%);
    border-radius: 4px;
    padding: 0 10px;
    box-sizing: border-box;
    position: relative;
  }
  .audio_right .slider_box {
    width: 160px;
    height: 4px;
    border-radius: 5px;
    background-color: #f1f1f1;
    flex: 1;
    margin: 0 8px 4px;
  }
  .audio_right .audio_icon {
    width: 20px;
    height: 20px;
    margin-bottom: 4px;
    cursor: pointer;
  }
  .audio_right .audio_time {
    color: #f1f1f1;
    overflow: hidden;
    font-size: 12px;
    position: absolute;
    bottom: 3px;
    left: 80px;
  }
  .audio_right .audio_time .audio_total {
      float: right;
    }
  .audio_right .audio_time .audio_current {
    float: left;
  }
  .volume {
    position: relative;
  }
  .volume .volume_progress {
    width: 32px;
    height: 140px;
    position: absolute;
    top: -142px;
    right: -4px;
  }
  .volume .volume_bar {
    background: #fff;
    border-radius: 4px;
  }
  .volume .volume_icon {
    width: 24px;
    height: 24px;
    cursor: pointer;
  }
</style>
<style>
  .el-slider__button-wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .slider_box,
  .volume_bar .el-slider__button {
      width: 8px;
      height: 8px;
      border: none;
    }
  .slider_box,
  .volume_bar .el-slider__bar {
    background: #00db15;
  }
  .slider_box .el-slider__button-wrapper {
    width: 8px;
  }
  .volume_bar .el-slider__runway {
    margin: 0 14px !important;
  }
</style>
