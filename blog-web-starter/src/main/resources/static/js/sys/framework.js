const InitPortalFun = {
    //全屏展示
    requestFullScreen: function () {
        var de = document.documentElement;
        if (de.requestFullscreen) {
            de.requestFullscreen();
        } else if (de.mozRequestFullScreen) {
            de.mozRequestFullScreen();
        } else if (de.webkitRequestFullScreen) {
            de.webkitRequestFullScreen();
        }
    },
    //退出全屏
    exitFullscreen: function () {
        var de = document;
        if (de.exitFullscreen) {
            de.exitFullscreen();
        } else if (de.mozCancelFullScreen) {
            de.mozCancelFullScreen();
        } else if (de.webkitCancelFullScreen) {
            de.webkitCancelFullScreen();
        }
    },
    //刷新当前
    refreshTab: function () {
        var currentId = $('.page-tabs-content').find('.active').attr('data-id');
        var target = $('.LRADMS_iframe[data-id="' + currentId + '"]');
        var url = target.attr('src');
        //$.loading(true);
        target.attr('src', url).load(function () {
            //$.loading(false);
        });
    },
    //选中页签
    activeTab: function () {
        var currentId = $(this).data('id');
        if (!$(this).hasClass('active')) {
            $('.mainContent .LRADMS_iframe').each(function () {
                if ($(this).data('id') == currentId) {
                    $(this).show().siblings('.LRADMS_iframe').hide();
                    return false;
                }
            });
            $(this).addClass('active').siblings('.menuTab').removeClass('active');
            InitPortalFun.scrollToTab(this);
        }
    },
    //关闭其他页签
    closeOtherTabs: function () {
        $('.page-tabs-content').children("[data-id]").find('.fa-remove').parents('a').not(".active").each(function () {
            $('.LRADMS_iframe[data-id="' + $(this).data('id') + '"]').remove();
            $(this).remove();
        });
        $('.page-tabs-content').css("margin-left", "0");
    },
    //关闭当前页签
    closeTab: function () {
        var closeTabId = $(this).parents('.menuTab').data('id');
        var currentWidth = $(this).parents('.menuTab').width();
        if ($(this).parents('.menuTab').hasClass('active')) {
            if ($(this).parents('.menuTab').next('.menuTab').size()) {
                var activeId = $(this).parents('.menuTab').next('.menuTab:eq(0)').data('id');
                $(this).parents('.menuTab').next('.menuTab:eq(0)').addClass('active');

                $('.mainContent .LRADMS_iframe').each(function () {
                    if ($(this).data('id') == activeId) {
                        $(this).show().siblings('.LRADMS_iframe').hide();
                        return false;
                    }
                });
                var marginLeftVal = parseInt($('.page-tabs-content').css('margin-left'));
                if (marginLeftVal < 0) {
                    $('.page-tabs-content').animate({
                        marginLeft: (marginLeftVal + currentWidth) + 'px'
                    }, "fast");
                }
                $(this).parents('.menuTab').remove();
                $('.mainContent .LRADMS_iframe').each(function () {
                    if ($(this).data('id') == closeTabId) {
                        $(this).remove();
                        return false;
                    }
                });
            }
            if ($(this).parents('.menuTab').prev('.menuTab').size()) {
                var activeId = $(this).parents('.menuTab').prev('.menuTab:last').data('id');
                $(this).parents('.menuTab').prev('.menuTab:last').addClass('active');
                $('.mainContent .LRADMS_iframe').each(function () {
                    if ($(this).data('id') == activeId) {
                        $(this).show().siblings('.LRADMS_iframe').hide();
                        return false;
                    }
                });
                $(this).parents('.menuTab').remove();
                $('.mainContent .LRADMS_iframe').each(function () {
                    if ($(this).data('id') == closeTabId) {
                        $(this).remove();
                        return false;
                    }
                });
            }
        }
        else {
            $(this).parents('.menuTab').remove();
            $('.mainContent .LRADMS_iframe').each(function () {
                if ($(this).data('id') == closeTabId) {
                    $(this).remove();
                    return false;
                }
            });
            InitPortalFun.scrollToTab($('.menuTab.active'));
        }
        return false;
    },
    //新添页签
    addTab: function () {
        $(".navbar-custom-menu>ul>li.open").removeClass("open");
        var dataId = $(this).attr('data-id');
        if (dataId != "") {
            //top.$.cookie('nfine_currentmoduleid', dataId, { path: "/" });
        }
        var dataUrl = $(this).attr('href');
        var menuName = $.trim($(this).text());
        var flag = true;
        if (dataUrl == undefined || $.trim(dataUrl).length == 0) {
            return false;
        }
        $('.menuTab').each(function () {
            if ($(this).data('id') == dataUrl) {
                if (!$(this).hasClass('active')) {
                    $(this).addClass('active').siblings('.menuTab').removeClass('active');
                    InitPortalFun.scrollToTab(this);
                    $('.mainContent .LRADMS_iframe').each(function () {
                        if ($(this).data('id') == dataUrl) {
                            $(this).show().siblings('.LRADMS_iframe').hide();
                            return false;
                        }
                    });
                }
                flag = false;
                return false;
            }
        });
        if (flag) {
            var str = '<a href="javascript:;" class="active menuTab" data-id="' + dataUrl + '">' + menuName + ' <i class="fa fa-remove"></i></a>';
            $('.menuTab').removeClass('active');
            var str1 = '<iframe class="LRADMS_iframe" id="iframe' + dataId + '" name="iframe' + dataId + '"  width="100%" height="100%" src="' + dataUrl + '" frameborder="0" data-id="' + dataUrl + '" seamless></iframe>';
            $('.mainContent').find('iframe.LRADMS_iframe').hide();
            $('.mainContent').append(str1);
            //$.loading(true);
            $('.mainContent iframe:visible').load(function () {
                //$.loading(false);
            });
            $('.menuTabs .page-tabs-content').append(str);
            InitPortalFun.scrollToTab($('.menuTab.active'));
        }
        return false;
    },
    //页签向右滚动
    scrollTabRight: function () {
        var marginLeftVal = Math.abs(parseInt($('.page-tabs-content').css('margin-left')));
        var tabOuterWidth = InitPortalFun.calSumWidth($(".content-tabs").children().not(".menuTabs"));
        var visibleWidth = $(".content-tabs").outerWidth(true) - tabOuterWidth;
        var scrollVal = 0;
        if ($(".page-tabs-content").width() < visibleWidth) {
            return false;
        } else {
            var tabElement = $(".menuTab:first");
            var offsetVal = 0;
            while ((offsetVal + $(tabElement).outerWidth(true)) <= marginLeftVal) {
                offsetVal += $(tabElement).outerWidth(true);
                tabElement = $(tabElement).next();
            }
            offsetVal = 0;
            while ((offsetVal + $(tabElement).outerWidth(true)) < (visibleWidth) && tabElement.length > 0) {
                offsetVal += $(tabElement).outerWidth(true);
                tabElement = $(tabElement).next();
            }
            scrollVal = InitPortalFun.calSumWidth($(tabElement).prevAll());
            if (scrollVal > 0) {
                $('.page-tabs-content').animate({
                    marginLeft: 0 - scrollVal + 'px'
                }, "fast");
            }
        }
    },
    //页签向左滚动
    scrollTabLeft: function () {
        var marginLeftVal = Math.abs(parseInt($('.page-tabs-content').css('margin-left')));
        var tabOuterWidth = InitPortalFun.calSumWidth($(".content-tabs").children().not(".menuTabs"));
        var visibleWidth = $(".content-tabs").outerWidth(true) - tabOuterWidth;
        var scrollVal = 0;
        if ($(".page-tabs-content").width() < visibleWidth) {
            return false;
        } else {
            var tabElement = $(".menuTab:first");
            var offsetVal = 0;
            while ((offsetVal + $(tabElement).outerWidth(true)) <= marginLeftVal) {
                offsetVal += $(tabElement).outerWidth(true);
                tabElement = $(tabElement).next();
            }
            offsetVal = 0;
            if (InitPortalFun.calSumWidth($(tabElement).prevAll()) > visibleWidth) {
                while ((offsetVal + $(tabElement).outerWidth(true)) < (visibleWidth) && tabElement.length > 0) {
                    offsetVal += $(tabElement).outerWidth(true);
                    tabElement = $(tabElement).prev();
                }
                scrollVal = InitPortalFun.calSumWidth($(tabElement).prevAll());
            }
        }
        $('.page-tabs-content').animate({
            marginLeft: 0 - scrollVal + 'px'
        }, "fast");
    },
    //页签滚动
    scrollToTab: function (element) {
        var marginLeftVal = InitPortalFun.calSumWidth($(element).prevAll()), marginRightVal = InitPortalFun.calSumWidth($(element).nextAll());
        var tabOuterWidth = InitPortalFun.calSumWidth($(".content-tabs").children().not(".menuTabs"));
        var visibleWidth = $(".content-tabs").outerWidth(true) - tabOuterWidth;
        var scrollVal = 0;
        if ($(".page-tabs-content").outerWidth() < visibleWidth) {
            scrollVal = 0;
        } else if (marginRightVal <= (visibleWidth - $(element).outerWidth(true) - $(element).next().outerWidth(true))) {
            if ((visibleWidth - $(element).next().outerWidth(true)) > marginRightVal) {
                scrollVal = marginLeftVal;
                var tabElement = element;
                while ((scrollVal - $(tabElement).outerWidth()) > ($(".page-tabs-content").outerWidth() - visibleWidth)) {
                    scrollVal -= $(tabElement).prev().outerWidth();
                    tabElement = $(tabElement).prev();
                }
            }
        } else if (marginLeftVal > (visibleWidth - $(element).outerWidth(true) - $(element).prev().outerWidth(true))) {
            scrollVal = marginLeftVal - $(element).prev().outerWidth(true);
        }
        $('.page-tabs-content').animate({
            marginLeft: 0 - scrollVal + 'px'
        }, "fast");
    },
    calSumWidth: function (element) {
        var width = 0;
        $(element).each(function () {
            width += $(this).outerWidth(true);
        });
        return width;
    },
    init: function () {
        $('.menuItem').on('click', this.addTab);
        $('.menuTabs').on('click', '.menuTab i', this.closeTab);
        $('.menuTabs').on('click', '.menuTab', this.activeTab);
        //页签向左滚动
        $('.tabLeft').on('click', this.scrollTabLeft);
        //页签向右滚动
        $('.tabRight').on('click', this.scrollTabRight);
        //刷新当前
        $('.tabReload').on('click', this.refreshTab);
        //关闭当前页面
        $('.tabCloseCurrent').on('click', function () {
            $('.page-tabs-content').find('.active i').trigger("click");
        });
        //全部关闭
        $('.tabCloseAll').on('click', function () {
            $('.page-tabs-content').children("[data-id]").find('.fa-remove').each(function () {
                $('.LRADMS_iframe[data-id="' + $(this).data('id') + '"]').remove();
                $(this).parents('a').remove();
            });
            $('.page-tabs-content').children("[data-id]:first").each(function () {
                $('.LRADMS_iframe[data-id="' + $(this).data('id') + '"]').show();
                $(this).addClass("active");
            });
            $('.page-tabs-content').css("margin-left", "0");
        });
        //关闭其他
        $('.tabCloseOther').on('click', this.closeOtherTabs);
        //全屏
        $('.fullscreen').on('click', function () {
            if (!$(this).attr('fullscreen')) {
                $(this).attr('fullscreen', 'true');
                InitPortalFun.requestFullScreen();
            } else {
                $(this).removeAttr('fullscreen')
                InitPortalFun.exitFullscreen();
            }
        });
    }
};
const InitPortalAction = {
    //加载页面框架样式
    load: function () {
        $("body").removeClass("hold-transition")
        $("#content-wrapper").find('.mainContent').height($(window).height() - 100);
        $(window).resize(function (e) {
            $("#content-wrapper").find('.mainContent').height($(window).height() - 100);
        });
        $(".sidebar-toggle").click(function () {
            if (!$("body").hasClass("sidebar-collapse")) {
                $("body").addClass("sidebar-collapse");
            } else {
                $("body").removeClass("sidebar-collapse");
            }
        })
        $(window).load(function () {
            window.setTimeout(function () {
                $('#ajax-loader').fadeOut();
            }, 300);
        });
    },
    jsonWhere: function (data, action) {
        if (action == null) return;
        var reval = new Array();
        $(data).each(function (i, v) {
            if (action(v)) {
                reval.push(v);
            }
        })
        return reval;
    },
    initEvent: function () {
        $("#sidebar-menu li a").click(function () {
            var d = $(this), e = d.next();
            if (e.is(".treeview-menu") && e.is(":visible")) {
                e.slideUp(500, function () {
                    e.removeClass("menu-open")
                }),
                    e.parent("li").removeClass("active")
            } else if (e.is(".treeview-menu") && !e.is(":visible")) {
                var f = d.parents("ul").first(),
                    g = f.find("ul:visible").slideUp(500);
                g.removeClass("menu-open");
                var h = d.parent("li");
                e.slideDown(500, function () {
                    e.addClass("menu-open"),
                        f.find("li.active").removeClass("active"),
                        h.addClass("active");

                    var _height1 = $(window).height() - $("#sidebar-menu >li.active").position().top - 41;
                    var _height2 = $("#sidebar-menu li > ul.menu-open").height() + 10
                    if (_height2 > _height1) {
                        $("#sidebar-menu >li > ul.menu-open").css({
                            overflow: "auto",
                            height: _height1
                        })
                    }
                })
            }
            e.is(".treeview-menu");
        });
    }
};
window.onload = function() {
    InitPortalAction.load();
    InitPortalAction.initEvent();
    InitPortalFun.init();
}
