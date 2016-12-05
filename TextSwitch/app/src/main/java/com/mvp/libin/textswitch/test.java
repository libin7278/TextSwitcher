package com.mvp.libin.textswitch;

import java.util.List;

/**
 * Created by libin on 16/12/5.
 */

public class test {

    /**
     * background : https://img.alicdn.com/tps/TB1Ph_JNpXXXXctXFXXXXXXXXXX-210-212.png
     * content : 红包百万赶紧抢啊
     * title : 确定
     */

    private UpgradeBean upgrade;
    /**
     * date_only_create_order_start : 20161101
     * date_only_create_order_end : 20161112
     * bool_shop_cart_merge_orders : false
     */

    private Double11ShopCartBean double11_shop_cart;
    /**
     * is_acting : true
     * detail_icon : https://img.alicdn.com/tps/TB1hNdWOFXXXXaRXXXXXXXXXXXX-705-60.png
     * shop_cat_icon : https://img.alicdn.com/tps/TB1SRtdOFXXXXa6aXXXXXXXXXXX-400-100.png
     * side_bar_icon : https://img.alicdn.com/tps/TB17V8XOFXXXXbSaXXXXXXXXXXX-210-212.png
     * home_cart_icon : https://img.alicdn.com/tps/TB1lnJAOFXXXXazXFXXXXXXXXXX-225-225.png
     */

    private ShopCartFlagBean shop_cart_flag;
    /**
     * is_acting : false
     * subtitle : 此商品参与双11大促，请提前加入购物车
     */

    private Double11ActionBean double11_action;
    /**
     * taobao_coupon : true
     */

    private CouponBean coupon;
    /**
     * is_online : true
     * live_login_prompt : 淘宝登录看直播，主播互动欢乐多
     * live_unlogin_prompt : 淘宝登录看直播，主播互动欢乐多
     * red_envelopes_time : 3
     * postfix :   --来自TV
     * coupon_offset : []
     */

    private TmallLiveBean tmall_live;
    /**
     * presell : {"icon":"https://img.alicdn.com/tps/TB1UuhQOFXXXXXzXVXXXXXXXXXX-46-29.png"}
     */

    private DetailBean detail;

    public UpgradeBean getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(UpgradeBean upgrade) {
        this.upgrade = upgrade;
    }

    public Double11ShopCartBean getDouble11_shop_cart() {
        return double11_shop_cart;
    }

    public void setDouble11_shop_cart(Double11ShopCartBean double11_shop_cart) {
        this.double11_shop_cart = double11_shop_cart;
    }

    public ShopCartFlagBean getShop_cart_flag() {
        return shop_cart_flag;
    }

    public void setShop_cart_flag(ShopCartFlagBean shop_cart_flag) {
        this.shop_cart_flag = shop_cart_flag;
    }

    public Double11ActionBean getDouble11_action() {
        return double11_action;
    }

    public void setDouble11_action(Double11ActionBean double11_action) {
        this.double11_action = double11_action;
    }

    public CouponBean getCoupon() {
        return coupon;
    }

    public void setCoupon(CouponBean coupon) {
        this.coupon = coupon;
    }

    public TmallLiveBean getTmall_live() {
        return tmall_live;
    }

    public void setTmall_live(TmallLiveBean tmall_live) {
        this.tmall_live = tmall_live;
    }

    public DetailBean getDetail() {
        return detail;
    }

    public void setDetail(DetailBean detail) {
        this.detail = detail;
    }

    public static class UpgradeBean {
        private String background;
        private String content;
        private String title;

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class Double11ShopCartBean {
        private String date_only_create_order_start;
        private String date_only_create_order_end;
        private boolean bool_shop_cart_merge_orders;

        public String getDate_only_create_order_start() {
            return date_only_create_order_start;
        }

        public void setDate_only_create_order_start(String date_only_create_order_start) {
            this.date_only_create_order_start = date_only_create_order_start;
        }

        public String getDate_only_create_order_end() {
            return date_only_create_order_end;
        }

        public void setDate_only_create_order_end(String date_only_create_order_end) {
            this.date_only_create_order_end = date_only_create_order_end;
        }

        public boolean isBool_shop_cart_merge_orders() {
            return bool_shop_cart_merge_orders;
        }

        public void setBool_shop_cart_merge_orders(boolean bool_shop_cart_merge_orders) {
            this.bool_shop_cart_merge_orders = bool_shop_cart_merge_orders;
        }
    }

    public static class ShopCartFlagBean {
        private boolean is_acting;
        private String detail_icon;
        private String shop_cat_icon;
        private String side_bar_icon;
        private String home_cart_icon;

        public boolean isIs_acting() {
            return is_acting;
        }

        public void setIs_acting(boolean is_acting) {
            this.is_acting = is_acting;
        }

        public String getDetail_icon() {
            return detail_icon;
        }

        public void setDetail_icon(String detail_icon) {
            this.detail_icon = detail_icon;
        }

        public String getShop_cat_icon() {
            return shop_cat_icon;
        }

        public void setShop_cat_icon(String shop_cat_icon) {
            this.shop_cat_icon = shop_cat_icon;
        }

        public String getSide_bar_icon() {
            return side_bar_icon;
        }

        public void setSide_bar_icon(String side_bar_icon) {
            this.side_bar_icon = side_bar_icon;
        }

        public String getHome_cart_icon() {
            return home_cart_icon;
        }

        public void setHome_cart_icon(String home_cart_icon) {
            this.home_cart_icon = home_cart_icon;
        }
    }

    public static class Double11ActionBean {
        private boolean is_acting;
        private String subtitle;

        public boolean isIs_acting() {
            return is_acting;
        }

        public void setIs_acting(boolean is_acting) {
            this.is_acting = is_acting;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }
    }

    public static class CouponBean {
        private boolean taobao_coupon;

        public boolean isTaobao_coupon() {
            return taobao_coupon;
        }

        public void setTaobao_coupon(boolean taobao_coupon) {
            this.taobao_coupon = taobao_coupon;
        }
    }

    public static class TmallLiveBean {
        private boolean is_online;
        private String live_login_prompt;
        private String live_unlogin_prompt;
        private int red_envelopes_time;
        private String postfix;
        private List<?> coupon_offset;

        public boolean isIs_online() {
            return is_online;
        }

        public void setIs_online(boolean is_online) {
            this.is_online = is_online;
        }

        public String getLive_login_prompt() {
            return live_login_prompt;
        }

        public void setLive_login_prompt(String live_login_prompt) {
            this.live_login_prompt = live_login_prompt;
        }

        public String getLive_unlogin_prompt() {
            return live_unlogin_prompt;
        }

        public void setLive_unlogin_prompt(String live_unlogin_prompt) {
            this.live_unlogin_prompt = live_unlogin_prompt;
        }

        public int getRed_envelopes_time() {
            return red_envelopes_time;
        }

        public void setRed_envelopes_time(int red_envelopes_time) {
            this.red_envelopes_time = red_envelopes_time;
        }

        public String getPostfix() {
            return postfix;
        }

        public void setPostfix(String postfix) {
            this.postfix = postfix;
        }

        public List<?> getCoupon_offset() {
            return coupon_offset;
        }

        public void setCoupon_offset(List<?> coupon_offset) {
            this.coupon_offset = coupon_offset;
        }
    }

    public static class DetailBean {
        /**
         * icon : https://img.alicdn.com/tps/TB1UuhQOFXXXXXzXVXXXXXXXXXX-46-29.png
         */

        private PresellBean presell;

        public PresellBean getPresell() {
            return presell;
        }

        public void setPresell(PresellBean presell) {
            this.presell = presell;
        }

        public static class PresellBean {
            private String icon;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
    }
}
